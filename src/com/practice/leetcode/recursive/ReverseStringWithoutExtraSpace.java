package com.practice.leetcode.recursive;

/**
 * @author : yueqi.zhou
 * @date : 2020-01-16 16:26
 * describe : 使用了O(1)的额外空间
 */
class ReverseStringWithoutExtraSpace {
    public static void main(String[] args) {
        char[] input = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(input);
        for (char i : input) {
            System.out.print(i);
        }
    }

    public static void reverseString(char[] s) {
        if (s == null || s.length == 0){
            return;
        }
        reverseSubString(0, s.length - 1, s);
    }

    public static void reverseSubString(int start, int end, char[] s) {
        if (start >= end){
            return;
        }
        // 交换首尾元素
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        reverseSubString(start + 1,end - 1,s);
    }
}
