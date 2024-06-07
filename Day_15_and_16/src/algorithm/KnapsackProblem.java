package algorithm;

import java.util.Arrays;

public class KnapsackProblem {

	public static int knapsack(int W, int[] weights, int[] values) {
			int n = weights.length;
			int[][] dp = new int[n + 1][W + 1];
		
			// Initialize first row and column for base cases
			for (int i = 0; i <= W; i++) {
					dp[0][i] = 0; // No items, max value is 0
			}
			
			for (int i = 1; i <= n; i++) {
				dp[i][0] = 0; // Capacity 0, max value is 0
			}
		
			// Build DP table
			for (int i = 1; i <= n; i++) {
					for (int w = 1; w <= W; w++) {
							if (weights[i - 1] > w) {
								// If weight exceeds capacity, inherit value from previous item
								dp[i][w] = dp[i - 1][w];
							} else {
									// Choose the max value: include or exclude current item
									dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] +
dp[i - 1][w - weights[i - 1]]);
							}
					}
			}
			return dp[n][W];
		}
		
	public static void main(String[] args) {
			int W = 30;
			int[] weights = { 10, 20, 30 };
			int[] values = { 60, 100, 120 };
		
			System.out.println("Knapsack Capacity: " + W);
			System.out.println("Weights of Items: " + Arrays.toString(weights));
			System.out.println("Values of Items: " + Arrays.toString(values));
		
			int maxValue = knapsack(W, weights, values);
			System.out.println("Maximum value in knapsack: " + maxValue);
		}
}
