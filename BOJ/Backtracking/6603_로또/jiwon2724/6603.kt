import java.util.*

val stringBuilder = StringBuilder()

lateinit var isVisited: Array<Boolean>
lateinit var arr: Array<Int>

var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val st = StringTokenizer(readLine())
        n = st.nextToken().toInt()

        if (n == 0) break

        arr = Array(n) { st.nextToken().toInt() }
        isVisited = Array(n) { false }

        dfs(0, 0)
        stringBuilder.append("\n")
    }
    print(stringBuilder)
}

fun dfs(count: Int, index: Int) {
    if (count == 6) {
        for (i in 0 until n) {
            if (isVisited[i])  {
                stringBuilder.apply {
                    append(arr[i])
                    append(" ")
                }
            }
        }
        stringBuilder.append("\n")
    }
    for (i in index until n) {
        isVisited[i] = true
        dfs(count + 1, i + 1)
        isVisited[i] = false
    }
}
