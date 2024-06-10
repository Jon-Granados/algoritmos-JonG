package cr.ac.ucr.paraiso.ie.algoritmos.tema7;

public class MainShortPath {

	public static void main(String[] args) {
		/*int[][] grafo = {
	            {0, 10, 0, 0, 0, 0},
	            {10, 0, 5, 0, 0, 0},
	            {0, 5, 0, 20, 1, 0},
	            {0, 0, 20, 0, 2, 2},
	            {0, 0, 1, 2, 0, 3},
	            {0, 0, 0, 2, 3, 0}
	        };

	        String[] nombresNodos = {"A", "B", "C", "D", "E", "F"};*/
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


	        Dijkstra dijkstra = new Dijkstra();
	        dijkstra.dijkstra(grafo, 0, nombresNodos); // El nodo de origen es 'A' (índice 0)

	}

}
