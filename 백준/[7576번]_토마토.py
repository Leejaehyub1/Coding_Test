import sys
from collections import deque
r = sys.stdin.readline

M, N = map(int, input().split())
matrix = []
complete = deque()
for i in range(N):
    row = list(map(int, r().split()))
    for k in range(len(row)):
        if(row[k]) == 1:
            complete.append((i,k))
    matrix.append(row)


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def BFS(matrix):
    day = -1
    while complete:
        day += 1
        for _ in range(len(complete)):
            x, y = complete.popleft()
            for i in range(4):
                nx, ny = x + dx[i], y + dy[i]

                if((0 <= nx < N) and (0 <= ny <M) and (matrix[nx][ny] == 0)):
                    matrix[nx][ny] = matrix[x][y] + 1
                    complete.append((nx,ny))


    for m in matrix:
        if 0 in m:
            return -1
    return day

print(BFS(matrix))