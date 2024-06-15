package cr.ac.ucr.paraiso.ie.algoritmos.tema7;

public class MainMST {
	public static void main(String[] args) {
	       /*[][] grafo = {
	            {0, 5, 1, 0, 0},
	            {5, 0, 3, 6, 0},
	            {1, 3, 0, 5, 4},
	            {0, 6, 5, 0, 2},
	            {0, 0, 4, 2, 0}
	        };
	         String[] nombresNodos = {"A", "B", "C", "D", "E"};*/
	        int[][] grafo = {
	                {0, 4, 3, 0, 0, 0, 0},
	                {4, 0, 0, 5, 1, 0, 0},
	                {3, 0, 0, 8, 0, 10, 0},
	                {0, 5, 8, 0, 2, 0, 6},
	                {0, 1, 0, 2, 0, 7, 0},
	                {0, 0, 10, 0, 7, 0, 3},
	                {0, 0, 0, 9, 0, 3, 0}
	            };       
	        String[] nombresNodos = {"A", "B", "C", "D", "E", "F", "G"};
	        
	        GraphAdyacencyMatrix.mostrarGrafo(grafo, grafo.length,nombresNodos);
	        
	        
	        AlgoritmoPrim.primMST(grafo,nombresNodos);
	        
	        Kruskal kruskal = new Kruskal(grafo);
	        kruskal.kruskalMST(nombresNodos);
	    }
}
