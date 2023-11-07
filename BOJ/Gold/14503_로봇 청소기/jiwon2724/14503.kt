var n: Int = 0
var m: Int = 0

var position = 0

lateinit var array: Array<Array<Int>>

var startX = 0
var startY = 0

fun main() {
    var answer = 0

    val input = readln().split(" ").map { it.toInt() }
    n = input[0] // 세로
    m = input[1] // 가로

    val start = readln().split(" ").map { it.toInt() }

    // 북동남서 순
    val dx = arrayOf(-1, 0, 1, 0)
    val dy = arrayOf(0, 1, 0, -1)

    startX = start[0]
    startY = start[1]
    position = start[2]
    // 0 : 북쪽 (위)
    // 1 : 동쪽 (오른쪽)
    // 2 : 남쪽 (아래)
    // 3 : 서쪽 (왼쪽)

    array = Array(n) { Array(m) { 0 } }

    for (i in 0 until n) {
        val road = readln().split(" ").map { it.toInt() }
        road.forEachIndexed { j, value ->
            array[i][j] = value
        }
    }

    loop@ while (true) {
        if (array[startX][startY] == 0) { // 1. 현재칸 청소
            array[startX][startY] = -1 // 청소
            answer++
        } else if(array[startX][startY] == 1) { // 2.2 바라보는 방향의 뒤쪽 칸이 벽인경우
            break@loop
        }

        for (i in 0 until 4) { // 2. 주변 4칸 탐색
            if (--position == -1) position = 3 // 동서남북 4방향

            // 3.1 반시계 반향 회전
            val x = startX + dx[position]
            val y = startY + dy[position]

            if (array[x][y] == 0) { // 3.2 동서남북 인덱스로 청소 안한 곳 탐색 후 이동
                startX = x
                startY = y
                continue@loop // 3.1
            }
        }

        // 2.1 청소되지 않은 빈 칸이 없는 경우 바라보는 단계에서 후진 포지션 매핑
        startX -= dx[position]
        startY -= dy[position]
    }
    print(answer)
}
