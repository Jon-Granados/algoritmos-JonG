/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.paraiso.ie.algoritmos.tema2;

/**
 *
 * @author jonat
 */
import java.util.Random;

public class CoinFlip {
    public static int countHeads(int n) {
        Random rand = new Random();
        int headsCount = 0;

        for (int i = 0; i < n; i++) {
            int result = rand.nextInt(2); // 0 para cara, 1 para cruz
            if (result == 0) {
                headsCount++;
            }
        }

        return headsCount;
    }

    public static void main(String[] args) {
        int numFlips = 1000; // Número de lanzamientos de moneda
        int heads = countHeads(numFlips);

        System.out.println("Número de veces que salió cara: " + heads);
    }
}