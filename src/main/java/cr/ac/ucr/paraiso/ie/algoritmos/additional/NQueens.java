package cr.ac.ucr.paraiso.ie.algoritmos.additional;

public class NQueens {
    private int N;
    private int[][] board;

    // Constructor para inicializar el tablero y el tamaño N
    public NQueens(int N) {
        this.N = N;
        board = new int[N][N];
    }

    // Método para imprimir el tablero
    private void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para comprobar si una reina puede ser colocada en board[row][col]
    private boolean isSafe(int row, int col) {
        // Comprobar esta columna en filas anteriores
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Comprobar la diagonal superior izquierda
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Comprobar la diagonal superior derecha
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Método recursivo para resolver el problema de las N reinas
    private boolean solveNQueens(int row) {
        // Si todas las reinas están colocadas, devolver true
        if (row >= N) {
            return true;
        }

        // Considerar esta fila y probar todas las columnas
        for (int col = 0; col < N; col++) {
            // Comprobar si se puede colocar una reina en board[row][col]
            if (isSafe(row, col)) {
                // Colocar la reina en board[row][col]
                board[row][col] = 1;

                // Recursivamente colocar el resto de las reinas
                if (solveNQueens(row + 1)) {
                    return true;
                }

                // Si colocar la reina en board[row][col] no lleva a una solución,
                // quitar la reina de board[row][col]
                board[row][col] = 0; // BACKTRACK
            }
        }

        // Si la reina no puede ser colocada en ninguna columna en esta fila, devolver false
        return false;
    }

    // Método para resolver el problema de las N reinas y mostrar la solución
    public void solve() {
        if (solveNQueens(0)) {
            printSolution();
        } else {
            System.out.println("No solution exists");
        }
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        int N = 8; // Tamaño del tablero (por ejemplo, 8 para el problema de las 8 reinas)
        NQueens queens = new NQueens(N);
        queens.solve();
    }
}
