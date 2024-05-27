package cr.ac.ucr.paraiso.ie.algoritmos.tema5;
/**
 * @author Jonathan Granados C
 * Clase que implementa el algoritmo de ordenamiento por hundimiento,
 * para ordenar un arreglo de elementos genéricos.
 * @param <T> Tipo de elementos a ordenar que deben ser comparables.
 */
public class SinkingSort<T> {
    
    public void sinkingSort(T[] array) {
        int n = array.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (compare(array[i], array[j]) > 0) {
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
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
        SinkingSort<String> stringSort = new SinkingSort<>();
        String[] stringArray = {"banana", "apple", "orange", "grape", "kiwi"};
        
        System.out.println("Original Array:");
        for (String str : stringArray) {
            System.out.print(str + " ");
        }
        
        stringSort.sinkingSort(stringArray);
        
        System.out.println("\nSorted Array:");
        for (String str : stringArray) {
            System.out.print(str + " ");
        }
        
        SinkingSort<Integer> intSort = new SinkingSort<>();
        Integer[] intArray = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("\nOriginal Array:");
        for (Integer num : intArray) {
            System.out.print(num + " ");
        }
        
        intSort.sinkingSort(intArray);
        
        System.out.println("\nSorted Array:");
        for (Integer num : intArray) {
            System.out.print(num + " ");
        }
    }
}