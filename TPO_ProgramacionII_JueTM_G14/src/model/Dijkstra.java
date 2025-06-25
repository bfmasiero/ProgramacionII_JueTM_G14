package model;

import java.util.ArrayList;
import java.util.Collections;

public class Dijkstra {

    public static int calcularCaminoMinimo(Grafo grafo, String origen, String destino) {
        ArrayList<String> ciudades = grafo.getCiudades();
        int n = ciudades.size();

        ArrayList<Integer> distancias = new ArrayList<>();
        ArrayList<String> anteriores = new ArrayList<>();
        ArrayList<Boolean> visitados = new ArrayList<>();

        // Tabla combinada: en cada celda guardamos "(distancia,nodoAnterior)"
        ArrayList<ArrayList<String>> tablaCombinada = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            distancias.add(Integer.MAX_VALUE);
            anteriores.add(null);
            visitados.add(false);
        }

        int indiceOrigen = ciudades.indexOf(origen);
        distancias.set(indiceOrigen, 0);

        int paso = 0;

        while (true) {
            int menorDist = Integer.MAX_VALUE;
            int ciudadActual = -1;
            for (int j = 0; j < n; j++) {
                if (!visitados.get(j) && distancias.get(j) < menorDist) {
                    menorDist = distancias.get(j);
                    ciudadActual = j;
                }
            }

            paso++;

            // Construir fila con (distancia,nodoAnterior) para cada ciudad en este paso
            ArrayList<String> filaPaso = new ArrayList<>();
            for (int c = 0; c < n; c++) {
                String distStr = (distancias.get(c) == Integer.MAX_VALUE) ? "INF" : distancias.get(c).toString();
                String antStr;
                if (anteriores.get(c) == null) {
                    antStr = "-";
                } else {
                    antStr = anteriores.get(c).substring(0, 1);  // Solo inicial
                }
                filaPaso.add("(" + distStr + "," + antStr + ")");
            }
            tablaCombinada.add(filaPaso);

            if (ciudadActual == -1) {
                break;
            }

            visitados.set(ciudadActual, true);
            String ciudad = ciudades.get(ciudadActual);

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

        // Reconstruir camino
        ArrayList<String> camino = new ArrayList<>();
        String actual = destino;
        while (actual != null) {
            camino.add(actual);
            int idxActual = ciudades.indexOf(actual);
            actual = anteriores.get(idxActual);
        }
        Collections.reverse(camino);

        System.out.println("\nCamino mínimo de " + origen + " a " + destino + ":");
        for (int i = 0; i < camino.size(); i++) {
            System.out.print(camino.get(i));
            if (i != camino.size() - 1) System.out.print(" -> ");
        }
        System.out.println("\nDistancia total: " + distancias.get(indiceDestino));

        return distancias.get(indiceDestino);
    }

    private static void imprimirTablaCombinada(ArrayList<String> ciudades, ArrayList<ArrayList<String>> tabla) {
        System.out.println("\nTABLA DE PASOS (Distancia, Nodo Anterior)");

        System.out.print("CIUDAD  ");
        for (int i = 1; i <= tabla.size(); i++) {
            System.out.printf(" PASO%-4d", i);
        }
        System.out.println();

        for (int i = 0; i < ciudades.size(); i++) {

            // Selecciona la inicial de la ciudad
            String inicial = ciudades.get(i).substring(0,1);
            System.out.printf("%-7s", inicial);

            for (int paso = 0; paso < tabla.size(); paso++) {
                System.out.printf("%-12s", tabla.get(paso).get(i));
            }
            System.out.println();
        }
        System.out.println("*: INF significa infinito, porque no hay ningún camino conocido desde el nodo origen hasta ese nodo en ese momento.");
    }
}
