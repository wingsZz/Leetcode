class Solution_14 {
        fun longestCommonPrefix(input: Array<String>): String {
            if (input.size == 0) {
                return ""
            }
            if (input.size == 1) {
                return input[0]
            }

            val common = input[0].toCharArray()
            var commonSize = common.size
            for (str in input) {
                if(str.length == 0){
                    return ""
                }
                var chars = str.toCharArray()
                var i = 0
                while (i < commonSize && i < chars.size) {
                    if (chars[i] == common[i]) {
                        i++
                    } else {
                        break
                    }
                }
                commonSize = i
            }

            return common.slice(0..commonSize - 1).joinToString("")
        }
}
