N = int(input())
stair = [0]
for _ in range(N):
    stair.append(int(input()))

def solution(stair, N):
    DP = [0] * (N + 1)
    for i in range(1, N+1):
        if(i == 1):
            DP[i] = stair[i]

        elif(i == 2):
            DP[i] = stair[i-1] + stair[i]

        elif(i == 3):
            DP[i] = max(stair[i-2], stair[i-1]) + stair[i]

        else:
            DP[i] = max(DP[i-2], DP[i-3] + stair[i-1]) + stair[i]

    return DP[N]

print(solution(stair, N))