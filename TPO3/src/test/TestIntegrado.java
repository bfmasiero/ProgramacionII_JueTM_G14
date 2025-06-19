package test;

import modelo.Grafo;
import modelo.Persona;

public class TestIntegrado {

    public static void main(String[] args) {
        Grafo<Persona> grafo = new Grafo<>();

        Persona ana = new Persona("Ana", 30);
        Persona luis = new Persona("Luis", 25);
        Persona marta = new Persona("Marta", 40);
        Persona juan = new Persona("Juan", 35);

        //Agregar nodos
        grafo.agregarNodo(ana);
        grafo.agregarNodo(luis);
        grafo.agregarNodo(marta);
        grafo.agregarNodo(juan);

        //Agregar aristas (no dirigido)
        grafo.añadirArista(ana, luis);
        grafo.añadirArista(ana, marta);
        grafo.añadirArista(marta, juan);

        //Matriz de adyacencia
        grafo.mostrarMatrizAdyacencia();
        //Recorrido de BFS desde Ana
        grafo.bfs(ana);
        //Recorrido de DFS desde Ana
        System.out.println("\nRecorrido DFS desde Ana:");
        grafo.dfs(ana);
    }
}
