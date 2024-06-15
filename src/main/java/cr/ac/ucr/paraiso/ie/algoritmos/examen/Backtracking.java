package cr.ac.ucr.paraiso.ie.algoritmos.examen;

import java.util.Arrays;

public class Backtracking {
	// Método que devuelve la longitud de la subsecuencia más larga sin números repetidos
    public static int longestSubsequence(int[] sequence) {
        // Inicializar la longitud de la subsecuencia más larga a 0
        int maxLen = 0;

        // Iterar sobre la secuencia de números
        for (int i = 0; i < sequence.length; i++) {
            // Crear un array booleano para llevar un registro de los números que ya han aparecido
            boolean[] seen = new boolean[100001]; // Asumimos que los números están en el rango [0, 100000]

            // Inicializar la longitud de la subsecuencia actual a 0
            int len = 0;

            // Iterar sobre la secuencia de números desde el índice actual
            for (int j = i; j < sequence.length; j++) {
                // Verificar si el número actual no se ha visto antes
                if (!seen[sequence[j]]) {
                    // Marcar el número actual como visto en el array seen
                    seen[sequence[j]] = true;
                    // Incrementar la longitud de la subsecuencia actual
                    len++;
                } else {
                    // Romper el bucle interno si se encuentra un número que ya ha aparecido
                    break;
                }
            }

            // Actualizar la longitud de la subsecuencia más larga si la subsecuencia actual es más larga
            maxLen = Math.max(maxLen, len);

            // Restablecer el array seen a false para la siguiente iteración
            //se agrega esta instruccion para eliminar un ciclo pero se puede realizar por recorrido
            Arrays.fill(seen, false);
        }

        // Devolver la longitud de la subsecuencia más larga sin números repetidos
        return maxLen;
    }

    // Método principal que llama al método longestSubsequence
    public static void main(String[] args) {
        // Secuencia de números
        int[] sequence = {1, 2, 3, 4, 5, 2, 3, 6, 7, 8, 9, 2, 3, 4, 5};

        // Imprimir la longitud de la subsecuencia más larga sin números repetidos
        System.out.println("La longitud de la subsecuencia más larga sin números repetidos es: " + longestSubsequence(sequence));
    }
}
