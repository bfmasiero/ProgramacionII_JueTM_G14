package interfaces;

import model.Arista;
import java.util.ArrayList;

public interface IGrafo {
    void agregarCiudad(String ciudad);
    void agregarArista(String origen, String destino, int peso);
    void agregarAristaBidireccional(String ciudad1, String ciudad2, int peso);
    ArrayList<String> getCiudades();
    ArrayList<ArrayList<Arista>> getAdyacencias();
    ArrayList<Arista> getVecinos(String ciudad);
}
