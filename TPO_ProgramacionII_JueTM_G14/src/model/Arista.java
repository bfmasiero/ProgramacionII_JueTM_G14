package model;

public class Arista {
    String destino;
    int peso;

    public Arista(String destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public String getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }
}