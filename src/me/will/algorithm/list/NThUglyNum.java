package me.will.algorithm.list;

/**
 * 寻找第n个丑数
 */
public class NThUglyNum {
	/**
	 * https://labuladong.online/algo/problem-set/linkedlist-two-pointers/#slug_ugly-number-ii
	 *
	 * @param n
	 * @return
	 */
	public static int nthUglyNum(int n) {
		// 可以理解为三个指向有序链表头结点的指针
		int p2 = 1, p3 = 1, p5 = 1;
		// 可以理解为三个有序链表的头节点的值
		int product2 = 1, product3 = 1, product5 = 1;

		int[] ugly = new int[n + 1];
		int p = 1;
		while (p <= n) {
			int min = Math.min(product2, Math.min(product3, product5));
			ugly[p] = min;
			p++;

			if (min == product2) {
				product2 = 2 * ugly[p2];
				p2++;
			}

			if (min == product3) {
				product3 = 3 * ugly[p3];
				p3++;
			}

			if (min == product5) {
				product5 = 5 * ugly[p5];
				p5++;
			}
		}

		return ugly[n];
	}
}
