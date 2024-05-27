/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cr.ac.ucr.paraiso.ie.algoritmos.tema2;

import java.util.*;

public class CambioMonedasRecursivo {

    public static List<Map<Integer, Integer>> cambioMonedasRecursivo(int cambio, List<Integer> denominaciones) {
        denominaciones.sort(Collections.reverseOrder()); // Ordenar las denominaciones de mayor a menor
        List<Map<Integer, Integer>> resultado = new ArrayList<>();

        return cambioMonedasRecursivoHelper(cambio, denominaciones, resultado);
    }

    public static List<Map<Integer, Integer>> cambioMonedasRecursivoHelper(int cambio, List<Integer> denominaciones, List<Map<Integer, Integer>> resultado) {
        if (cambio == 0 || denominaciones.isEmpty()) {
            return resultado;
        }

        int moneda = denominaciones.get(0);
        int cantidad = cambio / moneda;
        Map<Integer, Integer> monedaCantidad = new HashMap<>();
        monedaCantidad.put(moneda, cantidad);
        resultado.add(monedaCantidad);

        int nuevoCambio = cambio - cantidad * moneda;
        List<Integer> nuevasDenominaciones = new ArrayList<>(denominaciones.subList(1, denominaciones.size()));

        return cambioMonedasRecursivoHelper(nuevoCambio, nuevasDenominaciones, resultado);
    }

    public static void main(String[] args) {
        int cambio = 63;
        List<Integer> denominaciones = new ArrayList<>(Arrays.asList(25, 10, 5, 1));
        List<Map<Integer, Integer>> resultado = cambioMonedasRecursivo(cambio, denominaciones);
        System.out.println("Cambio de " + cambio + " unidades monetarias con denominaciones " + denominaciones);
        for (Map<Integer, Integer> monedaCantidad : resultado) {
            for (Map.Entry<Integer, Integer> entry : monedaCantidad.entrySet()) {
                System.out.println("Moneda de " + entry.getKey() + " : " + entry.getValue() + " monedas");
            }
        }
    }
}