import sys
import itertools
N = int(input())

arr = []
for _ in range(N):
    arr.append(sys.stdin.readline().rstrip())
t = input()

ans = (list(map(''.join, itertools.permutations(arr, 3))))
print(ans)
print(ans.count(t))
# print(map(''.join, itertools.permutations(arr, 3)))
