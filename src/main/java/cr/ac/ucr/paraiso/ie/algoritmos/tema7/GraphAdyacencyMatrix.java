package cr.ac.ucr.paraiso.ie.algoritmos.tema7;

import java.util.Scanner;

public class GraphAdyacencyMatrix {
	 private int numVertices;
	    private int[][] matrizAdyacencia;

	    public GraphAdyacencyMatrix(int numVertices) {
	        this.numVertices = numVertices;
	        this.matrizAdyacencia = new int[numVertices][numVertices];
	    }

	    public void agregarArista(int origen, int destino, int peso) {
	        matrizAdyacencia[origen][destino] = peso;
	        matrizAdyacencia[destino][origen] = peso; // Grafo no dirigido
	    }

	    private void mostrarGrafo() {
	        System.out.println("Matriz de adyacencia:");
	        for (int i = 0; i < numVertices; i++) {
	            for (int j = 0; j < numVertices; j++) {
	                if (matrizAdyacencia[i][j] == 0) {
	                    System.out.print("0 ");
	                } else {
	                    System.out.print(matrizAdyacencia[i][j] + " ");
	                }
	            }
	            System.out.println();
	        }
	    }
	    public static void mostrarGrafo(int[][] grafo, int numVertices, String[] nombresNodos) {
	        System.out.println("Matriz de adyacencia:");
	        System.out.print("  ");
	        for (String nombre : nombresNodos) {
	            System.out.print(nombre + " ");
	        }
	        System.out.println();

	        for (int i = 0; i < numVertices; i++) {
	            System.out.print(nombresNodos[i] + " ");
	            for (int j = 0; j < numVertices; j++) {
	                if (grafo[i][j] == 0) {
	                    System.out.print("0 ");
	                } else {
	                    System.out.print(grafo[i][j] + " ");
	                }
	            }
	            System.out.println();
	        }
	    }

	    public static void main(String[] args) {
	    	GraphAdyacencyMatrix grafo = new GraphAdyacencyMatrix(5);
	        grafo.agregarArista(0, 1, 5);
	        grafo.agregarArista(0, 2, 1);
	        grafo.agregarArista(1, 3, 6);
	        grafo.agregarArista(2, 3, 5);
	        grafo.agregarArista(2, 4, 4);
	        grafo.agregarArista(3, 4, 2);

	        grafo.mostrarGrafo();
	    }
	
}
