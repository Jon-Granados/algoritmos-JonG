package cr.ac.ucr.paraiso.ie.algoritmos.tema2;
/**
 * @author Jonathan Granados Cortés
 * IF3000 - Algoritmos y Estructuras de Datos
 * Sede del Atlántico - Recinto Paraíso
 * @version 1.0
 * @category Programacion Dinamica
 */
public class BackPackAlgorithm {

	/**
	 * Problema de la mochila, provee la mejor combinacion  de objetos para llevar segun su limitada capacidad, maximizando el valor total 
	 * @param capacity
	 * @param weights
	 * @param values
	 * @param n
	 * @return
	 */
    public static int knapsack(int capacity, int[] weights, int[] values, int n) {
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }
}