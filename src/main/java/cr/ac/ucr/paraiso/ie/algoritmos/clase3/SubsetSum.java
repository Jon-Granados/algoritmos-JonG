/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.paraiso.ie.algoritmos.clase3;

/**
 *
 * @author jonat
 */
import java.util.*;


public class SubsetSum {
    public static List<Integer> subsetSum(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        List<Integer> subset = new ArrayList<>();
        if (!dp[n][target]) {
            return subset; // Retorna lista vacía si no se encontró subconjunto
        }

        int i = n;
        int j = target;
        while (i > 0 && j > 0) {
            if (dp[i][j] && !dp[i - 1][j]) {
                subset.add(nums[i - 1]);
                j -= nums[i - 1];
            }
            i--;
        }

        return subset;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 6;

        List<Integer> result = subsetSum(nums, target);

        if (!result.isEmpty()) {
            System.out.println("Subconjunto que suma " + target + ": " + result);
        } else {
            System.out.println("No existe un subconjunto que sume " + target + ".");
        }
    }
}