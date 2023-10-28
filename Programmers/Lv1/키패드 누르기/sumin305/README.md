## 문제 출처

<a href="https://school.programmers.co.kr/learn/courses/30/lessons/67256" rel="nofollow">키패드 누르기</a>

## 🔍 풀이
- left_hand, right_hand 변수로 해당 손가락의 좌표를 계속 저장하였다.
- keypad 배열에 해당 숫자들을 넣고, left_num, right_num 배열을 또 만들어줬다.
- numbers 배열을 돌며, 해당 숫자가 left나 right_num 배열에 있는 수일 경우, R-L 바로 결정을 해주고, 아닐 경우, 해당 숫자와 왼손 오른속 좌표와의 거리를 비교 후 R-L을 결정한다.
- 거리가 같을 경우 hand 변수로 결정하였다. 

## ✏️ 추가 지식



## 😊 후기
- 구현문제였다.
- 공간복잡도를 효율적으로 다루는 방법을 알아봐야겠다.