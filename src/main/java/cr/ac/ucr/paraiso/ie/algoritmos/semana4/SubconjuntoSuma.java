/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.paraiso.ie.algoritmos.semana4;

/**
 *
 * @author jonat
 */
import java.util.ArrayList;
import java.util.List;

public class SubconjuntoSuma {

    /**
     * Función recursiva para encontrar un subconjunto que suma un valor específico.
     *
     * @param conjunto Conjunto de números.
     * @param indiceActual Índice actual en el conjunto.
     * @param sumaActual Suma actual del subconjunto.
     * @param valorObjetivo Valor objetivo que se busca sumar.
     * @param subconjuntoActual Subconjunto actual (lista de índices).
     * @param subconjuntosEncontrados Lista de subconjuntos que suman el valor objetivo.
     */
    public static void encontrarSubconjuntoSuma(int[] conjunto, int indiceActual, int sumaActual, int valorObjetivo,
                                             List<Integer> subconjuntoActual, List<List<Integer>> subconjuntosEncontrados) {
        if (indiceActual >= conjunto.length) {
            if (sumaActual == valorObjetivo) {
                subconjuntosEncontrados.add(new ArrayList<>(subconjuntoActual));
            }
            return;
        }

        // Incluir el elemento actual en el subconjunto.
        subconjuntoActual.add(indiceActual);
        encontrarSubconjuntoSuma(conjunto, indiceActual + 1, sumaActual + conjunto[indiceActual], valorObjetivo, subconjuntoActual, subconjuntosEncontrados);

        // Excluir el elemento actual del subconjunto.
        subconjuntoActual.remove(subconjuntoActual.size() - 1);
        encontrarSubconjuntoSuma(conjunto, indiceActual + 1, sumaActual, valorObjetivo, subconjuntoActual, subconjuntosEncontrados);
    }

    public static void main(String[] args) {
        int[] conjunto = {1, 2, 3, 4, 5};
        int valorObjetivo = 6;

        List<List<Integer>> subconjuntosEncontrados = new ArrayList<>();
        encontrarSubconjuntoSuma(conjunto, 0, 0, valorObjetivo, new ArrayList<>(), subconjuntosEncontrados);

        if (subconjuntosEncontrados.isEmpty()) {
            System.out.println("No existe un subconjunto que sume el valor objetivo.");
        } else {
            System.out.println("Subconjuntos que suman el valor objetivo:");
            for (List<Integer> subconjunto : subconjuntosEncontrados) {
                System.out.print("[");
                for (int indice : subconjunto) {
                    System.out.print(conjunto[indice] + " ");
                }
                System.out.println("]");
            }
        }
    }
}
