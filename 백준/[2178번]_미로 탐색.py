from collections import deque
import sys
r = sys.stdin.readline

N, M = map(int, input().split())
matrix = []
for _ in range(N):
    t = list(map(int, r().split()))
    temp = []
    for i in range(M):
        temp.append(int(a[i]))

    matrix.append(temp)

dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

def BFS(N, M, matrix):
    visited = [[False]*M for _ in range(N)]
    visited[0][0] = True
    queue = deque()
    queue.append((0,0))
    while queue:
        x, y = queue.popleft()
        if x == M and y == N:
            break
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if((0 <= nx < N) and (0 <= ny < M) and (matrix[nx][ny] != 0) and (visited[nx][ny] == False)):
                queue.append((nx,ny))
                visited[nx][ny] = True
                matrix[nx][ny] = matrix[x][y] + 1

BFS(N, M, matrix)
print(matrix[N-1][M-1])
