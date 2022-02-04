import sys
N, K = map(int, input().split())
matrix1 = []
matrix2 = []
for _ in range(N):
    matrix1.append(list(map(int, sys.stdin.readline().split())))

K, M = map(int, input().split())
for _ in range(K):
    matrix2.append(list(map(int, sys.stdin.readline().split())))

answer = [[0]*M for _ in range(N)]
for n in range(N):
    for m in range(M):
        for k in range(K):

            answer[n][m] += matrix1[n][k] * matrix2[k][m]

for ans in answer:
    print(*ans)
