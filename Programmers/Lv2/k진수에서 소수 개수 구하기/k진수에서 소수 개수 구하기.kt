fun solution(n: Int, k: Int): Int {
    var answer: Int = 0
    val str = n.toString(k).split("0")
    str.forEach {
        if (it.toLongOrNull() != null && isPrimeNumber(it.toLong())) {
            answer++
        }
    }
    return answer
}


fun isPrimeNumber(n: Long): Boolean {
    if (n < 2) return false
    for (i in 2L..sqrt(n.toDouble()).toLong()) {
        if (n % i == 0L) return false
    }
    return true
}