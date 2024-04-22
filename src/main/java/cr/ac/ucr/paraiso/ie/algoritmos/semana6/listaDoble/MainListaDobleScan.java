package cr.ac.ucr.paraiso.ie.algoritmos.semana6.listaDoble;

import java.util.Scanner;

import java.util.Scanner;

public class MainListaDobleScan{
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