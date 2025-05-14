package me.will.algorithm.string;

public class 循环左移 {

	/**
	 * 将字符串循环左移
	 * 算法：将字符串分成两个子串a和b，将a和b反转，得到a'和b'，然后将a'和b'拼接，得到a'b'，再将此字符串反转得到ba
	 *
	 * @param s
	 * @param m 左移m位
	 */
	public static char[] rotate(char[] s, int m) {
		char[] s1 = String.valueOf(s, 0, m).toCharArray();
		char[] s2 = String.valueOf(s, m, s.length - m).toCharArray();
		reverseString(s1);
		reverseString(s2);
		char[] s3 = (String.valueOf(s1) + String.valueOf(s2)).toCharArray();
		reverseString(s3);
		return s3;
	}

	public static void reverseString(char[] array) {
		int j = array.length - 1;
		for (int i = 0; i < j; i++, j--) {
			char temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}

	public static void main(String[] args) {
		char[] s = new char[]{'a', 'b', 'c', 'd'};
		System.out.println(rotate(s, 3));
	}
}
