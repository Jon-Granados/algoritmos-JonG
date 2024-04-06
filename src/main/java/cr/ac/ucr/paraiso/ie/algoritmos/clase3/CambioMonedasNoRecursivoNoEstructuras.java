/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.paraiso.ie.algoritmos.clase3;

/**
 *
 * @author jonat
 */
public class CambioMonedasNoRecursivoNoEstructuras {

    public static void cambioMonedasNoRecursivo(int cambio, int[] denominaciones) {
        for (int i = 0; i < denominaciones.length; i++) {
            if (cambio == 0) {
                break;
            }
            int cantidad = cambio / denominaciones[i];
            System.out.println("Moneda de " + denominaciones[i] + " : " + cantidad + " monedas");
            cambio -= cantidad * denominaciones[i];
        }
    }

    public static void main(String[] args) {
        int cambio = 63;
        int[] denominaciones = {25, 10, 5, 1};
        System.out.println("Cambio de " + cambio + " unidades monetarias con denominaciones {25, 10, 5, 1}");
        cambioMonedasNoRecursivo(cambio, denominaciones);
    }
}
