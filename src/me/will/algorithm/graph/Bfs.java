package me.will.algorithm.graph;

import java.util.*;

public class Bfs {

	/**
	 * 邻接表结构bfs
	 *
	 * @param adj
	 */
	public void bfsTraverse(Map<Integer, List<Integer>> adj) {
		Set<Integer> visited = new HashSet<>();
		for (Integer v : adj.keySet()) {
			if (visited.contains(v)) {
				continue;
			}
			bfs(v, adj, visited);
		}
	}

	public void bfs(Integer root, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(root);
		visited.add(root);
		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			List<Integer> ns = graph.get(vertex);
			if (ns == null || ns.size() == 0) {
				continue;
			}
			for (Integer v : ns) {
				if (!visited.contains(v)) {
					visited.add(v);
					queue.add(v);
				}
			}
		}
	}

	/**
	 * 邻接矩阵结构bfs
	 *
	 * @param graph
	 */
	public void bfsTraverse(int[][] graph) {
		int vertexSize = graph.length;
		boolean[] visited = new boolean[vertexSize];//用于记录顶点是否已访问
		for (int i = 0; i < vertexSize; i++) {
			if (!visited[i]) {
				bfs(i, graph, visited);
			}
		}
	}

	public void bfs(int start, int[][] graph, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			Integer i = queue.poll();
			for (int j = 0; j < graph.length; j++) {
				if (graph[i][j] == 1 && !visited[j]) {
					queue.add(j);
					visited[j] = true;
				}
			}
		}
	}
}
