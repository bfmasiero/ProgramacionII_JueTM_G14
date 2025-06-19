package test;

import modelo.Grafo;
import modelo.Persona;

public class TestIntegrado {

    public static void main(String[] args) {
        Grafo<Persona> grafo = new Grafo<>();

        Persona pedro = new Persona("Pedro", 30);
        Persona luis = new Persona("Luis", 25);
        Persona marta = new Persona("Marta", 40);
        Persona juan = new Persona("Juan", 35);

        //Agregar nodos
        grafo.agregarNodo(pedro);
        grafo.agregarNodo(luis);
        grafo.agregarNodo(marta);
        grafo.agregarNodo(juan);

        //Agregar aristas (no dirigido)
        grafo.añadirArista(pedro, luis);
        grafo.añadirArista(pedro, marta);
        grafo.añadirArista(marta, juan);

        //Matriz de adyacencia
        grafo.mostrarMatrizAdyacencia();
        //Recorrido de BFS desde Pedro
        grafo.bfs(pedro);
        //Recorrido de DFS desde Pedro
        System.out.println("Recorrido DFS desde Pedro:");
        grafo.dfs(pedro);
    }
}
