package cr.ac.ucr.paraiso.ie.algoritmos.semana6;

import java.util.NoSuchElementException;

public class ListaSimple {
    private Nodo cabeza;
    private int tamanio;

    public ListaSimple() {
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
        Nodo nuevo = new Nodo(dato);
        if (getCabeza() == null) {
            setCabeza(nuevo);
        } else {
            Nodo actual = getCabeza();
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamanio++;
    }

    // Insertar en Posición
    public void insertarEnPosicion(int dato, int posicion) {
        if (posicion < 0 || posicion > tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        if (posicion == 0) {
            Nodo nuevo = new Nodo(dato);
            nuevo.siguiente = getCabeza();
            setCabeza(nuevo);
        } else {
            Nodo nuevo = new Nodo(dato);
            Nodo actual = getCabeza();
            for (int i = 1; i < posicion; i++) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
        }
        tamanio++;
    }

    // Borrar
    public void borrar() {
        if (getCabeza() == null) {
            throw new NoSuchElementException("Lista vacía");
        }
        setCabeza(getCabeza().siguiente);
        tamanio--;
    }

    // Borrar en Posición
    public void borrarEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        if (posicion == 0) {
            setCabeza(getCabeza().siguiente);
        } else {
            Nodo actual = getCabeza();
            for (int i = 1; i < posicion; i++) {
                actual = actual.siguiente;
            }
            actual.siguiente = actual.siguiente.siguiente;
        }
        tamanio--;
    }

    // Último
    public int ultimo() {
        if (getCabeza() == null) {
            throw new NoSuchElementException("Lista vacía");
        }
        Nodo actual = getCabeza();
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        return actual.dato;
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
        Nodo actual = getCabeza();
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

	public Nodo getCabeza() {
		return cabeza;
	}

	public void setCabeza(Nodo cabeza) {
		this.cabeza = cabeza;
	}
}
