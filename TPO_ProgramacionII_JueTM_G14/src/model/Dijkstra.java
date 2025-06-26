package model;

import interfaces.IDijkstra;
import interfaces.IGrafo;
import java.util.ArrayList;
import java.util.Collections;

public class Dijkstra implements IDijkstra {

    @Override
    public int calcularCaminoMinimo(IGrafo grafo, String origen, String destino) {
        ArrayList<String> ciudades = grafo.getCiudades();
        int n = ciudades.size();

        ArrayList<Integer> distancias = new ArrayList<>();
        ArrayList<String> anteriores = new ArrayList<>();
        ArrayList<Boolean> visitados = new ArrayList<>();
        ArrayList<ArrayList<String>> tablaCombinada = new ArrayList<>();

        // Inicialización: todas las distancias en infinito, sin nodo anterior
        for (int i = 0; i < n; i++) {
            distancias.add(Integer.MAX_VALUE);
            anteriores.add(null);
            visitados.add(false);
        }

        // La distancia al nodo origen es 0
        int indiceOrigen = ciudades.indexOf(origen);
        distancias.set(indiceOrigen, 0);

        while (true) {
            // Buscar el nodo no visitado con menor distancia actual
            int menorDist = Integer.MAX_VALUE;
            int ciudadActual = -1;
            for (int j = 0; j < n; j++) {
                if (!visitados.get(j) && distancias.get(j) < menorDist) {
                    menorDist = distancias.get(j);
                    ciudadActual = j;
                }
            }

            // Guardar una fila con los valores actuales de distancia y nodo anterior
            ArrayList<String> filaPaso = new ArrayList<>();
            for (int c = 0; c < n; c++) {
                String distStr = (distancias.get(c) == Integer.MAX_VALUE) ? "INF" : distancias.get(c).toString();

                // Solo usamos la inicial de la ciudad anterior para abreviar
                String antStr = (anteriores.get(c) == null) ? "-" : anteriores.get(c).substring(0, 1);

                filaPaso.add("(" + distStr + "," + antStr + ")");
            }
            tablaCombinada.add(filaPaso);

            if (ciudadActual == -1) break;

            visitados.set(ciudadActual, true);
            String ciudad = ciudades.get(ciudadActual);

            // Relajar los vecinos del nodo actual
            for (Arista arista : grafo.getVecinos(ciudad)) {
                int idxVecino = ciudades.indexOf(arista.getDestino());
                if (!visitados.get(idxVecino)) {
                    int nuevaDist = distancias.get(ciudadActual) + arista.getPeso();
                    if (nuevaDist < distancias.get(idxVecino)) {
                        distancias.set(idxVecino, nuevaDist);
                        anteriores.set(idxVecino, ciudad);
                    }
                }
            }
        }

        imprimirTablaCombinada(ciudades, tablaCombinada);

        int indiceDestino = ciudades.indexOf(destino);
        if (distancias.get(indiceDestino) == Integer.MAX_VALUE) {
            System.out.println("No hay camino de " + origen + " a " + destino);
            return -1;
        }

        // Reconstruir el camino desde destino hasta origen
        ArrayList<String> camino = new ArrayList<>();
        String actual = destino;
        while (actual != null) {
            camino.add(actual);
            int idxActual = ciudades.indexOf(actual);
            actual = anteriores.get(idxActual);
        }
        Collections.reverse(camino);

        // Mostrar el camino final
        System.out.println("\nCamino mínimo de " + origen + " a " + destino + ":");
        for (int i = 0; i < camino.size(); i++) {
            System.out.print(camino.get(i));
            if (i != camino.size() - 1) System.out.print(" -> ");
        }
        System.out.println("\nDistancia total: " + distancias.get(indiceDestino));

        return distancias.get(indiceDestino);
    }

    // Imprime la tabla de pasos con (distancia, nodo anterior) por cada ciudad
    private void imprimirTablaCombinada(ArrayList<String> ciudades, ArrayList<ArrayList<String>> tabla) {
        System.out.println("\nTABLA DE PASOS (Distancia, Nodo Anterior)");

        // Encabezado
        System.out.printf("%-8s", "CIUDAD");
        for (int i = 1; i <= tabla.size(); i++) {
            System.out.printf("%-15s", "PASO" + i);
        }
        System.out.println();

        for (int i = 0; i < ciudades.size(); i++) {
            // Imprime solo la primera letra de la ciudad
            String inicial = ciudades.get(i).substring(0, 1);
            System.out.printf("%-8s", inicial);

            for (int paso = 0; paso < tabla.size(); paso++) {
                System.out.printf("%-15s", tabla.get(paso).get(i));
            }
            System.out.println();
        }

        System.out.println("\n*: INF significa infinito, porque no hay ningún camino conocido desde el nodo origen hasta ese nodo en ese momento.");
    }
}
