package modelo;

import interfaces.IPersona;

public class Persona implements IPersona {
    private String nombre;
    private String dni;

    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Persona { nombre='" + nombre + "', dni='" + dni + "' }";
    }
}