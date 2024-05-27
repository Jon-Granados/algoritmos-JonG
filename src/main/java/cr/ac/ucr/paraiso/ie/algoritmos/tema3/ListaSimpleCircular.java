package cr.ac.ucr.paraiso.ie.algoritmos.tema3;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ListaSimpleCircular {
    private NodoInt cabeza;
    private NodoInt cola;
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
    	NodoInt nuevo = new NodoInt(dato);
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
    	NodoInt actual = getCabeza();
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
        NodoInt actual = getCabeza();
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

	public NodoInt getCabeza() {
		return cabeza;
	}

	public void setCabeza(NodoInt nuevo) {
		this.cabeza = nuevo;
	}
	
	 public static void main(String[] args) {
	        ListaSimpleCircular lista = new ListaSimpleCircular();
	        Scanner scanner = new Scanner(System.in);
	        int opcion = 0;

	        do {
	            System.out.println("\n*** Menú de operaciones de lista simple circular ***");
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
	    public static void mostrarLista(ListaSimpleCircular lista) {
	    	NodoInt actual = lista.getCabeza();
	        for (int i = 0; i < lista.elementos(); i++) {
	            System.out.print(actual.dato + " ");
	            actual = actual.siguiente;
	        }
	    }
}