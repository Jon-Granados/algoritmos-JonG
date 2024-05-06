package cr.ac.ucr.paraiso.ie.algoritmos.semana6;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ListaDobleCircular {
    private NodoDoble cabeza;
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
    	NodoDoble nuevo = new NodoDoble(dato);
        if (getCabeza() == null) {
            setCabeza(nuevo);
            getCabeza().anterior = getCabeza();
            getCabeza().siguiente = getCabeza();
        } else {
        	NodoDoble ultimo = getCabeza().anterior;
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
        	NodoDoble ultimo = getCabeza().anterior;
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
        NodoDoble actual = getCabeza();
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
        NodoDoble actual = getCabeza();
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

	public NodoDoble getCabeza() {
		return cabeza;
	}

	public void setCabeza(NodoDoble cabeza) {
		this.cabeza = cabeza;
	}
	public static void main(String[] args) {
        ListaDobleCircular lista = new ListaDobleCircular();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n*** Menú de operaciones de lista doble circular ***");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Borrar elemento");
            System.out.println("3. Buscar elemento");
            System.out.println("4. Mostrar lista");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor a insertar: ");
                    int valor = scanner.nextInt();
                    lista.insertar(valor);
                    break;
                case 2:
                    if (!lista.estaVacia()) {
                        lista.borrar();
                    } else {
                        System.out.println("La lista está vacía.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el valor a buscar: ");
                    int valorBuscar = scanner.nextInt();
                    if (lista.buscar(valorBuscar)) {
                        System.out.println("El valor se encuentra en la lista.");
                    } else {
                        System.out.println("El valor no se encuentra en la lista.");
                    }
                    break;
                case 4:
                    System.out.print("Lista: ");
                    mostrarLista(lista);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    // Método para mostrar los elementos de la lista
    public static void mostrarLista(ListaDobleCircular lista) {
        if (lista.estaVacia()) {
            System.out.println("Lista vacía.");
            return;
        }
        NodoDoble actual = lista.getCabeza();
        do {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        } while (actual != lista.getCabeza());
    }
}