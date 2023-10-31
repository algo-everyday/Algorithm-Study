## 문제 출처

<a href="https://www.acmicpc.net/problem/9375" rel="nofollow">9375 패션왕 신해빈</a>

## 🔍 풀이

자료구조 map을 사용하는 문제이다.

map을 사용하여 의상의 종류를 key로 받고, 각 종류에 해당되는 의상의 개수를 value로 받았다.

그리고 auto를 사용한 for문을 사용하여 map을 순회하며 ans 값을 구했다.

예를 들어, headgear가 2개, eyewear가 1개라면 가능한 경우의 수는 (2 + 1) * (1 + 1) - 1 = 5이다.

1을 빼주는 이유는 headgear, eyewear 둘 다 착용하지 않는 경우를 제외하기 위함이다.

## ✏️ 추가 지식

for문에서 auto를 사용하는 법을 학습했다.

for (auto elem : m)처럼 작성하면 원본 map의 값을 바꿀 수 없다.

for (auto& elem : m)처럼 작성하면 원본 map의 값을 바꿀 수 있다.

auto& 대신 auto를 사용하면 값을 복사하면서 새로운 변수를 생성하는 것과 같다.

즉, 단순히 읽기만 하는 경우에는 불필요하게 값을 복사할 필요가 없기 때문에 auto&를 쓰는 것이 효율적이다.

## 😊 후기

map을 사용하는 문제는 내용 그대로 구현만 잘 하면 쉬운 것 같다.

찾아보니까 unordered_map도 있던데, 다음에 map과 unordered_map의 차이점을 자세히 알아봐야겠다.