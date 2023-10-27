## 문제 출처

<a href="https://school.programmers.co.kr/learn/courses/30/lessons/67256" rel="nofollow">키패드 누르기</a>

## 🔍 풀이
- 2차원 배열의 각 원소를 Position으로 접근했는데, 공수가 너무 많이 들었음.
- 굳이 사용 안해도 될 것 같다는 판단이 들어 왼손, 오른속 번호를 제외한 번호들만 분기.
- 키패드간 거리를 계산하는 식을 참고하여 구현


## ✏️ 추가 지식
`abs(((currentPosition[0] - n) / 3) + ((currentPosition[0] - n) % 3))`

- 키패드간 거리를 구하는 공식 n = 2, 5, 8, 0
- currentPosition은 왼손, 오른손이 위치해 있는 상태


## 😊 후기
- 구현문제 머리론 이해가 됐는데, 공식 세우는게 아직 미숙함.
- 키패드간 거리 구하는 공식을 적용 안하고 풀 수 있을 것 같음. -> 다시 도전