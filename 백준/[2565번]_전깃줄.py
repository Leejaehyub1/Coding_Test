import sys

N = int(input())
data = []

for _ in range(N):
    a, b = map(int, input().split())
    data.append([a,b])

data.sort()
increase = [1] * N


for i in range(1, N):
    for k in range(i):
        if(data[k][1] < data[i][1]):
            increase[i] = max(increase[i], increase[k] + 1)

print(N - max(increase))




