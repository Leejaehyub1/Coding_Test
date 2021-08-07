N = int(input())

dp = [1, 2]
for _ in range(2, N+1):
    dp[0], dp[1] = dp[1], (dp[0]+dp[1])%15746

print(dp[0])



