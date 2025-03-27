package me.will.algorithm.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二叉树（邻接表实现方式）
 */
public class MyTree1 {
	private Map<Integer, List<Integer>> map = new HashMap<>();

	// 构建出来的二叉树是这样的：
	//     1
	//    / \
	//   2   3
	//  /   / \
	// 4   5   6
	public static MyTree1 build() {
		MyTree1 tree = new MyTree1();
		Map<Integer, List<Integer>> map = tree.map;
		map.put(1, List.of(2, 3));
		map.put(2, List.of(4));
		map.put(3, List.of(5, 6));
		return tree;
	}
}
