package me.will.algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class Replace {

    /**
     * 将字符串里的空格替换成%20
     *
     * @param list
     */
    public static void replace(List<Character> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (isEmpty(list.get(i))) {
                count++;
            }
        }
        int size = list.size() + count * 3;
        List<Character> l = new ArrayList<>(size);
        l.addAll(list);
        for (int i = list.size() - 1, j = list.size() - 1, x = count; i > 0; i--) {
            if (isEmpty(list.get(i))) {
                for (; j >= i; j--) {
                    list.set(j + x * 3, list.get(j));
                }
                list.set(i, '%');
                list.set(i + 1, '2');
                list.set(i + 2, '0');
                x -= 1;
            }
        }
        System.out.println(l);

    }

    public static boolean isEmpty(Character c) {
        return c == '\32';
    }

    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add(' ');
        list.add('c');
        list.add(' ');
        list.add('d');
        replace(list);
    }
}
