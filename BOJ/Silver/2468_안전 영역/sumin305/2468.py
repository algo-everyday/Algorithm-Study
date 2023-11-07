import sys
import copy
from collections import deque

input = sys.stdin.readline

N = int(input())
arr = []

max_start = 0
max_count = 0

for i in range(N):
    temp = list(map(int, input().split()))
    for j in range(N):
        if temp[j] > max_start:
            max_start = temp[j]
    arr.append(temp)

def BFS(x, y):

    global visited
    global temp_arr

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    queue = deque([(x, y)])
    visited[x][y] = 1

    while queue:

        target = queue.popleft()

        for i in range(4):
            nx = target[0] + dx[i]
            ny = target[1] + dy[i]

            if 0<=nx<N and 0<=ny<N and not visited[nx][ny] and temp_arr[nx][ny]:
                visited[nx][ny] = 1
                queue.append((nx, ny))
                
while max_start >= 0:
    visited = [[0 for i in range(N)] for j in range(N)]
    temp_arr = copy.deepcopy(arr)
    count = 0

    for i in range(N):
        for j in range(N):
            if temp_arr[i][j] <= max_start:
                temp_arr[i][j] = 0

    for i in range(N):
        for j in range(N):
            if not visited[i][j] and temp_arr[i][j]:
                BFS(i, j)
                count += 1
    max_start -= 1

    max_count = max(max_count, count)

print(max_count)