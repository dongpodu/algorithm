package me.will.algorithm.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用双端队列，按照使用时间依次排列，每次使用（set、put）都将节点放在头部，当容量超过时，从队尾删除数据
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> {
	public static class Node<K, V> {
		private Node pre;
		private Node next;
		private V v;
		private K k;

		public Node(V v, K k) {
			this.v = v;
			this.k = k;
		}

		public Node getPre() {
			return pre;
		}

		public void setPre(Node pre) {
			this.pre = pre;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public V getV() {
			return v;
		}

		public void setV(V v) {
			this.v = v;
		}

		public K getK() {
			return k;
		}

		public void setK(K k) {
			this.k = k;
		}
	}

	private Map<K, Node<K, V>> map = new HashMap<>();
	/**
	 * 最年轻的节点
	 */
	private Node<K, V> head;
	/**
	 * 最老的节点
	 */
	private Node<K, V> tail;
	/**
	 * 容量
	 */
	private int cap;

	public V get(K key) {
		Node<K, V> node = map.get(key);
		if (node != null) {
			remove(node);
			appendHead(node);
			return node.getV();
		}
		return null;
	}

	public void set(K key, V v) {
		Node node = map.get(key);
		if (node == null) {
			node = new Node(key, v);
			appendHead(node);
		} else {
			node.setV(v);
			remove(node);
			appendHead(node);
		}
		int size = map.size();
		if (size > cap) {
			Node<K, V> n = removeOldest();
			map.remove(n.getK());
		}
	}

	private void remove(Node node) {
		Node pre = node.pre;
		Node next = node.next;
		pre.next = next;
		next.pre = pre;
	}

	private Node<K, V> removeOldest() {
		Node t = tail;
		Node pre = tail.pre;
		pre.next = null;
		tail = pre;
		return t;
	}

	private void appendHead(Node node) {
		Node h = head;
		if (h == null) {
			h = node;
		}
		head = node;
		head.next = h;
	}
}
