package me.will.algorithm.graph;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

public class BfsAndModify {

	public static void traverseAndModify(Map<Integer, Set<Integer>> graph, Integer start, Predicate<Integer> condition) {
		Set<Integer> visited = new HashSet<>();
		bfs(start, graph, visited, condition);
	}

	public static void bfs(Integer start, Map<Integer, Set<Integer>> graph, Set<Integer> visited, Predicate<Integer> condition) {
		Map<Integer, Integer> vertexPredecessorMap = new HashMap<>();
		graph.forEach((k, vs) -> {
			vs.forEach(v -> {
				vertexPredecessorMap.put(v, k);
			});
		});

		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited.add(start);
		while (!queue.isEmpty()) {
			int current = queue.poll();
			Set<Integer> ns = graph.get(current);
			Integer predecessor = vertexPredecessorMap.get(current);
			if (predecessor != null && !condition.test(current)) {
				Set<Integer> predecessorNeighbour = graph.get(predecessor);
				//让前继节点关联下游节点
				if (!isEmpty(ns)) {
					predecessorNeighbour.addAll(ns);
					//更改前继节点关系
					ns.forEach(n -> vertexPredecessorMap.put(n, predecessor));
				}
				predecessorNeighbour.remove(current);
				//让前继节点再遍历一遍
				visited.removeIf(predecessorNeighbour::contains);
				visited.remove(predecessor);
				queue.removeIf(predecessorNeighbour::contains);
				queue.addFirst(predecessor);
			} else if (!isEmpty(ns)) {
				for (Integer v : ns) {
					if (!visited.contains(v)) {
						visited.add(v);
						queue.add(v);
					}
				}
			}
		}
	}

	public static boolean isEmpty(Collection c) {
		return c == null || c.isEmpty();
	}

	public static void main(String[] args) {
		Map<Integer, Set<Integer>> graph = new ConcurrentHashMap<>();
		graph.put(1, new HashSet<Integer>() {{
			add(2);
			add(3);
		}});
		graph.put(2, new HashSet<Integer>() {{
			add(4);
			add(5);
		}});
		graph.put(3, new HashSet<Integer>() {{
			add(6);
			add(7);
		}});
		graph.put(6, new HashSet<Integer>() {{
			add(8);
		}});
		graph.put(7, new HashSet<Integer>() {{
			add(9);
		}});

		int startNode = 1;

		Predicate<Integer> condition = node -> node % 2 == 1;
		traverseAndModify(graph, startNode, condition);

		System.out.println(graph);
	}
}
