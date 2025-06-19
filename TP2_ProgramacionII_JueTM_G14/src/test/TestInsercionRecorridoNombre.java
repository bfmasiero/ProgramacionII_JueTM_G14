package test;

import interfaces.IArbolBinario;
import modelo.Persona;
import modelo.ComparadorPorNombre;

public class TestInsercionRecorridoNombre {
    public static void main(String[] args) {
        System.out.println("=== TEST 3: INSERCIÓN Y RECORRIDO POR NOMBRE ===");

        IArbolBinario<Persona> arbolPorNombre =
                new modelo.ArbolBinario<>(new ComparadorPorNombre());

        arbolPorNombre.insertar(new Persona("Juan Pérez",       "34567812"));
        arbolPorNombre.insertar(new Persona("Ana Gómez",        "25889430"));
        arbolPorNombre.insertar(new Persona("Carlos Rodríguez", "12876542"));
        arbolPorNombre.insertar(new Persona("Luis García",      "9435882"));
        arbolPorNombre.insertar(new Persona("Isabel Ruiz",      "10987343"));
        arbolPorNombre.insertar(new Persona("Pedro Sánchez",    "23098125"));
        arbolPorNombre.insertar(new Persona("Marta López",      "20760445"));
        arbolPorNombre.insertar(new Persona("Antonio Ramírez",  "19023543"));
        arbolPorNombre.insertar(new Persona("Laura Díaz",       "39679012"));
        arbolPorNombre.insertar(new Persona("Javier Martínez",  "35550672"));
        arbolPorNombre.insertar(new Persona("Manuel Pérez",     "38445290"));
        arbolPorNombre.insertar(new Persona("Fernando Torres",  "35671332"));
        arbolPorNombre.insertar(new Persona("Elena Fernández",  "4554902"));
        arbolPorNombre.insertar(new Persona("Sofía Fernández",  "40665092"));
        arbolPorNombre.insertar(new Persona("Gustavo Morales",  "40998757"));

        System.out.println("\n-> RECORRIDO INORDEN (por NOMBRE):");
        arbolPorNombre.inorden();

        System.out.println("=== FIN TEST 3 ===");
    }
}