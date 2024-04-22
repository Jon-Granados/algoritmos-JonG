package cr.ac.ucr.paraiso.ie.algoritmos.semana2.exDivideyVenceras;

/**
 * @author Jonathan Granados Cortés
 * IF3000 - Algoritmos y Estructuras de Datos
 * Sede del Atlántico - Recinto Paraíso
 * @version 1.0
 * @category Divide y Venceras
 */
public class BinarySearchAlgorithm {
	
/**
 * Busqueda Binaria
 * @require sorted array
 * @param array
 * @param target
 * @return position of the target within the array
 */
    public static int sortedBinarySearch(int[] array, int target) {//O(log n)
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {//O(n)
            int mid = left + (right - left) / 2;//en cada ejecucion del ciclo el espacio de busqueda se reduce a la mitad por este motivo pasa de una complejidad
            									//O(n) a una complejidad O(log n)

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Elemento no encontrado
    }
    /**
     * Evaluacion si esta ordenado
     * @param array
     * @return {@code boolean} true if Array is currently sorted
     */
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
    /**
     * QuickSort
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int[] sortArray(int[] array, int low, int high) {//complejidad promedio es O(nlogn) -mejor caso- O(n^2)-peor caso-
    																// esto depende de donde se vayan realizando las particiones y que tan balanceadas esten
        if (low < high) {
            int partitionIndex = partition(array, low, high);

            sortArray(array, low, partitionIndex - 1);
            sortArray(array, partitionIndex + 1, high);
        }
        return array;
    }
/**
 * Particion para obtener el indice del quick sort
 * @param array
 * @param low
 * @param high
 * @return
 */
    public static int partition(int[] array, int low, int high) {//O(n)
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

}
