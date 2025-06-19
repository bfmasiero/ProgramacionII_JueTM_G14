package test;

import interfaces.IArbolBinario;
import modelo.Persona;
import modelo.ComparadorPorDNI;

public class TestInsercionRecorridoDNI {
    public static void main(String[] args) {
        System.out.println("=== TEST 1: INSERCIÓN Y RECORRIDOS POR DNI ===");

        IArbolBinario<Persona> arbolPorDNI =
                new modelo.ArbolBinario<>(new ComparadorPorDNI());

        arbolPorDNI.insertar(new Persona("Juan Pérez",       "34567812"));
        arbolPorDNI.insertar(new Persona("Ana Gómez",        "25889430"));
        arbolPorDNI.insertar(new Persona("Carlos Rodríguez", "12876542"));
        arbolPorDNI.insertar(new Persona("Luis García",      "9435882"));
        arbolPorDNI.insertar(new Persona("Isabel Ruiz",      "10987343"));
        arbolPorDNI.insertar(new Persona("Pedro Sánchez",    "23098125"));
        arbolPorDNI.insertar(new Persona("Marta López",      "20760445"));
        arbolPorDNI.insertar(new Persona("Antonio Ramírez",  "19023543"));
        arbolPorDNI.insertar(new Persona("Laura Díaz",       "39679012"));
        arbolPorDNI.insertar(new Persona("Javier Martínez",  "35550672"));
        arbolPorDNI.insertar(new Persona("Manuel Pérez",     "38445290"));
        arbolPorDNI.insertar(new Persona("Fernando Torres",  "35671332"));
        arbolPorDNI.insertar(new Persona("Elena Fernández",  "4554902"));
        arbolPorDNI.insertar(new Persona("Sofía Fernández",  "40665092"));
        arbolPorDNI.insertar(new Persona("Gustavo Morales",  "40998757"));

        System.out.println("\n-> RECORRIDO PREORDEN (por DNI):");
        arbolPorDNI.preorden();

        System.out.println("\n-> RECORRIDO INORDEN (por DNI):");
        arbolPorDNI.inorden();

        System.out.println("\n-> RECORRIDO POSTORDEN (por DNI):");
        arbolPorDNI.postorden();

        System.out.println("=== FIN TEST 1 ===");
    }
}