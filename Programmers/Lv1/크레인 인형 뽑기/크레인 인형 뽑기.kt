import java.util.*

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val realMove = moves.map { it - 1 }
        var index = 0

        val stack = Stack<Int>()

        realMove.forEach {
            val move = it

            while (true) {
                if(board[index][move] == 0) {
                    if(index != board.size-1) {
                        index++
                    } else {
                        break
                    }
                } else {
                    if(stack.isEmpty()) {
                        stack.push(board[index][move])
                    } else {
                        val peek = stack.peek()
                        if(peek == board[index][move]) {
                            answer += 2
                            stack.pop()
                        } else {
                            stack.push(board[index][move])
                        }
                    }
                    board[index][move] = 0
                    index = 0
                    break
                }
            }
        }
        return answer
    }
}