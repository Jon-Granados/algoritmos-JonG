package cr.ac.ucr.paraiso.ie.algoritmos.clase2;

import java.util.Arrays;

/**
 * @author Jonathan Granados Cortés
 * IF3000 - Algoritmos y Estructuras de Datos
 * Sede del Atlántico - Recinto Paraíso
 * @version 1.0
 * @category Algoritmo Voraz
 */
public class KruskalAlgorithm {
    int V, E;
    public KruskalEdge[] edges;
/**
 * 
 * @param V
 * @param E
 */
    public KruskalAlgorithm(int V, int E) {
        this.V = V;
        this.E = E;
        edges = new KruskalEdge[E];
    }
/**
 * 
 * @param parent
 * @param i
 * @return
 */
    int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }
/**
 * 
 * @param parent
 * @param x
 * @param y
 */
    void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }
/**
 * Kruskal, encuentra el arbol de expansion minima, selecciona en cada paso la arista de menor peso 
 */
    public void kruskalMST() {
    	KruskalEdge[] result = new KruskalEdge[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        Arrays.sort(edges);

        int e = 0;
        int i = 0;
        while (e < V - 1 && i < E) {
        	KruskalEdge nextEdge = edges[i++];
            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                union(parent, x, y);
            }
        }

        System.out.println("Edges in the MST:");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " - " + result[i].dest + ": " + result[i].weight);
    }
}


