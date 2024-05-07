package cr.ac.ucr.paraiso.ie.algoritmos.semana8;
/**
 * @author Jonthan Granados C
 * Clase que implementa el algoritmo de ordenamiento Seleccion lineal con intercambio,
 * para ordenar un arreglo de elementos genéricos.
 * @param <T> Tipo de elementos a ordenar que deben ser comparables.
 */
public class LinearSelectionWithSwappingSort<T> {
    
    public void linearSelectionWithSwappingSort(T[] array) {
        int n = array.length;
        int minIndex;
        
        for (int i = 0; i < n - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (compare(array[j], array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;

            imprimirIteracion(array,i);
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
        LinearSelectionWithSwappingSort<String> stringSort = new LinearSelectionWithSwappingSort<>();
        String[] stringArray = {"banana", "apple", "orange", "grape", "kiwi"};
        
        System.out.println("Original Array:");
        for (String str : stringArray) {
            System.out.print(str + " ");
        }
        System.out.println();
        stringSort.linearSelectionWithSwappingSort(stringArray);
        
        System.out.println("\nSorted Array:");
        for (String str : stringArray) {
            System.out.print(str + " ");
        }
        
        LinearSelectionWithSwappingSort<Integer> intSort = new LinearSelectionWithSwappingSort<>();
        Integer[] intArray = { 64, 34, 25, 12, 22, 11, 90, 83, 96, 45, 18,1, 10};       
        
        System.out.println("\nOriginal Array:");
        for (Integer num : intArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        intSort.linearSelectionWithSwappingSort(intArray);
        
        System.out.println("\nSorted Array:");
        for (Integer num : intArray) {
            System.out.print(num + " ");
        }
    }
}