# from collections import deque
#
# N, M = map(int, input().split())
#
# graph = [list(map(int, input())) for _ in range(N)]
# count_graph = [[0]*M for _ in range(N)]
# visited = [[False]*M for _ in range(N)]
#
# queue = [[0,0]]
# count_graph[0][0] = 1
# visited[0][0] = True
#
# dx = [0, 0, -1, 1]
# dy = [-1, 1, 0, 0]
#
# queue = [[0,0]]
#
# while queue:
#     y, x = queue.pop(0)
#
#     if x == M and y == N:
#         break
#
#     for i in range(4):
#         nX = x + dx[i]
#         nY = y + dy[i]
#
#         if 0 <= nX < M and 0 <= nY < N:
#             if graph[nY][nX] == 1 and not visited[nX][nY]:
#                 visited[nX][nY] = True
#                 queue.append([nY,nX])
#                 count_graph[nY][nX] += count_graph[y][x] + 1












from collections import deque
#
# N, M = map(int, input().split())
# matrix = [list(map(int, input())) for _ in range(N)]
#
# count_graph = [[0]*M for _ in range(N)]
# count_graph[0][0] = 1
#
# visited = [[False]*M for _ in range(N)]
# visited[0][0] = True
#
# queue = [[0,0]]
#
# dx = [0, 0, -1, 1]
# dy = [-1, 1, 0, 0]
#
# flag = False
# while queue:
#     y, x = queue.pop(0)
#
#     if y == N and x == M:
#         flag = True
#         break
#
#     for i in range(4):
#         nY = y + dy[i]
#         nX = x + dx[i]
#
#         if 0 <= nY < N and 0 <= nX < M:
#             if matrix[nY][nX] == 1 and visited[nY][nX] == False:
#                 visited[nY][nX] = True
#                 queue.append([nY, nX])
#                 count_graph[nY][nX] = count_graph[y][x] + 1
#
# print(count_graph[N-1][M-1])


from collections import deque
dx = [0,0,1,-1]
dy = [-1,1,0,0]
def bfs():
    queue = deque()
    queue.append([0, 0])
    visited[0][0] = True
    while queue:
        r,c = queue.popleft()
        if r == N-1 and c == M-1:
            break
        for i in range(4):
            nr, nc = r+dx[i], c+dy[i]
            if 0 <= nr < N and 0 <= nc < M:
                if matrix[nr][nc] == 1 and not visited[nr][nc]:
                    queue.append([nr,nc])
                    visited[nr][nc] = True
                    matrix[nr][nc] = matrix[r][c] + 1


    print(matrix[N-1][M-1])





N,M = map(int, input().split())
matrix = [[0]*M for _ in range(N)]
visited = [[False]*M for _ in range(N)]
for i in range(N):
    temp = input()
    for k in range(M):
        matrix[i][k] = int(temp[k])

bfs()






