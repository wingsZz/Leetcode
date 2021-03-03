import kotlin.math.max
import kotlin.math.min

/*
 * @lc app=leetcode id=11 lang=kotlin
 *
 * [11] Container With Most Water
 */
class Solution {
    fun maxArea(height: IntArray): Int {
        if(height.size < 2){
            return 0
        }

        var maxArea = 0
        var left = 0
        var right = height.size - 1
        var minHeight = 0
        while(left < right){
            if(min(height[left], height[right]) > minHeight){
                minHeight = min(height[left], height[right])
                val area = (right - left) * minHeight
                maxArea = max(area, maxArea)
            }
            if(height[left] < height[right]){
                left++
            }else{
                right--
            }
        }

        return maxArea
    }
}

