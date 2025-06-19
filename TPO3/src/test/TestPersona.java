package test;

import modelo.Persona;

public class TestPersona {

    public static void main(String[] args) {
        Persona p1 = new Persona("Ana", 30);
        Persona p2 = new Persona("Ana", 30);
        Persona p3 = new Persona("Luis", 25);

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);

        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // false

        System.out.println("p1.hashCode() == p2.hashCode(): " + (p1.hashCode() == p2.hashCode())); // true
        System.out.println("p1.hashCode() == p3.hashCode(): " + (p1.hashCode() == p3.hashCode())); // muy probable false
    }
}
