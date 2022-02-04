T = int(input())
DP = [[0, 0, 0]]

for _ in range(T):
    DP.append(list(map(int, input().split(" "))))

for i in range(2,T+1):
    DP[i][0] += min(DP[i - 1][1], DP[i - 1][2])
    DP[i][1] += min(DP[i - 1][0], DP[i - 1][2])
    DP[i][2] += min(DP[i - 1][0], DP[i - 1][1])


print(min(DP[T]))


