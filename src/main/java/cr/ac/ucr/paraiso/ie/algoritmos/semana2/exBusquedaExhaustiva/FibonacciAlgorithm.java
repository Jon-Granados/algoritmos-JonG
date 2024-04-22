package cr.ac.ucr.paraiso.ie.algoritmos.semana2.exBusquedaExhaustiva;


/**
 * @author Jonathan Granados Cortés
 * IF3000 - Algoritmos y Estructuras de Datos
 * Sede del Atlántico - Recinto Paraíso
 * @version 1.0
 * @category Programacion Dinamica
 */
public class FibonacciAlgorithm {
	/**
	 * Algoritmo No Recursivo Fibonacci
	 * @param n {@code int}
	 * @return
	 */
	public static void generateFibonacciNonRecursive(int n) {
        int a = 0, b = 1;
      //  System.out.println("Fibonacci Series up to " + n + " terms:");
        for (int i = 0; i < n; i++) {//Complejidad O(n) lo que indica un crecimiento lineal en relación con el tamaño de entrada. 
            System.out.print(a + " ");
            int sum = a + b;
            a = b;
            b = sum;
        }
        System.out.println();
    }
/**
 * Algoritmo Recursivo Fibonacci
 * @param n {@code int}
 * @return
 */
    public static int generateFibonacciRecursive(int n) {
        if (n <= 1) {//Caso Base
            return n;
        }
        return generateFibonacciRecursive(n - 1) + generateFibonacciRecursive(n - 2);//Caso Recurivo - Cada llamada recursiva equivale a O(n), al exxitir 2 llamadas
        																			 //O(2^n), lo que significa que el tiempo de ejecucion aumenta de forma exponencial
        																			//acorde al tamaño de la entrada iniciar
    }
    
    
}
