package cr.ac.ucr.paraiso.ie.algoritmos.tema5.quickSort;



// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int[] arreglo = {};
        //int[] arreglo = {1};
        //int[] arreglo = {1, 2, 3, 4, 5};
        //int[] arreglo = {5, 4, 3, 2, 1};
        //int[] arreglo = {1, 1, 1, 1, 1};
        //int[] arreglo = {-3, -1, -4, -1, -5, -9, -2, -6, -5, -3};
        //int[] arreglo = {3, -1, 4, -1, 5, -9, 2, -6, 5, -3};
        //int [] arreglo = {3,1,4,1,5,9,2,6,5,3};
        //int[] arreglo = {100, 1, 1, 1, 1};


       //int[] arreglo = new int[1000];
       //for (int i = 0; i < 1000; i++) {
      //     arreglo[i] = (int) (Math.random() * 1000);
      //   }



       //int[] arreglo = new int[10000000];
       //for (int i = 0; i < 10000000; i++) {
        //arreglo[i] = (int) (Math.random() * 10000);
        //}




        int tamaño = arreglo.length;

        QuickSort quickSort = new QuickSort(arreglo);

        long startTime = System.nanoTime();

        quickSort.quickSort(0,tamaño-1);

        long endTime = System.nanoTime();

        long duration = endTime - startTime;

        System.out.println("Tiempo de ejecución en nanosegundos: " + duration);


        }
    }
