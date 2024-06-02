package cr.ac.ucr.paraiso.ie.algoritmos.tema5.radixSort;
//Este código implementa una función de ordenación de conteo (countingSort) 
//para un dígito específico de un número, que se utiliza comúnmente como parte 
//del algoritmo de ordenación radix (radix sort)
public class RadixSort {

    // Método para hacer el Counting Sort según el dígito exp1
    public static void countingSort(int[] array, int exp1) { 
    //exp1 representa la posición del dígito a ordenar (por ejemplo, unidades, decenas, centenas)
    
        // Array de salida que almacenará los números ordenados según el dígito actual
        int[] output = new int[array.length];

        // Array de tamaño 10 (para los dígitos 0 a 9) que se usará para contar las ocurrencias de cada dígito en array
        int[] count = new int[10];

        //Mensaje indicando el valor del exponente exp1 que se está utilizando en esta iteración de la ordenación
        System.out.println("\nCambio con exponente: " + exp1);

        // Almacenar el conteo de ocurrencias en el array count
        for (int i = 0; i < array.length; i++) { //Itera sobre cada elemento en array
            // Obtener el dígito correspondiente según exp1
            int index = (array[i] / exp1) % 10; //Calcula el dígito actual 
            count[index]++; // Incrementa el conteo de ese dígito en el array count
        }

        //Imprime cuántas veces aparece cada dígito en array
        System.out.println("Conteo de ocurrencias: " + java.util.Arrays.toString(count));

        //Modifica count para que cada elemento en count[i] contenga la posición real de
        //este dígito en output. Esto se logra sumando el conteo actual con el 
        //conteo del elemento anterior, acumulando así las posiciones.
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construir el array de salida
        for (int i = array.length - 1; i >= 0; i--) {//Itera sobre arr de derecha a izquierda para mantener la estabilidad del orden
            int index = (array[i] / exp1) % 10; // Obtiene el dígito relevante del número arr[i].
            output[count[index] - 1] = array[i]; // Coloca arr[i] en su posición correcta en el array output.
            count[index]--; // Decrementa el contador para el dígito procesado.
        }

        // Copiar el array de salida a arr[], para que arr[] contenga los números ordenados según el dígito actual
        System.arraycopy(output, 0, array, 0, array.length);

        // Imprimir estado del arreglo después del paso actual
        System.out.println("Nuevo arreglo: " + java.util.Arrays.toString(array));
    }

    // Método principal para el Radix Sort
    public static void radixSort(int[] arr) {
        // Encontrar el número máximo para saber el número de dígitos del numero más grande
        int max = findMax(arr);
        //Esto es necesario para determinar el número de dígitos del número más grande, lo cual 
        //determinará el número de iteraciones que se necesitan realizar en el Radix Sort

        // Hacer counting sort para cada dígito
        //itera a través de cada posición de dígito (unidades, decenas, centenas
        //exp1 empieza en 1, lo que significa que comenzará con el dígito de las unidades
        //max / exp1 > 0 asegura que se continúe procesando hasta que se hayan ordenado todos los dígitos del número más grande
        for (int exp1 = 1; max / exp1 > 0; exp1 *= 10) {
            countingSort(arr, exp1); //ordena el arreglo
        }
    }

    // Método para encontrar el número máximo en el array
    public static int findMax(int[] arr) {
        int max = arr[0]; //// Asume que el primer elemento es el máximo
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i]; // Actualiza el máximo si se encuentra un elemento mayor
            }
        }
        return max;// Retorna el número máximo encontrado
    }
}
