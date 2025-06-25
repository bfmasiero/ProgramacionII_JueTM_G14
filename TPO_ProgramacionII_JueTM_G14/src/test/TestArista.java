import model.Arista;

public class TestArista {
    public static void main(String[] args) {
        Arista a = new Arista("B", 5);

        assert a.getDestino().equals("B") : "Destino debe ser B";
        assert a.getPeso() == 5 : "Peso debe ser 5";

        System.out.println("TestArista PASÓ");
    }
}
