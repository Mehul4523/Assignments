package graph;

import java.util.*;

public class GraphEdge {

	private final Map<Integer, List<Integer>> adjList;
	
	public GraphEdge() {
		adjList = new HashMap<>();
	}
	
	public void addNode(int node) {
		adjList.putIfAbsent(node, new ArrayList<>());
	}
	
	public boolean addEdge(int from, int to) {
		addNode(from);
		addNode(to);
	
		// Check for cycles before adding the edge
		if (createsCycle(from, to)) {
			return false;
		}
		
		adjList.get(from).add(to);
		return true;
	}
	
	private boolean createsCycle(int from, int to) {
		Set<Integer> visited = new HashSet<>();
		return hasCycle(from, to, visited);
	}
	
	private boolean hasCycle(int current, int target, Set<Integer> visited) {
		if (current == target) {
			return true;
		}
	
		visited.add(current);
	
		for (int neighbor : adjList.getOrDefault(current, 
	Collections.emptyList())) {
	
			if (!visited.contains(neighbor) && hasCycle(neighbor, target, 
	visited)) {
	
				return true;
			}
	}
	
		visited.remove(current);
	
		return false;
	}
	
	public void printGraph() {
		for (int node : adjList.keySet()) {
			System.out.print(node + " -> ");
			
			for (int neighbor : adjList.get(node)) {
				System.out.print(neighbor + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		GraphEdge graph = new GraphEdge();
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
	
		System.out.println("Adding edge 1 -> 2: " + graph.addEdge(1, 2));
		System.out.println("Adding edge 2 -> 3: " + graph.addEdge(2, 3));
		System.out.println("Adding edge 3 -> 4: " + graph.addEdge(3, 4));
		System.out.println("Adding edge 4 -> 1 (creates cycle): " + 
	graph.addEdge(4, 1));
	
		System.out.println("Graph:");
		graph.printGraph();
	}
}
