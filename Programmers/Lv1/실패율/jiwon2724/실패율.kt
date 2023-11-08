
fun main() {
    // 실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
    solution()
}

// 전체 스테이지의 개수 N
// 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages
// 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열 return

fun solution(N: Int = 10, stages: IntArray = intArrayOf(1)): IntArray {
    val answer = arrayListOf<Int>()
    val stage = arrayListOf<Stage>()

    for (i in 1..N) {
        val stageCount = stages.count { i <= it }
        println(stageCount)
        val stageUser = stages.count { i == it }.toFloat()
        if (stageCount == 0) {
            stage.add(Stage(stage = i))
        } else {
            stage.add(Stage(stage = i, failPercent = stageUser/stageCount.toFloat()))
        }
    }
    stage.sortWith(compareBy(
        {it.failPercent}, {it.stage}
    ))

    val desc = stage.sortedByDescending { it.failPercent }
    desc.forEach {
        answer.add(it.stage)
    }
    return answer.toIntArray()
}

data class Stage(
    var failPercent: Float = 0.0f,
    var stage: Int
)