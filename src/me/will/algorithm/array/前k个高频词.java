package me.will.algorithm.array;

import java.util.*;

/**
 * https://leetcode.cn/problems/top-k-frequent-elements/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class 前k个高频词 {

	/**
	 * https://programmercarl.com/0347.%E5%89%8DK%E4%B8%AA%E9%AB%98%E9%A2%91%E5%85%83%E7%B4%A0.html
	 *
	 * @param k
	 * @return
	 */
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>(); //key为数组元素值,val为对应出现次数
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		//在优先队列中存储二元组(num, cnt),cnt表示元素值num在数组中的出现次数
		//出现次数按从队头到队尾的顺序是从大到小排,出现次数最多的在队头(相当于大顶堆)
		PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {//大顶堆需要对所有元素进行排序
			pq.add(new int[]{entry.getKey(), entry.getValue()});
		}
		int[] ans = new int[k];
		for (int i = 0; i < k; i++) { //依次从队头弹出k个,就是出现频率前k高的元素
			ans[i] = pq.poll()[0];
		}
		return ans;
	}
}
