import sys

input = sys.stdin.readline
n, m =  map(int, input().split())
num = [int(input()) for i in range(n)]
dp = [1e9 for i in range(n+1)]


def solve(index):
    if dp[index] != 1e9:
        return dp[index]

    blank = m - num[index]

    for i in range(index+1, n+1):
        if blank >= 0:
            if i == n:
                dp[index] = 0
                break
            dp[index] = min(dp[index], blank * blank + solve(index))
            remain -= (blank[index] + 1)
        return dp[0]
print(solve(0))