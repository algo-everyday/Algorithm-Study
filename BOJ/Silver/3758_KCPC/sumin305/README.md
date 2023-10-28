## 문제 출처

<a href="https://www.acmicpc.net/problem/3758" rel="nofollow">3758 KCPC</a>

## 🔍 풀이
단순 구현 문제였다.
다차원 배열을 다뤄서 문제를 해결하였다.

## ✏️ 추가 지식
### reduce
```python
from functools import reduce

# [점수들의 총합 나타내는 배열]
result_array = [reduce(lambda x, y: x+y, score_array[i]) for i in range(n)]
```
reduce() : 리스트의 아이템들을 누적해서 계산해준다.
형태는 reduce(lambda x, y: x + y, array) -> 하나의 값 return

### 정렬 기준 커스텀하기
정렬 커스텀 또한 lambda를 사용한다. 
```python
result_array.sort(key = lambda x: (-x[2], x[1], x[0]))
```

## 😊 후기
- lambda의 파워가 대단하다고 느꼈다.
- 다양한 기준으로 배열을 정렬해야 할 경우에는 하나의 배열로 통일하는 것이 좋다.