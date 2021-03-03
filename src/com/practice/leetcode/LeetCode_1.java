package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;


public class LeetCode_1{
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] result = twoSum(nums, 9);
        for(int num : result){
            System.out.println(num);
        }
    }

    //暴力解法  耗时O(n^2)
    public static int[] twoSum(int[] sums,int target){
        int[] result = new int[2];
        if(sums.length == 0){
            return result;
        }
        for(int i=0;i<sums.length;i++){
            int num1 = sums[i];
            for(int j=i+1;j<sums.length;j++){
                if(num1 + sums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    //使用hash
    public static int[] twoSumHash(int nums[],int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }

        throw new IllegalArgumentException("No two sum soulution");
    }
}