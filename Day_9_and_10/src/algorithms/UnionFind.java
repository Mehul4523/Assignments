package algorithms;

import java.util.*;

public class UnionFind {

		class Edge {
			int src, dest;
		}
		
		int V, E;
		Edge edge[];
		
		UnionFind(int v, int e) {
			V = v;
			E = e;
			edge = new Edge[E];
		
			for (int i = 0; i < e; ++i)
				edge[i] = new Edge();
		}
		
		int find(int parent[], int i) {
				if (parent[i] == -1)
					return i;
				return parent[i] = find(parent, parent[i]);
		}
		
		void union(int parent[], int x, int y) {
				int xset = find(parent, x);
				int yset = find(parent, y);
				parent[xset] = yset;
		}
		
		int isCycle(UnionFind graph) {
				int parent[] = new int[graph.V];
				Arrays.fill(parent, -1);
		
				for (int i = 0; i < graph.E; ++i) {
						int x = find(parent, graph.edge[i].src);
						int y = find(parent, graph.edge[i].dest);
		
						if (x == y)
							return 1;
		
						union(parent, x, y);
				}
				return 0;
		}
		
		public static void main(String[] args) {
			int V = 3, E = 3;
		
			UnionFind graph = new UnionFind(V, E);
			graph.edge[0].src = 0;
			graph.edge[0].dest = 1;
			graph.edge[1].src = 1;
			graph.edge[1].dest = 2;
			graph.edge[2].src = 0;
			graph.edge[2].dest = 2;
		
			if (graph.isCycle(graph) == 1)		
				System.out.println("Graph contains cycle");		
			else		
				System.out.println("Graph doesn't contain cycle");
		}
}
