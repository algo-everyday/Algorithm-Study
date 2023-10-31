T = int(input())

for _ in range(T):
    N = int(input())
    dic = {} # 의상 종류 별 개수 count하는 dictionary

    for _ in range(N):
        a, b = input().split()

        if b in dic: # 이미 나왔던 종류면 개수 +1을 한다.
            dic[b] += 1
        else: # 처음 나온 의상 종류면 1을 넣는다.
            dic[b] = 1

    result = 1
    for d in dic.values():
        result *= (d+1) # 해당 옷을 안 입는 경우까지 계산하기 위해 1을 더해서 곱한다.
    print(result-1) # 알몸인 경우를 제외해야 하므로 결과에서 1을 빼준다.