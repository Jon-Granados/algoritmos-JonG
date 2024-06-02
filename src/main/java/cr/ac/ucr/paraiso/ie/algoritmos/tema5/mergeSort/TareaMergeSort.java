package cr.ac.ucr.paraiso.ie.algoritmos.tema5.mergeSort;

/**
 * Verónica Araya
 * Justin Corrales
 * Jesús Blanco
 * Jeison Calderón
 */
public class TareaMergeSort {

    public static void main(String[] args) {
        
        int[] array = {8, 2, 5, 3, 4, 7, 6, 1};
        
        System.out.print("Arreglo sin ordenar:\n");
        printArray(array);
        
        mergeSort(array);
        
        System.out.print("\n\n");
        System.out.print("Arreglo ordenado:\n");
        
        printArray(array);
    }
    
    public static void printArray(int array[]){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+ " ");
        }
    }

    private static void mergeSort(int[] array) {
        
        int length = array.length;
        if (length <= 1) {
            return; //caso base, cuando length es 1 ya el array no se puede dividar más
        }
        int middle = length / 2;
        
        //se crean las dos branches del array
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0; //left array
        int j = 0; //right array

        //Se llenan las branches del array con los datos del array original
        for (; i < length; i++) {
            if (i < middle) {
                leftArray[i] = array[i];
            } else {
                rightArray[j] = array[i];
                j++;
            }
        }
        
        //se sortean las branches
        mergeSort(leftArray);
        mergeSort(rightArray);
        
        //se fusinan (merge) las branches ordenadas al array original, subiendo hasta el array original
        merge(leftArray, rightArray, array);

    }

    public static void merge(int[] leftArray, int[] rightArray, int[] array) {

        //variables de control para moverse por los arrays
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0; //indices

        //estas son las condiciones para hacer merge
        
        while (l < leftSize && r < rightSize) { //hay datos en ambas branches que aún no han sido comparados
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while (l < leftSize) {  //hay datos solo en la branch izquierda que aún no han sido comparados 
                                // pero ya no hay datos en la branch derecha para comparar, por lo que se baja el dato de una vez a al array que retorna
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize) { //hay datos solo en la branch derecha que aún no han sido comparados 
                                // pero ya no hay datos en la branch izquierda para comparar, por lo que se baja el dato de una vez a al array que retorna
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
}
