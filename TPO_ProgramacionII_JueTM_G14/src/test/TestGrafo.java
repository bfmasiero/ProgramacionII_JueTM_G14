package test;

import model.Arista;
import model.Grafo;

import java.util.ArrayList;

public class TestGrafo {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        grafo.agregarCiudad("A");
        grafo.agregarCiudad("B");

        grafo.agregarArista("A", "B", 10);

        ArrayList<Arista> vecinos = grafo.getVecinos("A");
        assert vecinos.size() == 1 : "A debe tener 1 vecino";
        assert vecinos.get(0).getDestino().equals("B") : "Vecino debe ser B";
        assert vecinos.get(0).getPeso() == 10 : "Peso debe ser 10";

        ArrayList<String> ciudades = grafo.getCiudades();
        assert ciudades.size() == 2 : "Debe haber 2 ciudades";
        assert ciudades.contains("A") : "Debe contener A";
        assert ciudades.contains("B") : "Debe contener B";

        System.out.println("TestGrafo PASÓ");
    }
}
