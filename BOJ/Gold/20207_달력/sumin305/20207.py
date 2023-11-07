N = int(input())
calendar = [0 for i in range(365)]

for _ in range(N):

    S, E = map(int, input().split())

    for i in range(S-1, E):
        calendar[i] += 1

area = 0
max_height = 0
j = 0

for i in range(365):

    if calendar[i] == 0:
        area += (j * max_height)
        max_height, j = 0, 0
        continue

    max_height = max(max_height, calendar[i]) 
    j += 1

area += (j * max_height)

print(calendar)
print(area)