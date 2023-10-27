class Solution {
    var left = intArrayOf(1, 4, 7, 10)
    var right = intArrayOf(3, 6, 9, 12)
    var currentPosition = intArrayOf(10, 12)

    val stringBuilder = StringBuilder()

    fun solution(numbers: IntArray, hand: String): String {
        numbers.forEach {
            when (it) {
                in left -> checkLeft(it)
                in right -> checkRight(it)
                else -> checkHand(hand, it)
            }
        }

        return stringBuilder.toString()
    }

    fun checkLeft(n: Int) {
        currentPosition[0] = n
        stringBuilder.append("L")
    }

    fun checkRight(n: Int) {
        currentPosition[1] = n
        stringBuilder.append("R")
    }

    fun checkHand(hand: String, num: Int) {
        val n = if (num == 0) 11 else num
        val leftDistance = abs(((currentPosition[0] - n) / 3) + ((currentPosition[0] - n) % 3))
        val rightDistance = abs(((currentPosition[1] - n) / 3) + ((currentPosition[1] - n) % 3))

        if (leftDistance > rightDistance) {
            checkRight(n)
        } else if (leftDistance < rightDistance) {
            checkLeft(n)
        } else {
            if (hand == "left") checkLeft(n) else checkRight(n)
        }
    }
}