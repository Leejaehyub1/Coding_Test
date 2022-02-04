import sys

N = int(input())
data = sorted(map(int, sys.stdin.readline().split(" ")))
M = int(input())
find_list = list(map(int, sys.stdin.readline().split(" ")))

for num in find_list:
    left = 0
    right = len(data)-1
    now = (left+right)//2
    if(num < data[0] or data[right] < num):
        print("0")
        continue

    flag = False
    while(left <= right):
        if(data[now] == num):
            flag = True
            break

        elif(data[now] < num):
            left = now + 1

        elif(num < data[now]):
            right = now - 1
        now = (left + right) // 2

    print("1") if flag else print("0")

