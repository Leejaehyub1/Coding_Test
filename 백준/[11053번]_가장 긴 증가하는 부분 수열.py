import sys

N = int(input())
A = list(map(int, sys.stdin.readline().split()))

result = [1] * N
for i in range(1, N):
    for k in range(i):
        if A[k] < A[i]:
            result[i] = max(result[i], result[k] + 1)

print(max(result))