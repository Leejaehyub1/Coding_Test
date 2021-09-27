from collections import deque
from sys import stdin

N = int(stdin.readline())
queue = deque()

for _ in range(N):
    t = list(map(str, stdin.readline().split()))
    if(t[0] == 'push'):
        queue.append(t[1])

    elif (t[0] == 'pop'):
        #len(queue)>0 으로 하면 시간초과, if queue로 하면 통과?
        print(queue.popleft()) if queue else print("-1")

    elif (t[0] == 'size'):
        print(len(queue))

    elif (t[0] == 'empty'):
        if(len(queue) == 0):
            print("1")
        else:
            print("0")

    elif (t[0] == 'front'):
        print(queue[0]) if len(queue) !=0 else print("-1")

    elif (t[0] == 'back'):
        print(queue[-1]) if len(queue) !=0 else print("-1")


