package algorithms;

import java.util.Arrays;

public class TravellingSalesmanProblem {

		private static final int INF = Integer.MAX_VALUE;
	
		public static int findMinCost(int[][] graph) {
			int n = graph.length;
			int[][] dp = new int[n][(1 << n)];
	
			for (int[] row : dp) {
					Arrays.fill(row, -1);
			}
			return tsp(0, 1, graph, dp);
		}
	
		private static int tsp(int currentPos, int visited, int[][] graph, int[][] dp)
{
			int n = graph.length;
	
			if (visited == (1 << n) - 1) {
				return graph[currentPos][0] == 0 ? INF : graph[currentPos][0];
			}
	
			if (dp[currentPos][visited] != -1) {
					return dp[currentPos][visited];
			}
	
			int minCost = INF;
	
			for (int city = 0; city < n; city++) {
					if ((visited & (1 << city)) == 0 && graph[currentPos][city] != 0)
{
							int newCost = graph[currentPos][city] + tsp(city, visited
| (1 << city), graph, dp);
							minCost = Math.min(minCost, newCost);
					}
			}
	
			dp[currentPos][visited] = minCost;
			return dp[currentPos][visited];
		}
	
		public static void main(String[] args) {
			int[][] graph = { { 0, 10, 15, 20 }, { 10, 0, 35, 25 }, 
{ 15, 35, 0, 30},{ 20, 25, 30, 0 } };
	
			System.out.println("Given Graph:");
			for (int i = 0; i < graph.length; i++) {
				System.out.println(Arrays.toString(graph[i]));
			}
	
			int result = findMinCost(graph);
			System.out.println("The Minimum Cost to visit all Cities and return to "
+ "the Starting City is: " + result);
		}	
}
