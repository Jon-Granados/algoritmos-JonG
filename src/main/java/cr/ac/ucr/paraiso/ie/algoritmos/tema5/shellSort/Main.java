package cr.ac.ucr.paraiso.ie.algoritmos.tema5.shellSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
// Implementación de Shell Sort para arrays de enteros
    public static void shellSortArray(int[] array) {
        int n = array.length;

        // Comenzamos con un gap grande y lo reducimos
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Realizamos un ordenamiento por inserción con el gap actual
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                
                // dSe desplaza los elementos ordenados en el subarray actual
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

    // Implementación de Shell Sort para listas genéricas con un comparador
    public static <T> void shellSortList(List<T> lista, Comparator<T> comparator) {
        int salto, i; //tamaño de los saltos y las iteraciones
        T aux; // intercambiar elementos
        boolean cambios; // controlar si se realizan cambios en la lista
        int cont = lista.size();

        // reduce el tamaño de los saltos a la mitad en cada iteración
        for (salto = cont / 2; salto != 0; salto /= 2) {
            cambios = true; 
            while (cambios) {
                cambios = false; // Inicializar cambios como falso al inicio de cada iteración
                // Bucle que recorre la lista y realiza comparaciones entre elementos
                for (i = salto; i < cont; i++) {
                    // Si el elemento en la posición actual es mayor que el elemento en la posición actual = salto,
                    // se intercambian los elementos y se marca cambios como verdadero
                    if (comparator.compare(lista.get(i - salto), lista.get(i)) > 0) {
                        aux = lista.get(i); // Almacenar el elemento en la posición actual en la variable auxiliar
                        lista.set(i, lista.get(i - salto)); // Establecer el elemento en la posición actual - salto en la posición actual
                        lista.set(i - salto, aux); // Establecer el elemento almacenado en la variable auxiliar en la posición actual - salto
                        cambios = true; // Marcar cambios como verdadero
                    }
                }
            }
        }
    }

    
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    
    public static <T> void printList(List<T> lista) {
        for (T element : lista) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

 public static void main(String[] args) {
        // Ejemplo con array de enteros
        int[] array = {12, 34, 54, 2, 3};
        System.out.println("Array original:");
        printArray(array);

        shellSortArray(array);
        
        System.out.println("Array ordenado:");
        printArray(array);

        // Ejemplo con lista genérica
        List<Integer> lista = new ArrayList<>(List.of(12, 34, 54, 2, 3));
        System.out.println("Lista original:");
        printList(lista);

        shellSortList(lista, Comparator.naturalOrder());
        
        System.out.println("Lista ordenada:");
        printList(lista);
    }
}
