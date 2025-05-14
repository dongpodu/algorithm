package me.will.algorithm.stack;

import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/decode-string/?envType=study-plan-v2&envId=top-100-liked
 */
public class 字符串解码 {

	/**
	 * https://blog.csdn.net/m0_68989328/article/details/136700289
	 *
	 * @param s
	 * @return
	 */
	public String decodeString(String s) {
		// 创建一个 StringBuilder 对象 res 用于保存解码后的字符串
		StringBuilder res = new StringBuilder();
		// 初始化一个变量 multi，用于保存当前需要重复的次数
		int multi = 0;
		// 创建两个 LinkedList 对象，用作辅助栈，其中一个用于保存重复次数，另一个用于保存中间结果
		LinkedList<Integer> stack_multi = new LinkedList<>();
		LinkedList<String> stack_res = new LinkedList<>();
		// 遍历输入字符串 s 中的每一个字符
		for (Character c : s.toCharArray()) {
			// 如果当前字符是 '[', 表示进入一个新的重复段
			if (c == '[') {
				// 将当前的 multi 压入重复次数栈
				stack_multi.addLast(multi);
				// 将当前的 res 压入中间结果栈
				stack_res.addLast(res.toString());
				// 重置 multi 和 res 为下一个重复段做准备
				multi = 0;
				res = new StringBuilder();
			}
			// 如果当前字符是 ']', 表示一个重复段结束
			else if (c == ']') {
				// 创建一个 StringBuilder 对象 tmp，用于保存当前重复段的重复结果
				StringBuilder tmp = new StringBuilder();
				// 获取当前重复次数
				int cur_multi = stack_multi.removeLast();
				// 将 res 重复 cur_multi 次，然后添加到 tmp 中
				for (int i = 0; i < cur_multi; i++) tmp.append(res);
				// 将中间结果栈的栈顶元素取出，加上 tmp，并赋给 res，表示合并当前重复段的结果
				res = new StringBuilder(stack_res.removeLast() + tmp);
			}
			// 如果当前字符是数字字符，更新 multi
			else if (c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
				// 如果当前字符是字母字符，则直接添加到 res 中
			else res.append(c);
		}
		// 返回最终解码结果
		return res.toString();

	}
}
