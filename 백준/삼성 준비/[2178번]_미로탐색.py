from collections import deque

dx = [0, 0, 1, -1]
dy = [-1, 1, 0, 0]

def bfs(matrix, N, M):
    queue = deque()
    queue.append((0,0))
    visited[0][0] = 1
    while queue:
        x,y = queue.popleft()
        if x == N-1 and y == M-1:
            visited[nx][ny] = visited[x][y] + 1
            break
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if matrix[nx][ny] == 1 and visited[nx][ny] == 0:
                    queue.append((nx,ny))
                    visited[nx][ny] = visited[x][y] + 1

    for v in visited:
        print(v)
    print()

N, M = map(int, input().split())
matrix = [[0]*M for _ in range(N)]
visited = [[0]*M for _ in range(N)]
for i in range(N):
    temp = input()
    for k in range(M):
        matrix[i][k] = int(temp[k])

bfs(matrix, N, M)




