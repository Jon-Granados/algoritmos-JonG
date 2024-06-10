package cr.ac.ucr.paraiso.ie.algoritmos.tema7;


import java.util.PriorityQueue;

public class AlgoritmoPrim {
    private static final int INF = Integer.MAX_VALUE;

    public static void primMST(int[][] grafo, String[] nombresNodos) {
        // Inicializamos variables para el algoritmo
        int numVertices = grafo.length;
        int[] distancia = new int[numVertices]; // Distancia desde el nodo raíz hasta cada nodo
        boolean[] visitado = new boolean[numVertices]; // Indica si un nodo ha sido visitado
        int[] padre = new int[numVertices]; // Padre de cada nodo en el MST

        // Inicializamos las distancias y padres de los nodos
        for (int i = 0; i < numVertices; i++) {
            distancia[i] = INF; // Distancia inicialmente infinita
            padre[i] = -1; // Padre inicialmente no definido
        }

        // Inicializamos la distancia del nodo raíz a 0
        distancia[0] = 0;

        // Creamos una cola de prioridad para seleccionar los nodos con menor distancia
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> distancia[a] - distancia[b]);
        pq.offer(0); // Agregamos el nodo raíz a la cola

        // Iteramos hasta que todos los nodos hayan sido visitados
        while (!pq.isEmpty()) {
            // Extraemos el nodo con menor distancia de la cola
            int u = pq.poll();
            visitado[u] = true; // Marcamos como visitado

            // Iteramos sobre los vecinos del nodo actual
            for (int v = 0; v < numVertices; v++) {
                // Si el peso de la arista es diferente de 0 y el nodo no ha sido visitado
                // y el peso de la arista es menor que la distancia actual del nodo
                if (grafo[u][v] != 0 && !visitado[v] && grafo[u][v] < distancia[v]) {
                    // Actualizamos la distancia y el padre del nodo
                    distancia[v] = grafo[u][v];
                    padre[v] = u;
                    pq.offer(v); // Agregamos el nodo al final de la cola
                }
            }
        }

        // Imprimimos el árbol de expansión mínima
        System.out.println("Árbol de expansión mínima (PrimMST):");
        for (int i = 1; i < numVertices; i++) {
            System.out.println(nombresNodos[padre[i]] + " - " + nombresNodos[i]);
        }
    }
}
