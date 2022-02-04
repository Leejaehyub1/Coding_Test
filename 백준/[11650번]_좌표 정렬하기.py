import sys

N = int(input())
arr = []
for _ in range(N):
    x,y = map(int, sys.stdin.readline().split())
    arr.append([x,y])

arr.sort()
for a in arr:
    print(a[0], a[1])
