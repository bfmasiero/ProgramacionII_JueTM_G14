package test;

import modelo.Nodo;

public class TestNodo {

    public static void main(String[] args) {
        Nodo<String> nodoA = new Nodo<>("A");
        Nodo<String> nodoB = new Nodo<>("B");
        Nodo<String> nodoC = new Nodo<>("C");

        nodoA.agregarVecino(nodoB);
        nodoA.agregarVecino(nodoC);
        nodoB.agregarVecino(nodoC);

        System.out.println("Nodo A: " + nodoA.getDato());
        System.out.print("Vecinos de A: ");
        for (Nodo<String> vecino : nodoA.getVecinos()) {
            System.out.print(vecino.getDato() + " ");
        }
        System.out.println();

        System.out.println("Nodo B: " + nodoB.getDato());
        System.out.print("Vecinos de B: ");
        for (Nodo<String> vecino : nodoB.getVecinos()) {
            System.out.print(vecino.getDato() + " ");
        }
        System.out.println();
    }
}
