## 문제 출처

<a href="https://www.acmicpc.net/problem/3758" rel="nofollow">3758 KCPC</a>

## 🔍 풀이

구현 + 정렬 문제이다.

Team이라는 구조체를 만들어 그 안에 id, score, time, submit 4개의 멤버 변수를 포함하도록 했다.

문제에 제시된 정렬 조건을 구현하기 위한 cmp 함수를 작성하여 sort 함수의 인자로 넘겨주었다.

## ✏️ 추가 지식

추가적으로 얻은 지식은 없다.


## 😊 후기

init 함수 내의 for문의 i 시작 범위를 잘못 지정하여 수십 분 동안 헤맸다.

여러 개의 테스트 케이스를 실행해보도록 주어지는 문제는 전역변수를 매 케이스 시작 때마다 초기화해주어야 하기 때문에 까다로운 것 같다.

다음부터는 초기화 코드를 더 신중히 작성해야겠다.