package cr.ac.ucr.paraiso.ie.algoritmos.semana2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseWindow {
	public static void main(String[] args) {
        JFrame frame = new JFrame("Ejecutar Métodos");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        JButton btnFactorial = new JButton("Factorial");
        JButton btnKruskal = new JButton("Kruskal");
        JButton btnExhaustiveSearch = new JButton("Exhaustive Search");
        JButton btnKnapsack = new JButton("Knapsack");
        JButton btnFibonacci = new JButton("Fibonacci");
        JButton btnBinarySearch = new JButton("Binary Search");
        JButton btnMontecarloPi = new JButton("Montecarlo Pi");

        panel.add(btnFactorial);
        panel.add(btnKruskal);
        panel.add(btnExhaustiveSearch);
        panel.add(btnKnapsack);
        panel.add(btnFibonacci);
        panel.add(btnBinarySearch);
        panel.add(btnMontecarloPi);

        btnFactorial.addActionListener(e -> runFactorial());
        btnKruskal.addActionListener(e -> runKruskal());
        btnExhaustiveSearch.addActionListener(e -> runExhaustiveSearch());
        btnKnapsack.addActionListener(e -> runKnapsack());
        btnFibonacci.addActionListener(e -> runFibonacci());
        btnBinarySearch.addActionListener(e -> runBinarySearch());
        btnMontecarloPi.addActionListener(e -> runMontecarloPi());

        frame.setVisible(true);
    }

    public static void runFactorial() {
       MainRunExamples.runFactorial(10);
    }

    public static void runKruskal() {
    	 MainRunExamples.runKruskal();
    }

    public static void runExhaustiveSearch() {
    	 MainRunExamples.runExhaustiveSearch();
    }

    public static void runKnapsack() {
    	 MainRunExamples.runKnapsack();
    }

    public static void runFibonacci() {
    	 MainRunExamples.runFibonacci();
    }

    public static void runBinarySearch() {
    	 MainRunExamples.runBinarySearch();
    }

    public static void runMontecarloPi() {
    	 MainRunExamples.runMontecarloPi();
    }
}
