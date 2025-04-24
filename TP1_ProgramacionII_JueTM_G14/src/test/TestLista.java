package test;

import modelo.Lista;
import modelo.Vehiculo;

// Este test sirve para poner a prueba los métodos que modificamos en la clase Lista
public class TestLista {

    public static void main(String[] args) {
        Lista lista = new Lista();

        //Lista vacia?
        System.out.println("Verificar si la lista está vacía:");
        System.out.println("¿Lista vacía? " + lista.esVacia() + "\n");

        // Agregar al principio
        System.out.println("Insertar vehículos al principio:");
        Vehiculo v1 = new Vehiculo("CDL890", "Ford Sierra");
        Vehiculo v2 = new Vehiculo("AG567RF", "Toyota Hilux");
        Vehiculo v3 = new Vehiculo("NJK890", "Alfa Romeo Mito");
        lista.insertarPrimero(v2);
        lista.insertarPrimero(v1);
        lista.insertarPrimero(v3);
        System.out.println("Lista después de insertar al principio:");
        lista.mostrarLista();
        System.out.println();

        // Agregar al final
        System.out.println("Insertar vehículos al final:");
        Vehiculo v4 = new Vehiculo("ETU901", "Renault Clio");
        Vehiculo v5 = new Vehiculo("AD097UP", "Chevrolet Onix");
        lista.insertarUltimo(v4);
        lista.insertarUltimo(v5);
        System.out.println("Lista después de insertar al final:");
        lista.mostrarLista();
        System.out.println();

        // Agregar vehiculo en x lugar
        System.out.println("Insertar vehículo en posición específica:");
        Vehiculo v6 = new Vehiculo("AH780PL", "Fiat Fastback");
        lista.insertarPosicion(v6, 2); // Insertar en posición 2
        System.out.println("Lista después de insertar en posición elegida:");
        lista.mostrarLista();
        System.out.println();

        // Obtener vehiculo A y vehiculo Z
        System.out.println("Obtener primer y último vehículo:");
        System.out.println("Primer vehículo: " + lista.obtenerPrimero());
        System.out.println("Último vehículo: " + lista.obtenerUltimo());
        System.out.println();

        // Obtener vehiculo en posición x
        System.out.println("Obtener vehículo en posición específica:");
        System.out.println("Vehículo en la posición elegida: " + lista.obtenerPosicion(2));
        System.out.println();

        // Buscar vehiculo
        System.out.println("Buscar un vehículo:");
        int posicion = lista.buscarSecuencial(v6); // Buscar el Peugeot 208
        System.out.println( v6 + " encontrado en posición: " + (posicion >= 0 ? posicion : "no encontrado"));
        System.out.println();

        // Eliminar vehiculos
        System.out.println("Eliminar vehículos:");
        System.out.println("Eliminar primero:");
        lista.eliminarPrimero();
        lista.mostrarLista();
        System.out.println("\nEliminar último:");
        lista.eliminarUltimo();
        lista.mostrarLista();
        System.out.println("\nEliminar vehículo en posición elegida:");
        lista.eliminarPosicion(2);
        lista.mostrarLista();
        System.out.println();

        // Ordenar lista
        System.out.println("Ordenar la lista:");
        Vehiculo v7 = new Vehiculo("CAE951", "Chevrolet Vectra");
        Vehiculo v8 = new Vehiculo("OCR882", "Audi A3");
        lista.insertarUltimo(v7);
        lista.insertarUltimo(v8);
        System.out.println("Lista antes de ordenar:");
        lista.mostrarLista();
        lista.ordenarLista();
        System.out.println("Lista después de ordenar:");
        lista.mostrarLista();
        System.out.println();

        // Contar vehiculos
        System.out.println("Contar vehículos:");
        System.out.println("Cantidad de vehículos en la lista: " + lista.cantidadElementos());
        System.out.println();
    }
}