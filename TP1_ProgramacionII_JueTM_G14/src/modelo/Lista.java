package modelo;

import interfaces.ILista;
import interfaces.INodo;

public class Lista implements ILista {
    private INodo primero;
    private INodo ultimo;

    // Constructor
    public Lista() {
        this.primero = null;
        this.ultimo = null;
    }

    // Verificar si la lista está vacía
    @Override
    public boolean esVacia() {
        if (primero == null){
            return true;
        }else {
            return false;
        }
    }

    // Insertar al principio
    @Override
    public void insertarPrimero(Vehiculo dato) {
        INodo nuevo = new Nodo(dato);
        if (esVacia()) {
            primero = nuevo;
            ultimo = nuevo; // porque es el unico
        } else {
            nuevo.setSiguiente(primero);
            primero.setAnterior(nuevo);
            primero = nuevo;
        }
    }

    // Agregar al final
    @Override
    public void insertarUltimo(Vehiculo dato) {
        INodo nuevo = new Nodo(dato);
        if (esVacia()) {
            primero = nuevo;
            ultimo = nuevo; // porque es el unico
        } else {
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo; // Actualizo "ultimo"
        }
    }

    // Agregar en una posición especifica
    @Override
    public void insertarPosicion(Vehiculo dato, int posicion) {
        if (posicion == 0) {
            insertarPrimero(dato);
            return;
        }

        INodo nuevo = new Nodo(dato);
        INodo actual = primero;
        int contador = 0;

        while (actual != null && contador < posicion - 1) {
            actual = actual.getSiguiente();
            contador++;
        }

        if (actual == null) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }

        nuevo.setSiguiente(actual.getSiguiente());
        if (actual.getSiguiente() != null) {
            actual.getSiguiente().setAnterior(nuevo);
        } else {
            ultimo = nuevo; // es el último nodo, entonces actualiza "ultimo"
        }
        actual.setSiguiente(nuevo);
        nuevo.setAnterior(actual);
    }

    // Eliminar el primer nodo
    @Override
    public void eliminarPrimero() {
        if (!esVacia()) {
            if (primero == ultimo) { // Si hay solo un nodo
                primero = null;
                ultimo = null;
            } else {
                primero = primero.getSiguiente();
                primero.setAnterior(null);
            }
        }
    }

    // Eliminar el ultimo nodo
    @Override
    public void eliminarUltimo() {
        if (!esVacia()) {
            if (primero == ultimo) { // Si hay solo un nodo
                primero = null;
                ultimo = null;
            } else {
                ultimo = ultimo.getAnterior();
                ultimo.setSiguiente(null);
            }
        }
    }

    // Eliminar nodo en una posicion especifica
    @Override
    public void eliminarPosicion(int posicion) {
        if (esVacia()) return;

        if (posicion == 0) {
            eliminarPrimero();
            return;
        }

        INodo actual = primero;
        int contador = 0;

        while (actual.getSiguiente() != null && contador < posicion - 1) {
            actual = actual.getSiguiente();
            contador++;
        }

        if (actual.getSiguiente() == null) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }

        INodo eliminado = actual.getSiguiente();
        actual.setSiguiente(eliminado.getSiguiente());
        if (eliminado.getSiguiente() != null) {
            eliminado.getSiguiente().setAnterior(actual);
        } else {
            ultimo = actual; // Si eliminas el ultimo nodo, el que llamamos "actual" pasa a ser el nuevo "ultimo"
        }
    }

    // pedir el primer nodo
    @Override
    public Vehiculo obtenerPrimero() {
        if (esVacia()) throw new IllegalStateException("Lista vacía");
        return primero.getDato();
    }

    // pedir el ultimo nodo
    @Override
    public Vehiculo obtenerUltimo() {
        if (esVacia()) throw new IllegalStateException("Lista vacía");
        return ultimo.getDato();
    }

    // Obtener nodo de una posicion x
    @Override
    public Vehiculo obtenerPosicion(int posicion) {
        INodo actual = primero;
        int contador = 0;

        while (actual != null && contador < posicion) {
            actual = actual.getSiguiente();
            contador++;
        }

        if (actual == null) throw new IndexOutOfBoundsException("Posición fuera de rango");
        return actual.getDato();
    }

    // Largo de la lista
    @Override
    public int cantidadElementos() {
        int contador = 0;
        INodo actual = primero;

        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }

        return contador;
    }

    // Buscar un dato de manera secuencial
    @Override
    public int buscarSecuencial(Vehiculo dato) {
        INodo actual = primero;
        int posicion = 0;

        while (actual != null) {
            if (actual.getDato().equals(dato)) { //El metodo .equals() me sirve como un ==
                return posicion;
            }
            actual = actual.getSiguiente();
            posicion++;
        }

        return -1; // No encontrado
    }

    // Ordenar la lista en forma ascendente (por patente, AB... AC... NLA...)
    @Override
    public void ordenarLista() {
        if (esVacia() || primero.getSiguiente() == null) return; // || es igual a OR, es true si A o B son verdaderas

        INodo actual = primero; //De donde empiezo a recorrer

        while (actual != null) {
            INodo menor = actual; // Supongo que el menor es el nodo actual
            INodo iterador = actual.getSiguiente(); // Comienzo a buscar desde el siguiente nodo

            while (iterador != null) { //Hago la comparacion para definir al menor
                if (iterador.getDato().getPatente().compareTo(menor.getDato().getPatente()) < 0) {
                    menor = iterador; // Si el iterador es mas chico que el menor actual, se convierte en el menor
                }
                iterador = iterador.getSiguiente(); // Avanzamos al siguiente nodo
            }

            // Intercambio los datos entre el nodo actual y el de menor valor
            if (menor != actual) {
                Vehiculo temp = actual.getDato();
                actual.setDato(menor.getDato());
                menor.setDato(temp);
            }

            actual = actual.getSiguiente(); // Avanzo al siguiente nodo y repito
        }
    }

    // Mostrar lista desde el principio hasta el final
    @Override
    public void mostrarLista() {
        INodo actual = primero;
        while (actual != null) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getSiguiente();
        }
        System.out.println("Final de la lista");
    }
}