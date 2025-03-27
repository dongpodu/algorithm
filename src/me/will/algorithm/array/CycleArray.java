package me.will.algorithm.array;

/**
 * 环形数组技巧利用求模（余数）运算，将普通数组变成逻辑上的环形数组，可以让我们用O(1)的时间在数组头部增删元素。
 * @param <T>
 */
public class CycleArray<T> {
	private T[] array;
	//数组大小
	private int size;
	//数组中元素个数
	private int count;
	//指向第一个有效元素（闭区间）
	private int start;
	//指向最后一个有效元素的下一个位置（开区间）
	private int end;

	public CycleArray(int size) {
		this.size = size;
		this.array = (T[]) new Object[size];
		this.count = 0;
		this.start = 0;
		this.end = 0;
	}

	public void addFirst(T t) {
		if (isFull()) {
			throw new RuntimeException("CycleArray is full");
		}
		start = (start - 1 + size) % size;
		array[start] = t;
		count++;
	}

	public void removeFirst() {
		if (isEmpty()) {
			throw new RuntimeException("CycleArray is empty");
		}
		array[start] = null;
		start = (start + 1) % size;
		count--;
	}

	public T getFirst() {
		if (isEmpty()) {
			throw new RuntimeException("CycleArray is empty");
		}
		return array[start];
	}

	public void addLast(T t) {
		if (isFull()) {
			throw new RuntimeException("CycleArray is full");
		}
		array[end] = t;
		end = (end + 1) % size;
		count++;
	}

	public void removeLast() {
		if (isEmpty()) {
			throw new RuntimeException("CycleArray is empty");
		}
		end = (end - 1 + size) % size;
		array[end] = null;
		count--;
	}

	public T getLast() {
		if (isEmpty()) {
			throw new RuntimeException("CycleArray is empty");
		}
		return array[(end - 1 + size) % size];
	}

	private boolean isFull() {
		return count == size;
	}

	private boolean isEmpty() {
		return count == 0;
	}
}
