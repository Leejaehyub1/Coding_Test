from collections import deque


def bfs(matrix, changed, N, M):
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    day = 1
    while changed:
        day += 1
        for _ in range(len(changed)):
            x,y = changed.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < N and 0 <= ny < M:
                    if matrix[nx][ny] == 0:
                        changed.append((nx, ny))
                        matrix[nx][ny] = day
    for m in matrix:
        if 0 in m:
            print("-1")
            return
    print(day)




M,N = map(int, input().split())
matrix = [(list(map(int, input().split()))) for _ in range(N)]
visited = [[False]*M for _ in range(N)]
changed = deque()
for i in range(N):
    for k in range(M):
        if matrix[i][k] == 1:
            changed.append((i,k))

bfs(matrix, changed, N, M)
for m in matrix:
    print(m)

