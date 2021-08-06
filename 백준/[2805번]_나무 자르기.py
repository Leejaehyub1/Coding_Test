import sys

N, M = map(int, input().split())
height = list(map(int, (sys.stdin.readline().split())))

min = 1
max = max(height)
mid = (min + max)//2

while(min <= max):
    sum = 0
    mid = (min + max) // 2
    for h in height:
        if(mid < h):
            sum += (h - mid)

    # if(M == sum):
    #     break

    if(M <= sum):  #나무를 너무 많이 자름
        min = mid + 1

    else:   #나무를 너무 적게 자름
        max = mid - 1


print(max)