package me.will.algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class Replace {

    /**
     * 将字符数组里的#替换成%20，要求时间复杂度为o(n)，内存复杂度为o(n)
     * 算法：先统计数组里包含的#数，计算出替换后的数组的大小，然后从后往前替换。
     *
     * @param list
     */
    public static void replace(List<Character> list) {
        System.out.println(list);
        //计算总的#数
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (isSpecial(list.get(i))) {
                count++;
            }
        }
        //扩大列表，后面补*，为了是模拟数组
        int oldSize = list.size();
        int newSize = oldSize + count * 2;
        for (int i = list.size(); i < newSize; i++) {
            list.add('*');
        }
        System.out.println(list);
        for (int i = oldSize - 1, j = oldSize - 1, x = count; i > 0; i--) {
            Character c = list.get(i);
            if (isSpecial(c)) {
                int index = 0;
                for (; j > i; j--) {
                    index = j + x * 2;
                    list.set(index, list.get(j));
                    System.out.println(list);
                }
                list.set(index - 3, '%');
                list.set(index - 2, '2');
                list.set(index - 1, '0');
                System.out.println(list);
                x -= 1;
            }
        }
        System.out.println(list);

    }


    public static boolean isSpecial(Character c) {
        return c == '#';
    }

    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('#');
        list.add('c');
        list.add('#');
        list.add('d');
        replace(list);
    }
}
