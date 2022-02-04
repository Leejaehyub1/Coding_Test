import sys
N, T = map(int, sys.stdin.readline().split())
arr = []

max = -1
min = 100001
matrix = [0 for _ in range(1000001)]
for _ in range(N):
    M = int(sys.stdin.readline())
    temp = []
    for _ in range(M):
        a,b = map(int, sys.stdin.readline().split())
        if max < b:
            max = b
        if a < min:
            min = a
        temp.append([a,b])
        for i in range(a,b):
            matrix[i] += 1
    arr.append(temp)

start = min
max_start = min
max_end = min + T
max_count = 0

while(start <= max):
    count = 0
    for i in range(T):
        count += matrix[start + i]

    if max_count < count:
        max_count = count
        max_start = start
        max_end = start + T
    start += 1
    # print(max_start, max_end)

print(max_start, max_end)





