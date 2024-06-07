package graph;

import java.util.*;
public class DFSUndirectedGraph {

	private final Map<Integer, List<Integer>> adjList;
	public DFSUndirectedGraph() {
	adjList = new HashMap<>();
	}
	public void addEdge(int from, int to) {
	adjList.putIfAbsent(from, new ArrayList<>());
	adjList.putIfAbsent(to, new ArrayList<>());
	adjList.get(from).add(to);
	adjList.get(to).add(from);
	}
	public void dfs(int start) {
	Set<Integer> visited = new HashSet<>();
	dfsHelper(start, visited);
	System.out.println();
	}
	private void dfsHelper(int node, Set<Integer> visited) {
	if (visited.contains(node)) {
	return;
	}
	visited.add(node);
	System.out.print(node + " ");
	for (int neighbor : adjList.getOrDefault(node, 
	Collections.emptyList())) {
	dfsHelper(neighbor, visited);
	}
	}
	public static void main(String[] args) {
		DFSUndirectedGraph graph = new DFSUndirectedGraph();
	graph.addEdge(1, 2);
	graph.addEdge(1, 3);
	graph.addEdge(2, 4);
	graph.addEdge(3, 4);
	graph.addEdge(4, 5);
	System.out.println("DFS traversal starting from node 1:");
	graph.dfs(1);
	}

}
