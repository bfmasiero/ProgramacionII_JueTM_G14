package model;

//Representa una arista (conexión) desde una ciudad origen hacia una ciudad destino
//con un peso o costo asociado.

public class Arista {
    String destino;
    int peso;

    //Constructor de la arista.

    public Arista(String destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    // Devuelve el nombre de la ciudad destino.
    public String getDestino() {
        return destino;
    }

    //Devuelve el peso o costo de la arista.
    public int getPeso() {
        return peso;
    }
}
