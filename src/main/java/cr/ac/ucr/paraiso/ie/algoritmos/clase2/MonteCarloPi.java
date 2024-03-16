package cr.ac.ucr.paraiso.ie.algoritmos.clase2;

import java.util.Random;
/**
 * @author Jonathan Granados Cortés
 * IF3000 - Algoritmos y Estructuras de Datos
 * Sede del Atlántico - Recinto Paraíso
 * @version 1.0
 * @category Algoritmo Probabilistico
 */
public class MonteCarloPi {
/**
 * Método que utiliza Monte Carlo para estimar el valor de π(Pi). 
 * Se generan puntos aleatorios dentro de un cuadrado unitario 
 * y se cuenta cuántos caen dentro del círculo unitario inscrito. 
 * La relación entre los puntos dentro del círculo y el total de 
 * puntos generados se utiliza para estimar el valor de π.
 * @param numPoints
 * @return
 */
    public static double estimatePi(int numPoints) {//O(n)
        Random random = new Random();
        int pointsInsideCircle = 0;

        for (int i = 0; i < numPoints; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();

            if (x * x + y * y <= 1) {
                pointsInsideCircle++;
            }
        }

        return 4.0 * pointsInsideCircle / numPoints;
    }
  
}
