package cr.ac.ucr.paraiso.ie.algoritmos;

public class ExhaustiveSearchAlgorithm {

    public double knapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        double[] valuePerWeight = new double[n];

        for (int i = 0; i < n; i++) {
            valuePerWeight[i] = (double) values[i] / weights[i];
        }

        double totalValue = 0;
        int remainingCapacity = capacity;

        while (remainingCapacity > 0) {
            int bestItemIndex = -1;
            double bestValuePerWeight = 0;

            for (int i = 0; i < n; i++) {
                if (weights[i] > 0 && valuePerWeight[i] > bestValuePerWeight) {
                    bestValuePerWeight = valuePerWeight[i];
                    bestItemIndex = i;
                }
            }

            if (bestItemIndex == -1) {
                break; // No more items can be added
            }

            int amountToAdd = Math.min(remainingCapacity, weights[bestItemIndex]);
            totalValue += amountToAdd * valuePerWeight[bestItemIndex];
            weights[bestItemIndex] -= amountToAdd;
            remainingCapacity -= amountToAdd;
        }

        return totalValue;
    }
}