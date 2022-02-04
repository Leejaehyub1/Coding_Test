import sys
T = int(input())
num = []

for _ in range(T):
    num.append(int(input()))

M = max(num)

DP = [0 for _ in range(M+1)]

for i in range(1,M+1):
    if(1 <= i <= 3):
        DP[i] = 1

    else:
        DP[i] = DP[i-3] + DP[i-2]

for i in num:
    print(DP[i])










