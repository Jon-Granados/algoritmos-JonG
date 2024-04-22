package cr.ac.ucr.paraiso.ie.algoritmos.semana6.dobleCircular;

import java.util.NoSuchElementException;

public class ListaDobleCircular {
    private NodoDobleCircular cabeza;
    private int tamanio;

    public ListaDobleCircular() {
        setCabeza(null);
        tamanio = 0;
    }

    // Crear
    public void crear() {
        setCabeza(null);
        tamanio = 0;
    }

    // Insertar
    public void insertar(int dato) {
        NodoDobleCircular nuevo = new NodoDobleCircular(dato);
        if (getCabeza() == null) {
            setCabeza(nuevo);
            getCabeza().anterior = getCabeza();
            getCabeza().siguiente = getCabeza();
        } else {
            NodoDobleCircular ultimo = getCabeza().anterior;
            nuevo.siguiente = getCabeza();
            nuevo.anterior = ultimo;
            getCabeza().anterior = nuevo;
            ultimo.siguiente = nuevo;
        }
        tamanio++;
    }

    // Borrar
    public void borrar() {
        if (getCabeza() == null) {
            throw new NoSuchElementException("Lista vacía");
        }
        if (getCabeza().siguiente == getCabeza()) {
            setCabeza(null);
        } else {
            NodoDobleCircular ultimo = getCabeza().anterior;
            setCabeza(getCabeza().siguiente);
            getCabeza().anterior = ultimo;
            ultimo.siguiente = getCabeza();
        }
        tamanio--;
    }

    // Buscar
    public boolean buscar(int dato) {
        if (getCabeza() == null) {
            return false;
        }
        NodoDobleCircular actual = getCabeza();
        do {
            if (actual.dato == dato) {
                return true;
            }
            actual = actual.siguiente;
        } while (actual != getCabeza());
        return false;
    }

    // Ultimo
    public int ultimo() {
        if (getCabeza() == null) {
            throw new NoSuchElementException("Lista vacía");
        }
        return getCabeza().anterior.dato;
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
        NodoDobleCircular actual = getCabeza();
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

	public NodoDobleCircular getCabeza() {
		return cabeza;
	}

	public void setCabeza(NodoDobleCircular cabeza) {
		this.cabeza = cabeza;
	}
}