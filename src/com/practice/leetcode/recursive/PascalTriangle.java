package com.practice.leetcode.recursive;

/**
 * @author : yueqi.zhou
 * @date : 2020-01-17 09:47
 * describe :
 */
class PascalTriangle {
    public static void main(String[] args) {
       int result = result(6,3);
       System.out.println(result);
    }

    /**
     * @param i 第i行
     * @param j 第j列
     * @return 该位置的结果
     */
    private static int result(int i,int j){
        if (j == 1 || j == i){
            return 1;
        }
        return result(i-1,j-1) + result(i-1,j);
    }
}
