DP = []
n = int(input())
for _ in range(n):
    DP.append(list(map(int, input().split(" "))))

for i in range(n):
    if i == 0:
        continue
    for k in range(i+1):
        if (k == 0):
            DP[i][k] += DP[i - 1][0]

        elif (k == i):
            DP[i][k] += DP[i - 1][k-1]

        else:
            DP[i][k] += max(DP[i-1][k-1], DP[i-1][k])

print(max(DP[n-1]))