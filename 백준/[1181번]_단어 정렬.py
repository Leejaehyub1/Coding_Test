import sys
N = int(input())
A = [sys.stdin.readline().strip() for _ in range(N)]

A = list(set(A))
A.sort()
A = sorted(A, key=lambda x: len(x))
for a in A:
    print(a)