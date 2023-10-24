from itertools import combinations

def dfs(depth, idx):
    if depth == 6:
        print(*arr)
        return

    for i in range(idx, k):
        arr.append(N[i])
        dfs(depth + 1, i + 1)
        arr.pop()


while True:
    N = list(map(int, input().split()))
    if len(N) == 1 and N == [0]: break
    k = N.pop(0)
    arr = []
    dfs(0, 0)
    print()