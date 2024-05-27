/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.paraiso.ie.algoritmos.tema2;

/**
 *
 * @author jonat
 */
import java.util.*;

public class CambioMonedas {

    public static List<Map<Integer, Integer>> cambioMonedas(int cambio, List<Integer> denominaciones) {
        denominaciones.sort(Collections.reverseOrder()); // Ordenar las denominaciones de mayor a menor
        List<Map<Integer, Integer>> resultado = new ArrayList<>();

        for (int moneda : denominaciones) {
            int cantidad = cambio / moneda; // Calcular la cantidad de monedas de esta denominación a utilizar
            Map<Integer, Integer> monedaCantidad = new HashMap<>();
            monedaCantidad.put(moneda, cantidad);
            resultado.add(monedaCantidad); // Agregar la cantidad de monedas a la lista de resultados
            cambio -= cantidad * moneda; // Actualizar el cambio restante
        }

        return resultado;
    }

    public static void main(String[] args) {
        int cambio = 63;
        List<Integer> denominaciones = new ArrayList<>(Arrays.asList(25, 10, 5, 1));
        List<Map<Integer, Integer>> resultado = cambioMonedas(cambio, denominaciones);
        System.out.println("Cambio de " + cambio + " unidades monetarias con denominaciones " + denominaciones);
        for (Map<Integer, Integer> monedaCantidad : resultado) {
            for (Map.Entry<Integer, Integer> entry : monedaCantidad.entrySet()) {
                System.out.println("Moneda de " + entry.getKey() + " : " + entry.getValue() + " monedas");
            }
        }
    }
}