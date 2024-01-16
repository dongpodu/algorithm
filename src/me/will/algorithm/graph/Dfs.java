package me.will.algorithm.graph;

import java.util.*;

public class Dfs {

	/**
	 * 邻接表结构dfs
	 *
	 * @param adj
	 */
	public void dfsTraverse(Map<Integer, List<Integer>> adj) {
		Set<Integer> visitedVertex = new HashSet<>();
		for (Integer v : adj.keySet()) {
			if (visitedVertex.contains(v)) {
				continue;
			}
			dfs(v, adj, visitedVertex);
		}
	}


	public void dfs(Integer root, Map<Integer, List<Integer>> adj, Set<Integer> visited) {
		List<Integer> ns = adj.get(root);
		if (ns == null || ns.size() == 0) {
			return;
		}
		for (Integer v : ns) {
			if (!visited.contains(v)) {
				dfs(v, adj, visited);
			}
		}
	}
}
