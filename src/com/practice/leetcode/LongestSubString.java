package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : yueqi.zhou
 * @date : 2020-04-27 10:13
 * describe :
 */
class LongestSubString {
    public static void main(String[] args) {
        int max = lengthOfLongestSubstring("dvdf");
        System.out.println("max length = " + max);
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(10);
        int length = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                if (maxLength <= length) {
                    maxLength = length;
                }
                length = 1;
                map.put(chars[i], i);
                continue;
            }
            map.put(chars[i], i);
            length++;
        }
        if (length >= maxLength) {
            maxLength = length;
        }

        return maxLength;
    }
}
