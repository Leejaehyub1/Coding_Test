import sys

N = int(input())
arr = list(map(int, sys.stdin.readline().split()))
arr_reverse = arr[::-1]
increase = [1] * N
decrease = [1] * N
result = [0] * N

for i in range(1, N):
    for k in range(i):
        if(arr[k] < arr[i]):
            increase[i] = max(increase[i], increase[k] + 1)
        if (arr_reverse[i] > arr_reverse[k]):
            decrease[i] = max(decrease[i], decrease[k] + 1)

for i in range(N):
    result[i] = increase[i] + decrease[N-i-1] - 1

print(max(result))




