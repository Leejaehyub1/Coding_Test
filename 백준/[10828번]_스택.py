import sys

input=sys.stdin.readline

num = int(input())
stack = []

for _ in range(num):
    a = input().split()
    if(a[0] == 'push'):
        temp = int(a[1])
        stack.append(temp)

    if (a[0] == 'pop'):
        if(len(stack) == 0):
            print("-1")
        else:
            print(stack.pop())

    if (a[0] == 'size'):
        print(len(stack))

    if (a[0] == 'empty'):
        if(len(stack) == 0):
            print("1")
        else:
            print("0")

    if (a[0] == 'top'):
        if(len(stack) == 0):
            print("-1")
        else:
            print(stack[-1])