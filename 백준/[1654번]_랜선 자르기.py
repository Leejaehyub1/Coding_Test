import sys

data = []
N, K = map(int, input().split())
for _ in range(N):
    data.append(int(input()))

min = 1
max = max(data)

while(min <= max):
    sum = 0
    mid = (min + max) // 2

    for d in data:
        sum += (d//mid)

    if K <= sum:
        min = mid + 1

    else:
        max = mid -1

print(max)

