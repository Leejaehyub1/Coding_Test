from copy import deepcopy

N = int(input())
start = [list(map(int, input().split())) for _ in range(N)]
max = -1

# left right up down
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def move(matrix, num, count):
    ans = deepcopy(matrix)

    if num == 0:    #up
        for k in range(N):
            for i in range(N-1):
                if ans[i][k] == 0:
                    for m in range(i, N-1):
                        ans[m][k] = ans[m+1][k]
                    ans[-1][k] = 0

                if ans[i][k] == ans[i+1][k]:
                    ans[i][k] *= 2
                    for m in range(i+1, N-1):
                        ans[m][k] = ans[m+1][k]
                    ans[-1][k] = 0



    if num == 1:    #down
        for k in range(N):
            for i in range(N-1):
                m = N - i - 1  #m은 N-1, N-2, ..., 1
                if ans[m][k] == 0:
                    for w in range(0, m):
                        ans[m-w][k] = ans[m-w-1][k]
                    ans[0][k] = 0
                print(ans)
                if ans[m][k] == ans[m-1][k]:
                    ans[m][k] *= 2
                    for w in range(1, m-1):
                        ans[w][k] = ans[w-1][k]
                    ans[0][k] = 0


    if num == 2:    #left
        for i in range(N):
            for k in range(N-1):
                if ans[i][k] == ans[i][k+1]:
                    ans[i][k] *= 2
                    for w in range(1, k-1):
                        ans[i][k] = ans[i][k+1]
                    ans[i][-1] = 0


    if num == 3:    #right
        for i in range(N):
            for k in range(N-1):
                m = N - k - 1  #m은 N-1, N-2, ..., 1
                if ans[i][m-1] == ans[i][m]:
                    ans[i][m] *= 2
                    for w in range(1, m-1):
                        ans[i][w] = ans[i][w-1]
                    ans[i][0] = 0
    return [ans, count+1]

temp = start
count = 0
queue = [[start, 0]]

if N > 1:
    while queue:
        temp, cnt = queue.pop(0)
        if cnt < 5:
            for i in range(0,4):
                move(temp, i, cnt)

# print(move(start, 0, 0))
print(move(start, 1, 0))
# print(move(start, 2, 0))
# print(move(start, 3, 0))

