package graph;

import java.util.*;

public class BFSUndirectedGraph {

	private final Map<Integer, List<Integer>> adjList;
	
	public BFSUndirectedGraph() {
		adjList = new HashMap<>();
	}
	
	public void addEdge(int from, int to) {
		adjList.putIfAbsent(from, new ArrayList<>());
		adjList.putIfAbsent(to, new ArrayList<>());
		adjList.get(from).add(to);
		adjList.get(to).add(from);
	}
	
	public void bfs(int start) {
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
	
		queue.add(start);
		visited.add(start);
	
		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");
	
			for (int neighbor : adjList.getOrDefault(node, 
	Collections.emptyList())) {
				if (!visited.contains(neighbor)) {
					queue.add(neighbor);
					visited.add(neighbor);
				}
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		BFSUndirectedGraph graph = new BFSUndirectedGraph();
			graph.addEdge(1, 2);
			graph.addEdge(1, 3);
			graph.addEdge(2, 4);
			graph.addEdge(3, 4);
			graph.addEdge(4, 5);
	
		System.out.println("BFS traversal starting from node 1:");
	graph.bfs(1);
	}

}
