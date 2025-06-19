package interfaces;

public interface IArbolBinario<T extends IPersona> {
    void insertar(T elemento);
    T buscar(T elementoClave);
    void eliminar(T elementoClave);
    void preorden();
    void inorden();
    void postorden();
}