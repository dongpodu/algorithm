package me.will.algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    /**
     * 判断是否为回文，只判断字母和数字
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int j=s.length()-1;
        for(int i=0;i<j;){
            char a=s.charAt(i);
            if(!Character.isLetter(a) && !Character.isDigit(a)){
                i++;
                continue;
            }

            char b=s.charAt(j);
            if(!Character.isLetter(b) && !Character.isDigit(b)){
                j--;
                continue;
            }

            if(Character.toLowerCase(a)!=Character.toLowerCase(b)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static boolean isPalindrome1(String s) {
        int j=s.length()-1;
        for(int i=0;i<j;){
            char a=s.charAt(i);
            char b=s.charAt(j);
            if(a!=b){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    //递归
    public static void split(String s, int start, List<String> list,  List<List<String>> res){
        if(start == s.length()){
            res.add(list);
            return;
        }
        for(int i = start; i < s.length(); i++){
            ArrayList<String> temp = new ArrayList<>(list);
            if(isPalindrome1(s.substring(start, i + 1))){
                temp.add(s.substring(start, i + 1));
                split(s, i + 1, temp, res);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        if(s==null || s.length()==0){
            return null;
        }

        List<List<String>> res = new ArrayList();

        for(int i = 0; i < s.length(); i++){
            String sub = s.substring(0, i + 1);
            if(isPalindrome1(sub)){
                List<String> temp = new ArrayList<>();
                temp.add(sub);
                split(s, i + 1, temp, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
