package cr.ac.ucr.paraiso.ie.algoritmos.semana7.pilas;


public class Nodo <T>{
	T dato;
    Nodo siguiente;

    Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
