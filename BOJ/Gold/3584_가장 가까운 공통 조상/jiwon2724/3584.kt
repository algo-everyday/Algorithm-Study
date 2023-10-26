import kotlin.collections.HashMap

val hashMap: HashMap<Int, ArrayList<Int>> = hashMapOf()

var targetNode1 = 0
var targetNode2 = 0

fun main() {
    val case = readln().toInt()

    repeat(case) {
        val nodeCount = readln().toInt()
        for (i in 0 until nodeCount) {
            if(i == nodeCount - 1) {
                val target =  readln().split(" ").map { it.toInt() }
                targetNode1 = target[0]
                targetNode2 = target[1]
            } else {
                val inputNode = readln().split(" ").map { it.toInt() }
                hashMap.computeIfAbsent(inputNode[0]) { ArrayList() }.add(inputNode[1])
            }
        }
    }
    // {16=[3, 12], 1=[14, 13], 4=[6, 10], 5=[9], 6=[15, 7], 8=[5, 4, 1], 10=[16, 11, 2]}

    println(hashMap)
    println(targetNode1) // 16
    println(targetNode2) // 7
    println(hashMap.size)

    hashMap.keys.forEach {
        // key를 포함하고 있는 entrites에 add
        val keyNode = hashMap.getValue(it) // 3, 12
    }
}