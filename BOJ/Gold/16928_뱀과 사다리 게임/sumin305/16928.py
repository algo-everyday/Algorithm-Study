import sys
from collections import deque
input = sys.stdin.readline
global result

N, M = map(int,input().split())

obstacle = [0 for i in range(101)] # 뱀과 사다리 정보 저장

for _ in range(N+M):
    u, v = map(int,input().split())
    obstacle[u] = v

result = 1e9

def BFS(n):
    global result
    q = deque([(n, 0)])
    visited = [0 for i in range(101)]
    visited[n] = 1 # 첫 노드인 1 큐에 넣는다.

    # 큐가 비어있을 때까지
    while q:
        target = q.popleft()
        if target[0] == 100: # 100번 칸에 도착했을 때
            result = min(result, target[1]) # 주사위 최소 횟수 갱신 
            continue
        for i in range(1, 7):
            next = target[0] + i # 주사위를 이용하여 나올 수 있는 수들 (현재 번호 + 1~6)
            if 1 <= next <= 100 and not visited[next]: 
                visited[next] = 1
                if obstacle[next] != 0: # 해당 칸에 장애물이 있을 경우
                    q.append((obstacle[next], target[1]+1))
                    visited[obstacle[next]] = 1
                else: # 해당 칸에 장애물이 없을 경우               
                    q.append((next, target[1] + 1))
BFS(1)
print(result)