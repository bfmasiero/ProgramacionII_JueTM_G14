package modelo;

import java.util.Comparator;

public class ComparadorPorDNI implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        // Convertimos cada DNI a int para comparar numéricamente
        int dni1 = Integer.parseInt(p1.getDni());
        int dni2 = Integer.parseInt(p2.getDni());
        return Integer.compare(dni1, dni2);
    }
}