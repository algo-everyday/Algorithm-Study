import java.util.HashMap

fun main() {
    val testCase: Int = readln().toInt()
    val resultList = arrayListOf<Int>()

    repeat(testCase) {
        val cloths = readln().toInt()
        val hashMap: HashMap<String, Int> = hashMapOf()

        repeat(cloths) {
            val input = readln().split(" ")
            val key = input[1]
            hashMap[key] = if(hashMap.containsKey(key)) hashMap[key]!!.plus(1) else 1
        }

        var result = 1
        hashMap.values.forEach { result *= (it + 1) }
        resultList.add(result-1)
    }

    resultList.forEach {
        println(it)
    }
}

