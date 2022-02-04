import sys
N = int(input())
A = []
for _ in range(N):
    temp = sys.stdin.readline().split()
    A.append([int(temp[0]), temp[1]])

A = sorted(A, key=lambda x:x[0])

for a in A:
    print("%d %s"%(a[0], a[1]))
