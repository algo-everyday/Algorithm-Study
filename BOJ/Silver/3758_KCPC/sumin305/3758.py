import sys
from functools import reduce
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    # n: 팀의 개수, k: 문제의 개수, t: 팀 id, m: 로그 엔트리 개수
    n, k, t, m = map(int, input().split())

    score_array = [[0] * k for i in range(n)] # 문제 별 점수 기록하는 배열
    result_array = [[0, 0, 0, 0] for i in range(n)] # [마지막 제출 시간, 제출 횟수, 점수 총합, id]

    for x in range(m):
        # i: id, j: 문제번호, k: 획득한 점수
        i, j, s = map(int, input().split())
        score_array[i-1][j-1] = max(score_array[i-1][j-1], s)
        result_array[i-1] = [x, result_array[i-1][1] + 1, 0, i]

    # 점수들의 총합 계산
    for i in range(n):
        result_array[i][2] = reduce(lambda x, y: x+y, score_array[i])     

    # 우선순위에 맞게 배열 정렬 (총합 내림차순 -> 제출 횟수 오름차순 -> 마지막 제출시간 오름차순)
    result_array.sort(key = lambda x: (-x[2], x[1], x[0]))

    # 해당 id가 되면 순위 출력
    for i in range(n):
        if result_array[i][3] == t:
            print(i+1)