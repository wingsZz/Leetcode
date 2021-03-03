import java.util.*
import kotlin.collections.LinkedHashMap

/*
 * @lc app=leetcode id=11 lang=kotlin
 *
 * [11] Container With Most Water
 */
class Solution_13 {

    companion object {
        fun romanToInteger(roman: String): Int {
            var result = 0
            val operations = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
            val numMap = mapOf(Pair("M", 1000), Pair("CM", 900), Pair("D", 500), Pair("CD", 400), Pair("C", 100),
                    Pair("XC", 90), Pair("L", 50), Pair("XL", 40), Pair("X", 10), Pair("IX", 9), Pair("V", 5), Pair("IV", 4), Pair("I", 1))
            val stack = Stack<Char>()
            val array = roman.toCharArray().reversed()
            for (char in array) {
                stack.push(char)

                if (stack.size < 2) {
                    continue
                }

                val stackTop = stack.peek().toString()
                val stackTopNext = stack.get(stack.size - 2).toString()

                val operation = stackTop + stackTopNext
                if ((operation in operations) && numMap.containsKey(operation)) {
                    result += numMap[operation]!!
                    stack.pop()
                    stack.pop()

                    while (!stack.empty()) {
                        result += numMap[stack.pop().toString()]!!
                    }
                }
            }

            while (!stack.empty()) {
                result += numMap[stack.pop().toString()]!!
            }

            return result
        }


        @JvmStatic
        fun main(args: Array<String>) {
            println(romanToInteger("MCMXCIV"))
        }
    }

}