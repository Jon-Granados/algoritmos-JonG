package cr.ac.ucr.paraiso.ie.algoritmos.tema5;

/**
 * @author Jonthan Granados C
 * Clase que implementa el algoritmo de ordenamiento Burbuja mejorada 
 * para ordenar un arreglo de elementos genéricos.
 * @param <T> Tipo de elementos a ordenar que deben ser comparables.
 */
public class OptimizedBubbleSort<T> {
    
	 /**
     * Método que ordena un arreglo de elementos utilizando el algoritmo de burbuja optimizado.
     * @param array Arreglo de elementos a ordenar.
     */
    public void optimizedBubbleSort(T[] array) {
        int n = array.length;
        boolean swapped;//bandera para conocer si el arreglo esta ordenado
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (compare(array[j], array[j + 1]) > 0) {//llamada al metodo compar
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println(swapped);
            imprimirIteracion(array,i);
            if (!swapped) {
                break;
            }
        }
    }
    private void imprimirIteracion(T[] array, int ite) {
        System.out.println("En la iteracion # " + ite);
        for (T str : array) {
            System.out.print(str + " ");
        }
        System.out.println();
	}
    /**
     * Método privado para comparar dos elementos y determinar su orden.
     * TODO se deben agregar los distintos tipos de instancia segun sea requerido
     * @param a Primer elemento a comparar.
     * @param b Segundo elemento a comparar.
     * @return Valor negativo si a es menor que b, cero si son iguales, valor positivo si a es mayor que b.
     * @throws RuntimeException
     */
    private int compare(T a, T b) {
        if (a instanceof String) {
            return ((String) a).compareTo((String) b);
        } else if (a instanceof Integer) {
            return ((Integer) a).compareTo((Integer) b);
        } else {
            throw new RuntimeException("No se admite este tipo de datos");
        }
    }

    /**
	 * The main method.
	 *
	 * @param args the arguments
	 */
    public static void main(String[] args) {
       /* OptimizedBubbleSort<String> stringSort = new OptimizedBubbleSort<>();
        String[] stringArray = {"banana", "apple", "orange", "grape", "kiwi"};
        
        System.out.println("Original Array:");
        for (String str : stringArray) {
            System.out.print(str + " ");
        }
        
        stringSort.optimizedBubbleSort(stringArray);
        
        System.out.println("\nSorted Array:");
        for (String str : stringArray) {
            System.out.print(str + " ");
        }
     */   
        OptimizedBubbleSort<Integer> intSort = new OptimizedBubbleSort<>();
        Integer[] intArray = {64, 34, 25, 12, 22, 11, 90, 83, 96, 45, 18};
        
        System.out.println("\nOriginal Array:");
        for (Integer num : intArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        intSort.optimizedBubbleSort(intArray);
        
        System.out.println("\nSorted Array:");
        for (Integer num : intArray) {
            System.out.print(num + " ");
        }
    }
}