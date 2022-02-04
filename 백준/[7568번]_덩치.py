N = int(input())
arr = []
for _ in range(N):
    arr.append(list(map(int, input().split())))

ans = []
for i in range(N):
    count = 1
    for k in range(N):
        if arr[i][0] < arr[k][0] and arr[i][1] < arr[k][1]:
            count += 1
    ans.append(count)
print(*ans)


