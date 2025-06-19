package test;

import modelo.Grafo;
import modelo.Nodo;

public class TestGrafo {

    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<>();

        //agregar nodos
        grafo.agregarNodo("A");
        grafo.agregarNodo("B");
        grafo.agregarNodo("C");
        grafo.agregarNodo("D");

        //Agregar aristas (no dirigido)
        grafo.añadirArista("A", "B");
        grafo.añadirArista("A", "C");
        grafo.añadirArista("B", "D");

        //Matriz de adyacencia
        grafo.mostrarMatrizAdyacencia();

        //Recorrido BFS desde A
        grafo.bfs("A");

        //Recorrido DFS desde A
        grafo.dfs("A");
    }
}
