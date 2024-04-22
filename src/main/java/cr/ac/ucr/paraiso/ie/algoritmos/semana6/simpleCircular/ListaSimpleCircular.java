package cr.ac.ucr.paraiso.ie.algoritmos.semana6.simpleCircular;

import java.util.NoSuchElementException;

public class ListaSimpleCircular {
    private NodoCircular cabeza;
    private NodoCircular cola;
    private int tamanio;

    public ListaSimpleCircular() {
        setCabeza(null);
        cola = null;
        tamanio = 0;
    }

    // Crear
    public void crear() {
        setCabeza(null);
        cola = null;
        tamanio = 0;
    }

    // Insertar
    public void insertar(int dato) {
        NodoCircular nuevo = new NodoCircular(dato);
        if (getCabeza() == null) {
            setCabeza(nuevo);
            cola = nuevo;
            getCabeza().siguiente = cola;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
            cola.siguiente = getCabeza();
        }
        tamanio++;
    }

    // Borrar
    public void borrar() {
        if (getCabeza() == null) {
            throw new NoSuchElementException("Lista vacía");
        }
        if (getCabeza() == cola) {
            setCabeza(null);
            cola = null;
        } else {
            setCabeza(getCabeza().siguiente);
            cola.siguiente = getCabeza();
        }
        tamanio--;
    }

    // Buscar
    public boolean buscar(int dato) {
        NodoCircular actual = getCabeza();
        for (int i = 0; i < tamanio; i++) {
            if (actual.dato == dato) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Ultimo
    public int ultimo() {
        if (cola == null) {
            throw new NoSuchElementException("Lista vacía");
        }
        return cola.dato;
    }

    // EstaVacia
    public boolean estaVacia() {
        return getCabeza() == null;
    }

    // Elementos
    public int elementos() {
        return tamanio;
    }

    // Destruir
    public void destruir() {
        crear();
    }

    // Elemento en Posición
    public int elementoEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        NodoCircular actual = getCabeza();
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

	public NodoCircular getCabeza() {
		return cabeza;
	}

	public void setCabeza(NodoCircular cabeza) {
		this.cabeza = cabeza;
	}
}