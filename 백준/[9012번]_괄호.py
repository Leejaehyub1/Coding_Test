import sys

input = sys.stdin.readline
num = int(input())

for _ in range(num):
    arr = input().strip()
    stack = 0
    for t in arr:
        if( t == '('):
            stack += 1

        else:
            if(stack == 0):
                stack = 1
                break
            else:
                stack -= 1


    if(stack == 0):
        print("YES")
    else:
        print("NO")