package cr.ac.ucr.paraiso.ie.algoritmos.tema3;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ListaSimple {
    private NodoInt cabeza;
    private int tamanio;

    //Instancia una lista vacia
    public ListaSimple() {
        setCabeza(null);
        tamanio = 0;
    }

    // Crear identico al contructor
    public void crear() {
        setCabeza(null);
        tamanio = 0;
    }

    // Insertar
    public void insertar(int dato) {
        NodoInt nuevo = new NodoInt(dato);
        if (getCabeza() == null) {
            setCabeza(nuevo);
        } else {
            NodoInt actual = getCabeza();
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
            NodoInt nuevo = new NodoInt(dato);
            nuevo.siguiente = getCabeza();
            setCabeza(nuevo);
        } else {
            NodoInt nuevo = new NodoInt(dato);
            NodoInt actual = getCabeza();
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
            NodoInt actual = getCabeza();
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
        NodoInt actual = getCabeza();
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
        NodoInt actual = getCabeza();
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

	public NodoInt getCabeza() {
		return cabeza;
	}

	public void setCabeza(NodoInt cabeza) {
		this.cabeza = cabeza;
	}
	
	  // Método para mostrar los elementos de la lista
	@Override
    public String toString() {
        NodoInt actual = this.getCabeza();
        StringBuilder listToString = new StringBuilder("Los datos de la lista son: \n");
        
        while (actual != null) {
            listToString.append(actual.dato + (actual.siguiente == null? ".":" , "));
            actual = actual.siguiente;
        }
		return listToString.toString();
    } 
	public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n*** Menú de operaciones de lista simple ***");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Borrar elemento");
            System.out.println("3. Mostrar lista");
            System.out.println("4. Insertar en posición");
            System.out.println("5. Borrar en posición");
            System.out.println("6. Salir");
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
                    System.out.print(lista.toString());
                    
                    break;
                case 4:
                    System.out.print("Ingrese el valor a insertar: ");
                    int valorInsertar = scanner.nextInt();
                    System.out.print("Ingrese la posición: ");
                    int posicion = scanner.nextInt();
                    lista.insertarEnPosicion(valorInsertar, posicion);
                    break;
                case 5:
                    if (!lista.estaVacia()) {
                        System.out.print("Ingrese la posición: ");
                        int posicionBorrar = scanner.nextInt();
                        lista.borrarEnPosicion(posicionBorrar);
                    } else {
                        System.out.println("La lista está vacía.");
                    }
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);

        scanner.close();
    }

}
