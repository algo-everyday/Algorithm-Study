import sys
input = sys.stdin.readline 

T = int(input())

# 해당 원소부터 root까지의 경로 배열 생성
def make_path(num):
    path = [num]
    while tree[num]:
        path.append(tree[num])
        num = tree[num]
    return path

for _ in range(T):
    N = int(input())

    tree = [0 for i in range(N+1)] # a[child] = parent 자신의 부모 노드를 배열 값으로 가진다.

    for r in range(N-1):

        a, b = map(int, input().split())
        tree[b] = a

    target1, target2 = map(int, input().split())
    path1, path2 = make_path(target1), make_path(target2)

    i, j = 0, 0

    # 시작 index 맞춰주기
    if len(path1) > len(path2):
        i += (len(path1) - len(path2))
    else:
        j += (len(path2) - len(path1))
    
    # 배열 값 비교하면서 같은 노드일 경우 종료
    while path1[i] != path2[j]:
        i += 1
        j += 1

    print(path1[i])