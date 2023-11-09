fun solution(s: String): IntArray {
    val tupleString = s.replace("{", "").replace("}", "").split(",").map { it.toInt() }

    val map = mutableMapOf<Int, Int>()
    tupleString.distinct().forEach {
        map[it] = 0
    }

    tupleString.forEach {
        map[it] = map[it]!!.plus(1)
    }

    return map.entries.sortedByDescending { it.value }.map { it.key }.toIntArray()
}