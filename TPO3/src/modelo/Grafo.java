package modelo;

import java.util.*;

public class Grafo<T> {

    private Map<T, Nodo<T>> nodos;

    public Grafo() {
        this.nodos = new HashMap<>();
    }

    public void agregarNodo(T dato) {
        if (!nodos.containsKey(dato)) {
            nodos.put(dato, new Nodo<>(dato));
        }
    }

    public void añadirArista(T origen, T destino) {
        Nodo<T> nodoOrigen = nodos.get(origen);
        Nodo<T> nodoDestino = nodos.get(destino);

        if (nodoOrigen != null && nodoDestino != null) {
            nodoOrigen.agregarVecino(nodoDestino);
            nodoDestino.agregarVecino(nodoOrigen); // borrar para grafo dirigido
        }
    }

    public void mostrarMatrizAdyacencia() {
        System.out.println("Matriz de adyacencia:");
        List<T> claves = new ArrayList<>(nodos.keySet());
        for (T origen : claves) {
            for (T destino : claves) {
                Nodo<T> nodoOrigen = nodos.get(origen);
                boolean conectado = false;
                for (Nodo<T> vecino : nodoOrigen.getVecinos()) {
                    if (vecino.getDato().equals(destino)) {
                        conectado = true;
                        break;  // sale del for porque ya encontro la conexión
                    }
                }
                System.out.print(conectado ? "1 " : "0 ");
            }
            System.out.println();
        }
    }


    public void bfs(T inicio) {
        if (!nodos.containsKey(inicio)) return;

        Set<T> visitados = new HashSet<>();
        Queue<Nodo<T>> cola = new LinkedList<>();

        Nodo<T> nodoInicio = nodos.get(inicio);
        cola.add(nodoInicio);
        visitados.add(inicio);

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            Nodo<T> actual = cola.poll();
            System.out.print(actual.getDato() + " ");
            for (Nodo<T> vecino : actual.getVecinos()) {
                T datoVecino = vecino.getDato();
                if (!visitados.contains(datoVecino)) {
                    visitados.add(datoVecino);
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }

    public void dfs(T inicio) {
        if (!nodos.containsKey(inicio)) return;

        Set<T> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsRec(nodos.get(inicio), visitados);
        System.out.println();
    }

    private void dfsRec(Nodo<T> actual, Set<T> visitados) {
        visitados.add(actual.getDato());
        System.out.print(actual.getDato() + " ");
        for (Nodo<T> vecino : actual.getVecinos()) {
            if (!visitados.contains(vecino.getDato())) {
                dfsRec(vecino, visitados);
            }
        }
    }
}
