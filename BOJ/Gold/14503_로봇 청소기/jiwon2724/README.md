## 문제 출처

<a href="https://www.acmicpc.net/problem/14503" rel="nofollow">14503 로봇 청소기</a>

## 🔍 풀이
- 단순 구현, 시뮬 문제.


## ✏️ 추가 지식
- 동, 서, 남, 북의 좌표계를 dX, dY로 2차원 배열의 인덱스를 조작하여 주변 4칸을 탐색.
```kotlin
    val dx = arrayOf(-1, 0, 1, 0)
    val dy = arrayOf(0, 1, 0, -1)

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
    
```


## 😊 후기

