package me.will.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS 算法常用来寻找最短路径
 * 层序遍历
 */
public class Bfs {

	/**
	 * 层序遍历
	 *
	 * @param tree
	 * @return
	 */
	public static List<List<Integer>> levelOrder(MyTree tree) {
		Queue<MyTree.TreeNode> queue = new LinkedList<>();
		queue.add(tree.getRoot());

		List<List<Integer>> result = new ArrayList<>();
		if (tree.getRoot() == null) {
			return result;
		}
		int depth = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> subList = new ArrayList<>();
			System.out.println("当前所在层：" + depth);
			for (int i = 0; i < size; i++) {
				MyTree.TreeNode node = queue.poll();
				if (node == null) {
					continue;
				}
				subList.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			result.add(subList);
			depth++;
		}

		return result;
	}

	public static void main(String[] args) {
		MyTree tree = MyTree.build();
		List<List<Integer>> lists = levelOrder(tree);
		System.out.println(lists);
	}
}
