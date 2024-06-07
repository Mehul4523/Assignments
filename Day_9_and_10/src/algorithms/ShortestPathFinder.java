package algorithms;

import java.util.*;

public class ShortestPathFinder {

	static class Node implements Comparable<Node> {
			int vertex;
			int weight;
		
			Node(int vertex, int weight) {
				this.vertex = vertex;
				this.weight = weight;
			}
		
			@Override
			public int compareTo(Node other) {
					return Integer.compare(this.weight, other.weight);
				}
		}
		
	public static void dijkstra(int[][] graph, int startVertex) {
			int V = graph.length;
			int[] distances = new int[V];
			boolean[] shortestPathTreeSet = new boolean[V];
		
			Arrays.fill(distances, Integer.MAX_VALUE);
			distances[startVertex] = 0;
		
			PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
			priorityQueue.add(new Node(startVertex, 0));
		
			while (!priorityQueue.isEmpty()) {
					int u = priorityQueue.poll().vertex;
		
					if (!shortestPathTreeSet[u]) {
							shortestPathTreeSet[u] = true;
		
							for (int v = 0; v < V; v++) {
								if (!shortestPathTreeSet[v] && graph[u][v] != 0 
				&& distances[u] != Integer.MAX_VALUE
						&& distances[u] + graph[u][v] < 
		distances[v]) {
									distances[v] = distances[u] + graph[u][v];
									priorityQueue.add(new Node(v, 
		distances[v]));
								}
							}
					}
			}
			printSolution(distances, V);
		}
		
	private static void printSolution(int[] distances, int V) {
			System.out.println("Vertex \t Distance from Source");
			for (int i = 0; i < V; i++)
					System.out.println(i + " \t\t " + distances[i]);
				}
		
	public static void main(String[] args) {
			int graph[][] = new int[][] { { 0, 10, 0, 30, 100 }, { 10, 0, 50, 0, 
	0 }, { 0, 50, 0, 20, 10 },
						{ 30, 0, 20, 0, 60 }, { 100, 0, 10, 60, 0 } };
			ShortestPathFinder.dijkstra(graph, 0);
		}
}
