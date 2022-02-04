import sys
N, T = map(int, sys.stdin.readline().split())
arr = []

max = -1
min = 100001
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
    arr.append(temp)

start = min

max_start = min
max_end = min + T
max_count = 0
while(start <= max):
    end = start + T
    count = 0
    for i in range(len(arr)):
        for k in range(len(arr[i])):
            if end<= arr[i][k][0] or arr[i][k][1] <= start:
                break

            elif start <= arr[i][k][0]:
                if arr[i][k][0] <= end <= arr[i][k][1]:
                    count += end - arr[i][k][0]
                elif arr[i][k][1] <= end:
                    count += arr[i][k][1] - arr[i][k][0]

            elif arr[i][k][0] <= start <= arr[i][k][1]:
                if arr[i][k][0] <= end <= arr[i][k][1]:
                    count += end - start
                elif arr[i][k][1] <= end:
                    count += arr[i][k][1] - start



    if max_count < count:
        max_start = start
        max_end = end
        max_count = count

    start += 1


print(max_start, max_end)

