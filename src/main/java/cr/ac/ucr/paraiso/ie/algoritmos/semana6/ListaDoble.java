package cr.ac.ucr.paraiso.ie.algoritmos.semana6;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ListaDoble {
    private NodoDoble cabeza;
    private NodoDoble cola;
    private int tamanio;

    public ListaDoble() {
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
        NodoDoble nuevo = new NodoDoble(dato);
        if (getCabeza() == null) {
            setCabeza(nuevo);
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
        tamanio++;
    }

    // Insertar en Posición
    public void insertarEnPosicion(int dato, int posicion) {
        if (posicion < 0 || posicion > tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        if (posicion == 0) {
            NodoDoble nuevo = new NodoDoble(dato);
            nuevo.siguiente = getCabeza();
            getCabeza().anterior = nuevo;
            setCabeza(nuevo);
        } else if (posicion == tamanio) {
            insertar(dato);
        } else {
            NodoDoble nuevo = new NodoDoble(dato);
            NodoDoble actual = getCabeza();
            for (int i = 1; i < posicion; i++) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            nuevo.anterior = actual;
            actual.siguiente.anterior = nuevo;
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
        if (getCabeza() != null) {
            getCabeza().anterior = null;
        } else {
            cola = null;
        }
        tamanio--;
    }

    // Borrar en Posición
    public void borrarEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        if (posicion == 0) {
            setCabeza(getCabeza().siguiente);
            if (getCabeza() != null) {
                getCabeza().anterior = null;
            } else {
                cola = null;
            }
        } else if (posicion == tamanio - 1) {
            cola = cola.anterior;
            cola.siguiente = null;
        } else {
            NodoDoble actual = getCabeza();
            for (int i = 1; i < posicion; i++) {
                actual = actual.siguiente;
            }
            actual.siguiente = actual.siguiente.siguiente;
            actual.siguiente.anterior = actual;
        }
        tamanio--;
    }

    // Último
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
	// Invertir la lista
	public void invertir() {
		if (cabeza != null && cabeza.siguiente != null) {
	        NodoDoble actual = cabeza;
	        NodoDoble temp = null;

	        while (actual != null) {
	            temp = actual.anterior;
	            actual.anterior = actual.siguiente;
	            actual.siguiente = temp;
	            actual = actual.anterior;
	        }

	        if (temp != null) {
	            cabeza = temp.anterior;
	        }
	    }	
	}


	  // Método para mostrar los elementos de la lista
	@Override
  public String toString() {
	NodoDoble actual = this.getCabeza();
      StringBuilder listToString = new StringBuilder("Los datos de la lista son: \n");
      
      while (actual != null) {
          listToString.append(actual.dato + (actual.siguiente == null? ".":" , "));
          actual = actual.siguiente;
      }
		return listToString.toString();
  } 
	 public static void main(String[] args) {
	        ListaDoble lista = new ListaDoble();
	        Scanner scanner = new Scanner(System.in);
	        int opcion = 0;

	        do {
	            System.out.println("\n*** Menú de operaciones de lista doble ***");
	            System.out.println("1. Insertar elemento");
	            System.out.println("2. Borrar elemento");
	            System.out.println("3. Mostrar lista");
	            System.out.println("4. Insertar en posición");
	            System.out.println("5. Borrar en posición");
	            System.out.println("6. Invertir Lista");
	            System.out.println("7. Salir");
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
	                	lista.invertir();
	                    System.out.println("La lista se invirtio.");
	                	break;
	                case 7:
	                    System.out.println("¡Hasta luego!");
	                    break;
	                default:
	                    System.out.println("Opción inválida.");
	            }
	        } while (opcion != 7);

	        scanner.close();
	    }
}