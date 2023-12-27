package me.will.algorithm.graph;

import java.util.*;

public class Bfs {

	public void bfsTraverse(Map<Integer, List<Integer>> adj) {
		Set<Integer> visitedVertex = new HashSet<>();
		for (Integer v : adj.keySet()) {
			if (visitedVertex.contains(v)) {
				continue;
			}
			Set<Integer> tmp = bfs(v, adj);
			visitedVertex.addAll(tmp);
		}
	}


	public Set<Integer> bfs(Integer root, Map<Integer, List<Integer>> adj) {
		Set<Integer> visitedVertex = new HashSet<>();
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			List<Integer> ns = adj.get(vertex);
			if (ns == null || ns.size() == 0) {
				continue;
			}
			for (Integer v : ns) {
				if (!visitedVertex.contains(v)) {
					visitedVertex.add(v);
					queue.add(v);
				}
			}
		}
		return visitedVertex;
	}
}
