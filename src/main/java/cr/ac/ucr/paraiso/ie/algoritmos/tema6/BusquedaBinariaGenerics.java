package cr.ac.ucr.paraiso.ie.algoritmos.tema6;

public class BusquedaBinariaGenerics<T extends Comparable<T>> {

    /**
     * Realiza la búsqueda binaria de un elemento en una lista ordenada.
     *
     * @param lista La lista ordenada en la que se busca el elemento.
     * @param elementoBuscado El elemento que se busca.
     * @return La posición del elemento buscado en la lista, o -1 si no se encuentra.
     *
     * Complejidad temporal: O(log n), donde n es la longitud de la lista.
     */
    public int buscarBinario(T[] lista, T elementoBuscado) {
        int izquierda = 0;
        int derecha = lista.length - 1;

        while (izquierda <= derecha) {
            // Calcular el índice del punto medio
            int medio = izquierda + (derecha - izquierda) / 2;

            // Comparar el elemento en el punto medio con el elemento buscado
            int comparacion = elementoBuscado.compareTo(lista[medio]);

            if (comparacion == 0) {
                return medio; // Elemento encontrado
            } else if (comparacion < 0) {
                derecha = medio - 1; // Buscar en la sublista inferior
            } else {
                izquierda = medio + 1; // Buscar en la sublista superior
            }
        }

        // Elemento no encontrado
        return -1;
    }

    public static void main(String[] args) {
        String[] lista = {"Juan", "Pedro", "María", "Ana", "Carlos"};
        String elementoBuscado = "María";

        BusquedaBinariaGenerics<String> busquedaBinaria = new BusquedaBinariaGenerics<>();
        int posicion = busquedaBinaria.buscarBinario(lista, elementoBuscado);

        if (posicion != -1) {
            System.out.println("Elemento encontrado en la posición: " + posicion);
        } else {
            System.out.println("Elemento no encontrado en la lista.");
        }
    }
}

