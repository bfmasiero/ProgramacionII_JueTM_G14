package modelo;

import interfaces.IArbolBinario;
import interfaces.IPersona;
import java.util.Comparator;

public class ArbolBinario<T extends IPersona> implements IArbolBinario<T> {

    private Nodo<T> raiz;
    private Comparator<? super T> comparador; //Con el super puedo pasar datos de cualquier tipo

    public ArbolBinario(Comparator<? super T> comparador) {
        this.raiz = null;
        this.comparador = comparador;
    }

    @Override
    public void insertar(T elemento) {
        raiz = insertarRec(raiz, elemento);
    }

    private Nodo<T> insertarRec(Nodo<T> nodoActual, T elemento) {
        if (nodoActual == null) {
            return new Nodo<>(elemento);
        }
        if (comparador.compare(elemento, nodoActual.getDato()) < 0) {
            nodoActual.setIzquierdo(insertarRec(nodoActual.getIzquierdo(), elemento));
        } else {
            nodoActual.setDerecho(insertarRec(nodoActual.getDerecho(), elemento));
        }
        return nodoActual;
    }

    @Override
    public T buscar(T elementoClave) {
        return buscarRec(raiz, elementoClave);
    }

    private T buscarRec(Nodo<T> nodoActual, T elementoClave) {
        if (nodoActual == null) {
            return null;
        }
        int cmp = comparador.compare(elementoClave, nodoActual.getDato());
        if (cmp == 0) {
            return nodoActual.getDato();
        } else if (cmp < 0) {
            return buscarRec(nodoActual.getIzquierdo(), elementoClave);
        } else {
            return buscarRec(nodoActual.getDerecho(), elementoClave);
        }
    }

    @Override
    public void eliminar(T elementoClave) {
        raiz = eliminarRec(raiz, elementoClave);
    }

    private Nodo<T> eliminarRec(Nodo<T> nodoActual, T elementoClave) {
        if (nodoActual == null) {
            return null;
        }
        int cmp = comparador.compare(elementoClave, nodoActual.getDato());
        if (cmp < 0) {
            nodoActual.setIzquierdo(eliminarRec(nodoActual.getIzquierdo(), elementoClave));
        } else if (cmp > 0) {
            nodoActual.setDerecho(eliminarRec(nodoActual.getDerecho(), elementoClave));
        } else {
            // Si encuentro el nodo a eliminar, existen estos tres casos:
            if (nodoActual.getIzquierdo() == null && nodoActual.getDerecho() == null) {
                return null;
            }
            if (nodoActual.getIzquierdo() == null) {
                return nodoActual.getDerecho();
            } else if (nodoActual.getDerecho() == null) {
                return nodoActual.getIzquierdo();
            }
            // Dos hijos → tomar sucesor (hay que agarrar el minimo del subarbol derecho)
            Nodo<T> sucesor = encontrarMin(nodoActual.getDerecho());
            nodoActual.setDato(sucesor.getDato());
            nodoActual.setDerecho(eliminarRec(nodoActual.getDerecho(), sucesor.getDato()));
        }
        return nodoActual;
    }

    private Nodo<T> encontrarMin(Nodo<T> nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }

    @Override
    public void preorden() {
        preordenRec(raiz);
    }

    private void preordenRec(Nodo<T> nodoActual) {
        if (nodoActual != null) {
            System.out.println(nodoActual.getDato());
            preordenRec(nodoActual.getIzquierdo());
            preordenRec(nodoActual.getDerecho());
        }
    }

    @Override
    public void inorden() {
        inordenRec(raiz);
    }

    private void inordenRec(Nodo<T> nodoActual) {
        if (nodoActual != null) {
            inordenRec(nodoActual.getIzquierdo());
            System.out.println(nodoActual.getDato());
            inordenRec(nodoActual.getDerecho());
        }
    }

    @Override
    public void postorden() {
        postordenRec(raiz);
    }

    private void postordenRec(Nodo<T> nodoActual) {
        if (nodoActual != null) {
            postordenRec(nodoActual.getIzquierdo());
            postordenRec(nodoActual.getDerecho());
            System.out.println(nodoActual.getDato());
        }
    }
}