package model;

import interfaces.IGrafo;
import java.util.ArrayList;

public class Grafo implements IGrafo {
    private ArrayList<String> ciudades;
    private ArrayList<ArrayList<Arista>> adyacencias;

    public Grafo() {
        ciudades = new ArrayList<>();
        adyacencias = new ArrayList<>();
    }

    // Agrega una nueva ciudad al grafo si no estaba incluida
    @Override
    public void agregarCiudad(String ciudad) {
        if (!ciudades.contains(ciudad)) {
            ciudades.add(ciudad);
            adyacencias.add(new ArrayList<>());
        }
    }

    // Agrega una arista dirigida desde una ciudad a otra
    @Override
    public void agregarArista(String origen, String destino, int peso) {
        int indice = ciudades.indexOf(origen);
        if (indice != -1) {
            adyacencias.get(indice).add(new Arista(destino, peso));
        }
    }

    // Agrega una arista en ambos sentidos (grafo no dirigido)
    @Override
    public void agregarAristaBidireccional(String ciudad1, String ciudad2, int peso) {
        agregarArista(ciudad1, ciudad2, peso);
        agregarArista(ciudad2, ciudad1, peso);
    }

    @Override
    public ArrayList<String> getCiudades() {
        return ciudades;
    }

    @Override
    public ArrayList<ArrayList<Arista>> getAdyacencias() {
        return adyacencias;
    }

    // Devuelve la lista de vecinos (aristas salientes) de una ciudad
    @Override
    public ArrayList<Arista> getVecinos(String ciudad) {
        int indice = ciudades.indexOf(ciudad);
        if (indice != -1) {
            return adyacencias.get(indice);
        }
        return new ArrayList<>();
    }
}
