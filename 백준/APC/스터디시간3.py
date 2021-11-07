import sys
N, T = map(int, sys.stdin.readline().split())

maxnum = 100001
min = maxnum+1
max = -1
matrix = [0 for _ in range(maxnum)]

for _ in range(N):
    M = int(sys.stdin.readline())
    for _ in range(M):
        a,b = map(int, sys.stdin.readline().split())
        if max < b:
            max = b
        if a < min:
            min = a
        for i in range(a, b):
            if 0 <= i <= maxnum:
                matrix[i] += 1

matrix2 = [0 for _ in range(max)]
index = -1
maximum = 0
for i in range(max):
    count = 0
    for k in range(T):
        count += matrix[i+k]

    if count > maximum:
        index = i
        maximum = count




print(index, index+T)



