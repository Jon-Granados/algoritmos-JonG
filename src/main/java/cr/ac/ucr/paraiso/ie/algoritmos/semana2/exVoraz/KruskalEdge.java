package cr.ac.ucr.paraiso.ie.algoritmos.semana2.exVoraz;

/**
 * @author Jonathan Granados Cortés
 * IF3000 - Algoritmos y Estructuras de Datos
 * Sede del Atlántico - Recinto Paraíso
 * @version 1.0
 */
public class KruskalEdge implements Comparable<KruskalEdge> {
    int src, dest, weight;
/**
 * Constructor de Edges
 * @param src
 * @param dest
 * @param weight
 */
    public KruskalEdge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
/**
 * CompareTo, comparacion de pesos de dada edge
 */
    public int compareTo(KruskalEdge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}
