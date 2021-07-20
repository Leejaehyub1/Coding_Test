from collections import deque

test_num = int(input())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for _ in range(test_num):
    N, M, K = map(int, input().split())
    matrix = [[0]*M for i in range(N)]
    for _ in range(K):
        i, j = map(int, input().split())
        matrix[i][j] = 1


    cnt = 0
    visited = [[0]*M for i in range(N)]
    for i in range(N):
        queue = deque()
        for k in range(M):
            if (matrix[i][k] == 1 and visited[i][k] == 0):
                cnt += 1
                queue.append((i,k))
                visited[i][k] = cnt
                while queue:
                    x,y = queue.popleft()
                    for m in range(4):
                        nx, ny = x + dx[m], y + dy[m]
                        if (0 <= nx < N and 0 <= ny < M):
                            if(matrix[nx][ny] == 1 and visited[nx][ny] == 0):
                                queue.append((nx,ny))
                                visited[nx][ny] = cnt
                                matrix[nx][ny] = cnt

    print(cnt)



