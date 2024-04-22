package cr.ac.ucr.paraiso.ie.algoritmos.semana6.dobleCircular;

public class NodoDobleCircular {
    int dato;
    NodoDobleCircular anterior;
    NodoDobleCircular siguiente;

    public NodoDobleCircular(int dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }
}