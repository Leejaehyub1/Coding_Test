N = int(input())

DP = [[0] * 10 for _ in range(N+1)]

DP[1] = [0, 1, 1, 1, 1, 1, 1, 1, 1, 1]
for i in range(2, N+1):
    DP[i][0] = DP[i-1][1]
    DP[i][9] = DP[i-1][8]
    for k in range(1, 9):
        DP[i][k] = DP[i-1][k-1] + DP[i-1][k+1]

print(sum(DP[N])%1000000000)