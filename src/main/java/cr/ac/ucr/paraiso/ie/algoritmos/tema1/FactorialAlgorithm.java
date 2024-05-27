package cr.ac.ucr.paraiso.ie.algoritmos.tema1;
/**
 * @author Jonathan Granados Cortés
 * IF3000 - Algoritmos y Estructuras de Datos
 * Sede del Atlántico - Recinto Paraíso
 * @version 1.0
 */
public class FactorialAlgorithm {
	/**
	 * Algoritmo Recursivo Factorial
	 * @param n {@code int}
	 * @return
	 */
	 public static long calculateFactorialRecursive(int n) {
	        if (n == 0) {
	            return 1;
	        } else {
	            return n * calculateFactorialRecursive(n - 1);//O(n)
	        }
	    }
	 
	 /**
		 * Algoritmo No Recursivo Factorial
		 * @param n {@code int}
		 * @return
		 */
    public static long calculateFactorialNonRecursive(int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {//O(n)
            factorial *= i;
        }
        return factorial;
    }
}
