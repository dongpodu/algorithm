package me.will.algorithm1;

import java.util.HashMap;
import java.util.Map;

public class LRUCache1 {

	public static class Node {
		Node pre;
		Node next;
		int key;
		int value;
	}

	Node head;
	Node tail;
	Map<Integer, Node> store;
	int capacity;

	public LRUCache1(int capacity) {
		this.capacity = capacity;
		this.store = new HashMap<>();
	}

	public int get(int key) {
		Node n = store.get(key);
		if (n == null) {
			return -1;
		}
		insertHead(n);
		return n.value;
	}

	public void put(int key, int value) {
		Node node = store.get(key);
		if (node == null) {
			node = new Node();
			node.key = key;
			node.value = value;

			store.put(key, node);
		} else {
			node.value = value;
			store.put(key, node);
		}

		insertHead(node);

		eliminateOld();
	}

	private void eliminateOld() {
		if (store.size() > capacity) {
			Node current = tail;
			while (store.size() > capacity) {
				if (current == null) {
					break;
				}
				current.next = null;
				store.remove(current.key);
				current = current.pre;
			}
		}
	}

	private void insertHead(Node n) {
		if (head == null) {
			head = n;
			tail = n;
		} else {
			Node nPre = n.pre;
			Node nNext = n.next;
			if (nPre != null) {
				nPre.next = nNext;
			}
			if (nNext != null) {
				nNext.pre = nPre;
			}
			Node oldHead = head;
			head = n;
			head.pre = null;
			head.next = oldHead;
			oldHead.pre = head;
		}
	}

	public static void main(String[] args) {
		LRUCache1 cache1 = new LRUCache1(3);
		cache1.put(1, 1);
		cache1.put(2, 2);
		cache1.put(3, 3);
		cache1.put(4, 4);
		cache1.put(5, 5);
		cache1.put(6, 6);

		System.out.println(cache1.get(1));
		System.out.println(cache1.get(2));
		System.out.println(cache1.get(3));
		System.out.println(cache1.get(4));
		System.out.println(cache1.get(5));
		System.out.println(cache1.get(6));
	}
}
