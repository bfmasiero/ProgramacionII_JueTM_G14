package test;

import model.*;
import interfaces.IDijkstra;

public class TestDijkstra {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        grafo.agregarCiudad("A");
        grafo.agregarCiudad("B");
        grafo.agregarCiudad("C");

        grafo.agregarAristaBidireccional("A", "B", 5);
        grafo.agregarAristaBidireccional("B", "C", 3);
        grafo.agregarAristaBidireccional("A", "C", 10);

        // Instanciar el algoritmo Dijkstra
        IDijkstra algoritmo = new Dijkstra();
        int distancia = algoritmo.calcularCaminoMinimo(grafo, "A", "C");
        // El camino más corto debe ser A -> B -> C con peso 8

        assert distancia == 8 : "Distancia de A a C debe ser 8";

        System.out.println("TestDijkstra PASÓ");
    }
}
