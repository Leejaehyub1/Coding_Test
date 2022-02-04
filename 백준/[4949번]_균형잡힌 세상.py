import sys

input = sys.stdin.readline

while(True):
    arr = input().rstrip()
    if (arr == '.'):
        break

    stack = []
    ans = True
    for k in arr:
        if( k == '(' or k == '['):
            stack.append(k)

        elif (k == ')'):
            if(len(stack)!= 0 and stack[-1] == '('):
                stack.pop()

            else:
                ans = False
                break

        elif (k == ']'):
            if (len(stack) != 0 and stack[-1] == '['):
                stack.pop()

            else:
                ans = False
                break

    print("yes") if (ans and len(stack)==0) else print("no")
