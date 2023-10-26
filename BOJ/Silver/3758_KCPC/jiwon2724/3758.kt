val answer = arrayListOf<Int>()
var lastTeam = 0
var myTeamId = 0

fun main() {
    val t = readln().toInt()

    repeat(t) {
        val input = readln().split(" ").map { it.toInt() }
        val teamCount = input[0]
        myTeamId = input[2]
        val logEntry = input[3] // 5

        val array = Array(teamCount + 1) { Result() }

        repeat(logEntry) {
            val solveInfo = readln().split(" ").map { it.toInt() }
            val teamId = solveInfo[0]
            val solveNumber = solveInfo[1]
            val score = solveInfo[2]

            lastTeam = teamId

            array[teamId].apply {
                submit++
                this.teamId = teamId
                lastTeam = teamId

                if (this.solveNumber == solveNumber) {
                    this.score = score
                } else {
                    this.solveNumber = solveNumber
                    this.score = this.score + score
                }
            }
        }

        val newList = array.toList() as ArrayList
        newList.removeAt(0)

        val result = newList.sortedWith(Comparator { t1, t2 ->
            when {
                ((t1.score == t2.score) && (t1.submit == t2.submit)) -> if (t1.teamId == lastTeam) 1 else -1
                t1.score == t2.score -> if (t1.submit > t2.submit) 1 else -1
                else -> 1
            }
        })

        result.forEachIndexed { index, result ->
            if (result.teamId == myTeamId) {
                answer.add(index + 1)
                return@forEachIndexed
            }
        }

    }
    answer.forEach { println(it) }
}

data class Result(
    var solveNumber: Int = 0,
    var teamId: Int = 0,
    var score: Int = 0,
    var submit: Int = 0
)