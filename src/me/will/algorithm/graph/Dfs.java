package me.will.algorithm.graph;

import java.util.*;

public class Dfs {

	public void dfsTraverse(Map<Integer, List<Integer>> adj) {
		Set<Integer> visitedVertex = new HashSet<>();
		for (Integer v : adj.keySet()) {
			if (visitedVertex.contains(v)) {
				continue;
			}
			Set<Integer> tmp = dfs(v, adj);
			visitedVertex.addAll(tmp);
		}
	}


	public Set<Integer> dfs(Integer root, Map<Integer, List<Integer>> adj) {
		List<Integer> ns = adj.get(root);
		if (ns == null || ns.size() == 0) {
			return Collections.emptySet();
		}
		Set<Integer> visitedVertex = new HashSet<>();
		for (Integer v : ns) {
			if (!visitedVertex.contains(v)) {
				Set<Integer> set = dfs(v, adj);
				visitedVertex.addAll(set);
			}
		}
		return visitedVertex;
	}
}
