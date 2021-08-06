import sys

input=sys.stdin.readline

num = int(input())
stack = []

for _ in range(num):
    a = int(input())

    if(a == 0):
        stack.pop()

    else:
        stack.append(a)

print(sum(stack))
