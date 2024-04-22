/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.paraiso.ie.algoritmos.semana4;

/**
 *
 * @author jonat
 */
public class BinarySearch {


    /**
     * Búsqueda binaria recursiva para encontrar un elemento en una lista ordenada.
     *
     * @param lista Lista ordenada de elementos.
     * @param inicio Índice de inicio de la búsqueda.
     * @param fin Índice de fin de la búsqueda.
     * @param elementoObjetivo Elemento que se busca.
     * @return Índice del elemento objetivo en la lista (o -1 si no se encuentra).
     */
    public static int busquedaBinariaRecursiva(int[] lista, int inicio, int fin, int elementoObjetivo) {
        if (inicio > fin) {
            return -1; // Elemento no encontrado
        }

        int medio = inicio + (fin - inicio) / 2;

        if (lista[medio] == elementoObjetivo) {
            return medio;
        } else if (lista[medio] < elementoObjetivo) {
            return busquedaBinariaRecursiva(lista, medio + 1, fin, elementoObjetivo);
        } else {
            return busquedaBinariaRecursiva(lista, inicio, medio - 1, elementoObjetivo);
        }
    }

    /**
     * Búsqueda binaria iterativa para encontrar un elemento en una lista ordenada.
     *
     * @param lista Lista ordenada de elementos.
     * @param elementoObjetivo Elemento que se busca.
     * @return Índice del elemento objetivo en la lista (o -1 si no se encuentra).
     */
    public static int busquedaBinariaIterativa(int[] lista, int elementoObjetivo) {
        int inicio = 0;
        int fin = lista.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (lista[medio] == elementoObjetivo) {
                return medio;
            } else if (lista[medio] < elementoObjetivo) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1; // Elemento no encontrado
    }




    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7;

        int indiceRecursivo = busquedaBinariaRecursiva(arr, 0, arr.length - 1, target);
        int indiceIterativo = busquedaBinariaIterativa(arr, target);

        System.out.println("Búsqueda binaria recursiva: índice = " + indiceRecursivo);
        System.out.println("Búsqueda binaria iterativa: índice = " + indiceIterativo);
   
    }
}