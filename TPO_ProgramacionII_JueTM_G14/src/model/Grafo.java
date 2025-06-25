package model;

import java.util.ArrayList;

public class Grafo {
    private ArrayList<String> ciudades;
    private ArrayList<ArrayList<Arista>> adyacencias;

    public Grafo() {
        ciudades = new ArrayList<>();
        adyacencias = new ArrayList<>();
    }

    public void agregarCiudad(String ciudad) {
        if (!ciudades.contains(ciudad)) {
            ciudades.add(ciudad);
            adyacencias.add(new ArrayList<>());
        }
    }

    public void agregarArista(String origen, String destino, int peso) {
        int indice = ciudades.indexOf(origen);
        if (indice != -1) {
            adyacencias.get(indice).add(new Arista(destino, peso));
        }
    }
    public void agregarAristaBidireccional(String ciudad1, String ciudad2, int peso) {
        agregarArista(ciudad1, ciudad2, peso);
        agregarArista(ciudad2, ciudad1, peso);
    }


    public ArrayList<String> getCiudades() {
        return ciudades;
    }

    public ArrayList<ArrayList<Arista>> getAdyacencias() {
        return adyacencias;
    }

    public ArrayList<Arista> getVecinos(String ciudad) {
        int indice = ciudades.indexOf(ciudad);
        if (indice != -1) {
            return adyacencias.get(indice);
        }
        return new ArrayList<>();
    }
}
