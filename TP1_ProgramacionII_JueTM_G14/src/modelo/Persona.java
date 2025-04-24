package modelo;

import interfaces.ILista;

public class Persona {
    private int dni;
    private String nombre;
    private ILista listaVehiculos; // Lista doblemente enlazada para manejar vehículos

    // Constructor
    public Persona(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.listaVehiculos = new Lista(); // Se inicializa la lista
    }

    // Getters y Setters
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ILista getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ILista listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }


    @Override
    public String toString() {
        return "Persona [dni=" + dni + ", nombre=" + nombre + "]";
    }

    public void mostrarPersona() {
        System.out.println("Información de la persona:");
        System.out.println("DNI: " + dni + "\nNombre: " + nombre);
        System.out.println("Vehículos asociados:");
        if (listaVehiculos.esVacia()) {
            System.out.println("La lista de vehículos está vacía.");
        } else {
            listaVehiculos.mostrarLista();
        }
    }
}