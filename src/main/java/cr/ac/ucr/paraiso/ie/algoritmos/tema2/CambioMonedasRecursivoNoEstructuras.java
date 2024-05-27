/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.paraiso.ie.algoritmos.tema2;

/**
 *
 * @author jonat
 */
public class CambioMonedasRecursivoNoEstructuras {

    public static void cambioMonedasRecursivo(int cambio, int[] denominaciones, int index) {
        if (cambio == 0) {
            return;
        }

        int cantidad = cambio / denominaciones[index];
        System.out.println("Moneda de " + denominaciones[index] + " : " + cantidad + " monedas");

        int nuevoCambio = cambio - cantidad * denominaciones[index];
        cambioMonedasRecursivo(nuevoCambio, denominaciones, index + 1);
    }

    public static void main(String[] args) {
        int cambio = 63;
        int[] denominaciones = {25, 10, 5, 1};
        System.out.println("Cambio de " + cambio + " unidades monetarias con denominaciones {25, 10, 5, 1}");
        cambioMonedasRecursivo(cambio, denominaciones, 0);
    }
}
