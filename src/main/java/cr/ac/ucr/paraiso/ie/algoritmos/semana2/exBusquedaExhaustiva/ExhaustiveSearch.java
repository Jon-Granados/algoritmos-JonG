package cr.ac.ucr.paraiso.ie.algoritmos.semana2.exBusquedaExhaustiva;
/**
 * @author Jonathan Granados Cortés
 * IF3000 - Algoritmos y Estructuras de Datos
 * Sede del Atlántico - Recinto Paraíso
 * @version 1.0
 * @category Busqueda Exhaustiva
 */
public class ExhaustiveSearch {
/**
 * Algoritmo de busqueda exhaustiva para encontrar la raiz cuadrada de un numero
 * @param n
 * @return
 */
    public static int findSquareRoot(int n) {//O(n) 
        for (int i = 0; i <= n; i++) {
            if (i * i == n) {
                return i;
            }
        }
        return -1; // Si no se encuentra la raíz cuadrada entera
    }
    
}
