package cr.ac.ucr.paraiso.ie.algoritmos.tema7;

import java.util.PriorityQueue;

import java.util.Arrays;

public class Dijkstra {
    private static final int INF = Integer.MAX_VALUE; // Valor infinito para representar la ausencia de conexión

    // Método para encontrar el vértice con la distancia mínima que no ha sido procesado aún
    private int minDistance(int[] dist, boolean[] sptSet, int V) {
        int min = INF, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Método para imprimir la solución
    private void printSolution(int[] dist, int[] prev, String[] nombresNodos, int V, int src) {
        System.out.println("Vertex \t Distance from Source \t Predecessor");
        for (int i = 0; i < V; i++) {
            System.out.print(nombresNodos[i] + " \t\t ");
            if (dist[i] == INF) {
                System.out.print("INF \t\t\t ");
            } else {
                System.out.print(dist[i] + " \t\t\t ");
            }
            if (prev[i] != -1) {
                System.out.print(nombresNodos[prev[i]]);
            } else {
                System.out.print("-");
            }
            System.out.println();
        }

        // Imprimir la ruta más corta desde el nodo fuente a cada nodo
        System.out.println("\nShortest Paths from " + nombresNodos[src] + ":");
        for (int i = 0; i < V; i++) {
            if (i != src && dist[i] != INF) {
                System.out.print("Path to " + nombresNodos[i] + ": ");
                printPath(i, prev, nombresNodos);
                System.out.println(" (Cost: " + dist[i] + ")");
            }
        }
    }
    // Método para imprimir la ruta más corta
    private void printPath(int currentNode, int[] prev, String[] nombresNodos) {
        if (currentNode == -1) {
            return;
        }
        printPath(prev[currentNode], prev, nombresNodos);
        System.out.print(nombresNodos[currentNode] + " ");
    }

    /*private void printSolution(int[] dist, String[] nombresNodos, int V) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(nombresNodos[i] + " \t\t " + (dist[i] == INF ? "INF" : dist[i]));
        }
    }*/

    // Método que implementa el algoritmo de Dijkstra para un grafo representado con una matriz de adyacencia
    public void dijkstra(int[][] graph, int src, String[] nombresNodos) {
        int V = graph.length;
        int[] dist = new int[V]; // Distancia más corta desde src hasta i
        boolean[] sptSet = new boolean[V]; // sptSet[i] será true si el vértice i está incluido en el camino más corto
        int[] prev = new int[V]; // Predecesores de los nodos

        // Inicializar todas las distancias como INFINITO y sptSet[] como falso
        Arrays.fill(dist, INF);
        Arrays.fill(sptSet, false);
        Arrays.fill(prev, -1); // Inicializar predecesores como -1

        // La distancia del nodo origen a sí mismo es siempre 0
        dist[src] = 0;

        // Encontrar el camino más corto para todos los vértices
        for (int count = 0; count < V - 1; count++) {
            // Escoger el vértice de distancia mínima desde el conjunto de vértices no procesados
            int u = minDistance(dist, sptSet, V);

            // Marcar el vértice escogido como procesado
            sptSet[u] = true;

            // Actualizar el valor de dist de los vértices adyacentes del vértice escogido
            for (int v = 0; v < V; v++) {
                // Actualizar dist[v] si no está en sptSet, hay una arista de u a v, y el peso total del camino de src a v a través de u es menor que el valor actual de dist[v]
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    prev[v] = u; // Actualizar el predecesor de v
                }
            }
        }


        // Imprimir la solución
        printSolution(dist, prev, nombresNodos, V, src);
    }
}

