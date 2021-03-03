package com.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_2 {
    private static List<Integer> limits;
    private static int i = 11;
    private static Map<Integer, String> map;
    private static String result = "";

    static {
        map = new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        limits = new ArrayList<>();
        limits.add(1);
        limits.add(4);
        limits.add(9);
        limits.add(10);
        limits.add(40);
        limits.add(50);
        limits.add(90);
        limits.add(100);
        limits.add(400);
        limits.add(500);
        limits.add(900);
        limits.add(1000);
    }

    public static String intToRoman(int num) {
        if (i < 0) {
            return "";
        }
        if (num - limits.get(i) < 0) {
            --i;
            return result + intToRoman(num);
        } else if (num - limits.get(i) > limits.get(i)) {
            return result + intToRoman(num - limits.get(i));
        } else if (num - limits.get(i) <= limits.get(i) && num - limits.get(i) > 0) {
            return result + intToRoman(num - limits.get(i--));
        } else {
            return result + map.get(limits.get(i));
        }
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}