import sys
input = sys.stdin.readline
n = int(input())
numbers = list(map(int, input().split()))
m = int(input())

dp = [[0]*n for _ in range(n)]

for num_len in range(n):
    for start in range(n-num_len):
        end = start + num_len

        if start == end: #길이가 1이다.
            dp[start][end] = 1
        elif numbers[start] == numbers[end]: #처음과 끝이 똑같다.
            if (start+1 == end) or dp[start+1][end-1] == 1: #길이가 2이거나, 앞뒤 짤라낸 결과가 팰린드롬인 경우.,
                dp[start][end] = 1

for _ in range(m):
    s, e = map(int, input().split())
    print(dp[s-1][e-1])
