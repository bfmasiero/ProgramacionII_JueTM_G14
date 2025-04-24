package test;

import modelo.Persona;
import modelo.Vehiculo;

public class TestPersonaVehiculo {

    public static void main(String[] args) {
        // Crear una persona
        Persona p = new Persona(30765430, "Sergio Perez");
        System.out.println("Persona creada:");
        p.mostrarPersona(); // Muestra la persona, la lista esta vacia porque le tengo que cargar los vehiculos

        // Crear vehiculos
        Vehiculo v1 = new Vehiculo("CDL890", "Ford Sierra");
        Vehiculo v2 = new Vehiculo("AG567RF", "Toyota Hilux");
        Vehiculo v3 = new Vehiculo("NJK890", "Alfa Romeo Mito");
        Vehiculo v4 = new Vehiculo("ETU901", "Renault Clio");
        Vehiculo v5 = new Vehiculo("AD097UP", "Chevrolet Onix");
        Vehiculo v6 = new Vehiculo("AH780PL", "Fiat Fastback");

        // Agregar vehiculos a la lista
        System.out.println("\nAgregando vehículos:");
        p.getListaVehiculos().insertarPrimero(v2);
        p.getListaVehiculos().insertarPrimero(v1);
        p.getListaVehiculos().insertarUltimo(v3);
        p.mostrarPersona();

        // Agregar vehiculo a una posición específica
        System.out.println("\nInsertando vehículo en posición 2:"); //posicion 2 visualmente, lógicamente para el programa es posicion 1
        p.getListaVehiculos().insertarPosicion(v4, 1);
        p.mostrarPersona();

        // Buscar la ubicacion de un vehículo por su nombre
        System.out.println("\nEn que posición se encuentra " + v3 +"?");
        int posicion = p.getListaVehiculos().buscarSecuencial(v3);
        System.out.println((posicion >= 0 ? (v3 + " encontrado en posición: " + (posicion+1)) : (v3 + "no encontrado"))); //visualmente pos 4, en codigo es 3

        // Obtener primer y ultimo vehículo
        System.out.println("\nObteniendo primer y último vehículo:");
        System.out.println("Primer vehículo: " + p.getListaVehiculos().obtenerPrimero());
        System.out.println("Último vehículo: " + p.getListaVehiculos().obtenerUltimo());

        // Eliminar vehículos
        System.out.println("\nEliminando vehículos:");
        System.out.println("Eliminar primero:");
        p.getListaVehiculos().eliminarPrimero();
        p.mostrarPersona();
        System.out.println("Eliminar último:");
        p.getListaVehiculos().eliminarUltimo();
        p.mostrarPersona();
        System.out.println("Eliminar vehículo en posición 2:"); //visualmente pos 2, para el codigo es 1
        p.getListaVehiculos().eliminarPosicion(1);
        p.mostrarPersona();

        // Ordenar vehículos
        System.out.println("\nOrdenando la lista:");
        p.getListaVehiculos().insertarUltimo(v5);
        p.getListaVehiculos().insertarUltimo(v6);
        System.out.println("Lista antes de ordenar:");
        p.mostrarPersona();
        p.getListaVehiculos().ordenarLista();
        System.out.println("Lista después de ordenar:");
        p.mostrarPersona();

        // Contar vehículos en lista
        System.out.println("\nCantidad de vehículos:");
        System.out.println("Número de vehículos en la lista: " + p.getListaVehiculos().cantidadElementos());
    }
}