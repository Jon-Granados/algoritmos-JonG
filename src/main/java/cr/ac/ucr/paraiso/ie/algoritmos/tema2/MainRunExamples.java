package cr.ac.ucr.paraiso.ie.algoritmos.tema2;


import java.util.Arrays;

import cr.ac.ucr.paraiso.ie.algoritmos.tema1.FactorialAlgorithm;

/**
 * @author Jonathan Granados Cortés
 * IF3000 - Algoritmos y Estructuras de Datos
 * Sede del Atlántico - Recinto Paraíso
 * @version 1.0
 */
public class MainRunExamples 
{
    public static void main( String[] args )
    {
    	//runFactorial();//clase 1
    	runKruskal(); 
        //runExhaustiveSearch();
        //runKnapsack();
    	//runFibonacci();<<<<<<<<<<<<<<
    	//runBinarySearch();
        //runMontecarloPi();
        
    }
    
	/**
     * Ejercicio clase 1
     */
    protected static void runFactorial(int number) {
		
		
		System.out.println("Factorial  Recursivo: ");
		long startTimeRecursive = System.nanoTime();
		long factorialRecursive = FactorialAlgorithm.calculateFactorialRecursive(number);
		long endTimeRecursive = System.nanoTime();
		long durationRecursive = (endTimeRecursive - startTimeRecursive);
		System.out.println("Factorial de " + number + " (recursivo): " + factorialRecursive);
		System.out.println("Tiempo de ejecución del método recursivo: " + durationRecursive + " nanosegundos");
					
		System.out.println("Factorial No Recursivo: ");
		long startTimeNonRecursive  = System.nanoTime();
		long factorialNonRecursive = FactorialAlgorithm.calculateFactorialNonRecursive(number);
		long endTimeNonRecursive = System.nanoTime();
		long durationNonRecursive = (endTimeNonRecursive - startTimeNonRecursive);		
		System.out.println("Factorial de " + number + " (no recursivo): " + factorialNonRecursive);
		System.out.println("Tiempo de ejecución del método no recursivo: " + durationNonRecursive + " nanosegundos");
	}
    /**
     * Ejemplos clase 2
     */
    protected static void runKruskal() {
		 	int V = 4;
	        int E = 5;
	        KruskalAlgorithm graph = new KruskalAlgorithm(V, E);

	        graph.edges[0] = new KruskalEdge(0, 1, 10);
	        graph.edges[1] = new KruskalEdge(0, 2, 6);
	        graph.edges[2] = new KruskalEdge(0, 3, 5);
	        graph.edges[3] = new KruskalEdge(1, 3, 15);
	        graph.edges[4] = new KruskalEdge(2, 3, 4);

	        graph.kruskalMST();
		
	}
    
    protected static void runExhaustiveSearch() {
        int number = 100; // Número para encontrar la raíz cuadrada
        int result = ExhaustiveSearch.findSquareRoot(number);

        if (result != -1) {
            System.out.println("La raíz cuadrada entera de " + number + " es: " + result);
        } else {
            System.out.println("No se encontró la raíz cuadrada entera de " + number);
        }
		
	}
    protected static void runKnapsack() {
        int[] values = {60, 100, 120, 30};
        int[] weights = {10, 20, 30, 50};
        int capacity = 50;
        int n = values.length;
 
        int maxValue = BackPackAlgorithm.knapsack(capacity, weights, values, n);
        System.out.println("Maximum value that can be obtained: " + maxValue);		
	}
	
    protected static void runFibonacci() {
		int number = 10;
		
		
		System.out.println("Serie Fibonacci hasta " + number + " terminos");
		System.out.println("Fibonacci No Recursivo: ");
		
		long startTimeNonRecursive  = System.nanoTime();
		FibonacciAlgorithm.generateFibonacciNonRecursive(number);
		long endTimeNonRecursive = System.nanoTime();
		long durationNonRecursive = (endTimeNonRecursive - startTimeNonRecursive);

		System.out.println("Tiempo de ejecución del método no recursivo: " + durationNonRecursive + " nanosegundos");		
		
		System.out.println("Fibonacci Recursivo: ");
		long startTimeRecursive = System.nanoTime();
		for (int i = 0; i < number; i++) {
			System.out.print(FibonacciAlgorithm.generateFibonacciRecursive(i) + " ");
		}
		long endTimeRecursive = System.nanoTime();
		long durationRecursive = (endTimeRecursive - startTimeRecursive);
		System.out.println("Tiempo de ejecución del método recursivo: " + durationRecursive + " nanosegundos");	
		
	}
	
    protected static void runBinarySearch() {
		int[] array = {5, 8, 12, 16, 38, 56, 72, 91,23,2};
        int target = 23;
        int[] sortedArray = new int[array.length];
        int index = -1;
        
        if(!BinarySearchAlgorithm.isSorted(array)) {
        	System.out.println("Arreglo antes de ordenar: " + Arrays.toString(array));
        	sortedArray = BinarySearchAlgorithm.sortArray(array, 0, array.length - 1);   
        	System.out.println("Arreglo después de ordenar: " + Arrays.toString(sortedArray));
        	index = BinarySearchAlgorithm.sortedBinarySearch(sortedArray, target);        	
        }else
        	index = BinarySearchAlgorithm.sortedBinarySearch(array, target);
        
        if (index != -1) {
            System.out.println("El elemento " + target + " se encuentra en la posición " + index);
        } else {
            System.out.println("El elemento " + target + " no se encuentra en el arreglo.");
        }
		
	}
    protected static void runMontecarloPi() {
    	int numPoints = 1000000000; // Número de puntos a generar
        double estimatedPi = MonteCarloPi.estimatePi(numPoints);

        System.out.println("Valor estimado de Pi: " + estimatedPi);
	}
}
