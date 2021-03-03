package com.practice.leetcode.recursive;

/**
 * @author : yueqi.zhou
 * @date : 2020-01-16 16:26
 * describe : 使用了O(N)的额外空间
 */
class ReverseString {
    private static char[] result;
    public static void main(String[] args) {
        char[] input = new char[]{'h','e','l','l','o'};
        result = new char[input.length];
        reverseString(input);
        for (char c : result) {
           System.out.println(c);
        }
    }

    public static void reverseString(char[] s){
        reverseSubString(0,s);
    }

    public static void reverseSubString(int index,char[] s){
        if (s == null || index >= s.length){
            return;
        }
        reverseSubString(index+1 ,s);
        result[result.length - index - 1] = s[index];
    }
}
