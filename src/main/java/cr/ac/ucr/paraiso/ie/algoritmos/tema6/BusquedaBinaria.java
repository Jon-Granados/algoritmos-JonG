package cr.ac.ucr.paraiso.ie.algoritmos.tema6;

public class BusquedaBinaria {

    /**
     * Realiza la búsqueda binaria de un elemento en una lista ordenada.
     *
     * @param lista La lista ordenada en la que se busca el elemento.
     * @param elementoBuscado El elemento que se busca.
     * @return La posición del elemento buscado en la lista, o -1 si no se encuentra.
     *
     * Complejidad temporal: O(log n), donde n es la longitud de la lista.
     */
    public static int buscarBinario(int[] lista, int elementoBuscado) {
        int izquierda = 0;
        int derecha = lista.length - 1;

        while (izquierda <= derecha) {
            // Calcular el índice del punto medio
            int medio = izquierda + (derecha - izquierda) / 2;

            // Comparar el elemento en el punto medio con el elemento buscado
            if (lista[medio] == elementoBuscado) {
                return medio; // Elemento encontrado
            } else if (lista[medio] < elementoBuscado) {
                izquierda = medio + 1; // Buscar en la sublista superior
            } else {
                derecha = medio - 1; // Buscar en la sublista inferior
            }
        }

        // Elemento no encontrado
        return -1;
    }

    public static void main(String[] args) {
        int[] lista = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int elementoBuscado = 56;

        int posicion = buscarBinario(lista, elementoBuscado);

        if (posicion != -1) {
            System.out.println("Elemento encontrado en la posición: " + posicion);
        } else {
            System.out.println("Elemento no encontrado en la lista.");
        }
    }
}

