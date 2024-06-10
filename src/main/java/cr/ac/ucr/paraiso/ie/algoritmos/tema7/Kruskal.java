package cr.ac.ucr.paraiso.ie.algoritmos.tema7;

import java.util.*;

class Subset {
    int parent, rank;
}

public class Kruskal {
    private int V;
    private List<int[]> edges = new ArrayList<>();

    // Constructor que recibe el grafo como una matriz de adyacencia
    public Kruskal(int[][] graph) {
        this.V = graph.length;
        // Construir la lista de bordes a partir de la matriz de adyacencia
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (graph[i][j] != 0) {
                    edges.add(new int[]{i, j, graph[i][j]});
                }
            }
        }
    }

    // Método find para encontrar el conjunto de un elemento i
    private int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    // Método union para unir dos subconjuntos
    private void union(Subset[] subsets, int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);

        // Union por rango
        if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else if (subsets[rootX].rank > subsets[rootY].rank) {
            subsets[rootY].parent = rootX;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    // Método principal de Kruskal para encontrar el MST
    public void kruskalMST(String[] nombresNodos) {
        List<int[]> result = new ArrayList<>();
        int e = 0; // Contador de bordes en el MST
        int i = 0; // Índice usado para ordenar los bordes

        // Ordenar los bordes por peso
        edges.sort(Comparator.comparingInt(o -> o[2]));

        // Crear un subconjunto para cada vértice
        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; v++) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        // Número de bordes en el MST será V-1
        while (e < V - 1 && i < edges.size()) {
            int[] nextEdge = edges.get(i++); // Obtener el borde más pequeño
            int x = find(subsets, nextEdge[0]);
            int y = find(subsets, nextEdge[1]);

            // Si no forma un ciclo, incluirlo en el resultado
            if (x != y) {
                result.add(nextEdge);
                union(subsets, x, y);
                e++;
            }
        }

        // Imprimir los bordes del MST
        System.out.println("Edges in the KruskalMST:");
        for (int[] edge : result) {
            System.out.println(nombresNodos[edge[0]] + " -- " +
                    nombresNodos[edge[1]] + " == " + edge[2]);
        }
    }
}

