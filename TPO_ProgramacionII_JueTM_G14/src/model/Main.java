package model;

import interfaces.IDijkstra;
import interfaces.IGrafo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IGrafo grafo = new Grafo();
        IDijkstra algoritmo = new Dijkstra();

        // Cargar ciudades al grafo
        grafo.agregarCiudad("Amsterdam");
        grafo.agregarCiudad("Buenos Aires");
        grafo.agregarCiudad("California");
        grafo.agregarCiudad("Douglas");
        grafo.agregarCiudad("El Cairo");
        grafo.agregarCiudad("Filadelfia");

        Scanner scanner = new Scanner(System.in);

        // Preguntar al usuario si el grafo es dirigido
        System.out.print("¿El grafo es dirigido? (S/N): ");
        String respuesta = scanner.nextLine().trim().toUpperCase();
        boolean dirigido = respuesta.equals("S");

        // Agregar las conexiones según la orientación seleccionada
        if (dirigido) {
            grafo.agregarArista("Amsterdam", "Buenos Aires", 4);
            grafo.agregarArista("Amsterdam", "California", 2);
            grafo.agregarArista("Buenos Aires", "California", 5);
            grafo.agregarArista("Buenos Aires", "Douglas", 10);
            grafo.agregarArista("California", "El Cairo", 3);
            grafo.agregarArista("El Cairo", "Douglas", 4);
            grafo.agregarArista("Douglas", "Filadelfia", 11);
        } else {
            grafo.agregarAristaBidireccional("Amsterdam", "Buenos Aires", 4);
            grafo.agregarAristaBidireccional("Amsterdam", "California", 2);
            grafo.agregarAristaBidireccional("Buenos Aires", "California", 5);
            grafo.agregarAristaBidireccional("Buenos Aires", "Douglas", 10);
            grafo.agregarAristaBidireccional("California", "El Cairo", 3);
            grafo.agregarAristaBidireccional("El Cairo", "Douglas", 4);
            grafo.agregarAristaBidireccional("Douglas", "Filadelfia", 11);
        }

        // Mostrar las ciudades disponibles
        System.out.println("Ciudades disponibles:");
        for (String ciudad : grafo.getCiudades()) {
            System.out.println("- " + ciudad);
        }

        // Pedir ciudad origen y destino
        System.out.print("Ingrese la ciudad origen: ");
        String origen = scanner.nextLine();

        System.out.print("Ingrese la ciudad destino: ");
        String destino = scanner.nextLine();

        // Ejecutar el algoritmo de Dijkstra
        algoritmo.calcularCaminoMinimo(grafo, origen, destino);
    }
}
