import sys
import itertools
import copy

input = sys.stdin.readline

N, M = map(int, input().split())
arr = []
empty = set()
max_safe_area = 0

# 배열 초기화 및 벽 세울 수 있는 후보 셋 구하기
for i in range(N):
    s = list(map(int, input().split()))
    arr.append(s)
    for j in range(M):
        if s[j] == 0:
            empty.add((i, j))

# 바이러스 퍼지기
def virus(arr):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    map = copy.deepcopy(arr)
    visited = [[0 for i in range(M)] for j in range(N)]
    
    def dfs(i, j):
        for k in range(4):
            nx = i + dx[k]
            ny = j + dy[k]
            if 0<=nx<N and 0<=ny<M and not visited[nx][ny] and map[nx][ny] == 0:
                map[nx][ny] = 2
                visited[nx][ny] = 1
                dfs(nx, ny)

    for i in range(N):
        for j in range(M):
            if not visited[i][j] and map[i][j] == 2:
                visited[i][j] = 1
                dfs(i, j)

    # 맵에 있는 모든 0 세기
    count = 0
    for i in range(N):
        for j in range(M):
            if map[i][j] == 0:
                count += 1
    return count


# 벽 세울 수 있는 곳에 벽 세우기
def build_wall(empty):
    global max_safe_area
    wall_candidates = itertools.combinations(empty, 3)
    for candidates in wall_candidates:
        for wall in candidates:
            arr[wall[0]][wall[1]] = 1
        max_safe_area = max(max_safe_area,virus(arr))
        for wall in candidates:
            arr[wall[0]][wall[1]] = 0 # 벽 세우고 안전 범위 계산 후 원상복귀

build_wall(empty)
print(max_safe_area)

