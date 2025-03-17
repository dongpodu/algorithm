package me.will.algorithm;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * <p>
 * https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0239.%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E6%9C%80%E5%A4%A7%E5%80%BC.md
 */
public class MaxSlidingWindow {

	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] result = new int[nums.length-k+1];
		MyQueue q = new MyQueue();
		for(int i=0;i<nums.length+1;i++){
			if(i<k){
				q.add(nums[i]);
			}else if(i<nums.length){
				result[i-k] = q.peek();
				q.poll(nums[i-k]);
				q.add(nums[i]);
			}else{
				result[i-k] = q.peek();
			}
		}
		return result;
	}

	public static class MyQueue{
		LinkedList<Integer> q = new LinkedList<>();

		void poll(int v){
			if(!q.isEmpty() && q.peek()==v){
				q.poll();
			}
		}

		void add(int v){
			while(!q.isEmpty() && q.getLast()<v){
				q.removeLast();
			}
			q.add(v);
		}

		int peek(){
			return q.peek();
		}
	}
}
