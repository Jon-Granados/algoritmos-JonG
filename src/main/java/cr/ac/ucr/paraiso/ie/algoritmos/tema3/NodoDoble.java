package cr.ac.ucr.paraiso.ie.algoritmos.tema3;

public class NodoDoble {
    int dato;
    NodoDoble anterior;
    NodoDoble siguiente;

    public NodoDoble(int dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }
}