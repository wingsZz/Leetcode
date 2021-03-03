package com.practice.leetcode.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : yueqi.zhou
 * @date : 2020-01-17 13:53
 * describe :
 */
class Triangle_2 {

    public static void main(String[] args) {
        List<Integer> result = generate(5);
        for (Integer integer : result) {
           System.out.println(integer);
        }
    }

    private static List<Integer> generate(int row) {
        List<Integer> result = new ArrayList<>(row + 1);

        for (int i = 0; i < row; i++) {
            if (i == 1 || i == 0) {
                result.add(1);
            } else {
                result.add(1);
                for (int j = i - 1; j > 0; j--) {
                    result.set(j, result.get(j) + result.get(j - 1));
                }
            }
        }

        return result;
    }
}
