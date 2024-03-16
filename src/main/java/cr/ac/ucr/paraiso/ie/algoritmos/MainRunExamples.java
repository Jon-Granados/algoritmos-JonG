package cr.ac.ucr.paraiso.ie.algoritmos;


/**
 * Hello world!
 *
 */
public class MainRunExamples 
{
    public static void main( String[] args )
    {
    	runKruskal();
        //runExhaustiveSearch();
        
    }

	private static void runKruskal() {
		 int V = 4;
	        int E = 5;
	        KruskalAlgorithm graph = new KruskalAlgorithm(V, E);

	        graph.edges[0] = new Edge(0, 1, 10);
	        graph.edges[1] = new Edge(0, 2, 6);
	        graph.edges[2] = new Edge(0, 3, 5);
	        graph.edges[3] = new Edge(1, 3, 15);
	        graph.edges[4] = new Edge(2, 3, 4);

	        graph.kruskalMST();
		
	}

	private static void runExhaustiveSearch() {
		int[] values = {10, 5, 15, 7, 6};
        int[] weights = {2, 3, 5, 7, 1};
        int capacity = 10;
        ExhaustiveSearchAlgorithm ejemploProblemaMochila = new ExhaustiveSearchAlgorithm();
        
        double maxValue = ejemploProblemaMochila.knapsack(values, weights, capacity);
        System.out.println("Maximum value that can be obtained: " + maxValue);  		
		
	}
}
