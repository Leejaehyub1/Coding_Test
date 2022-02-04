N = int(input())
wine = [0]
for _ in range(N):
    wine.append(int(input()))

DP = [0] * (N+1)

wine = [0,6,6,10,13,9,8,1]
DP = [0,6,6,0,0,0,0,0]

for i in range(1, N+1):
    if i == 1:
        DP[1] = wine[1]
    elif i == 2:
        DP[2] = wine[1] + wine[2]
    elif i == 3:
        DP[3] = max(wine[1] + wine[3], wine[2] + wine[3], DP[2])
    else:
        DP[i] = max(DP[i-2] + wine[i], DP[i-3] + wine[i-1] +wine[i] , DP[i-1])

print(DP[N])