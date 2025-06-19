package modelo;

import java.util.Comparator;

public class ComparadorPorNombre implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        return p1.getNombre().compareToIgnoreCase(p2.getNombre());
    }
}