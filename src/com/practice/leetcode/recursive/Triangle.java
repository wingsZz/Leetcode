package com.practice.leetcode.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : yueqi.zhou
 * @date : 2020-01-17 11:00
 * describe :
 */
class Triangle {
    private static int[][] cache;
    public static void main(String[] args) {
        List<List<Integer>> result = generate(35);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) +  " ");
            }
            System.out.print("\n");
        }
    }

    private static List<List<Integer>> generate(int numRows) {
        cache = new int[numRows+1][numRows+1];
        List<List<Integer>> triangle = new ArrayList<>(numRows);
        if (numRows < 1) {
            return triangle;
        }

        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>(numRows);
            for (int j = 1; j <= i; j++) {
                cache[i][j] = generatePositionResult(i, j);
                row.add(cache[i][j]);
            }
            triangle.add(row);
        }

        return triangle;
    }

    private static int generatePositionResult(int row, int col) {
        if (col == 1 || row == col) {
            return 1;
        }
        if (cache[row][col] != 0){
            return cache[row][col];
        }

        return generatePositionResult(row - 1, col - 1) + generatePositionResult(row - 1, col);
    }
}
