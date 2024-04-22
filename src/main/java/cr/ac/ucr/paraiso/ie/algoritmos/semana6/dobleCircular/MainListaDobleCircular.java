package cr.ac.ucr.paraiso.ie.algoritmos.semana6.dobleCircular;

import java.util.Scanner;

public class MainListaDobleCircular {
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
	        NodoDobleCircular actual = lista.getCabeza();
	        do {
	            System.out.print(actual.dato + " ");
	            actual = actual.siguiente;
	        } while (actual != lista.getCabeza());
	    }
}
