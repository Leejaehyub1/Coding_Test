import sys

N = int(input())
arr = []
for _ in range(N):
    x,y = map(int, sys.stdin.readline().split())
    arr.append([y,x])

arr.sort()
for a in arr:
    print(a[1], a[0])
