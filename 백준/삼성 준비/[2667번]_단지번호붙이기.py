# from collections import deque
#
# N = int(input())
#
# matrix = [[0]*(N) for _ in range(N)]
# visited = [[0]*(N) for _ in range(N)]
# for i in range(N):
#     temp = input()
#     for k in range(N):
#         matrix[i][k] = int(temp[k])
#
# dx = [-1, 1, 0, 0]
# dy = [0, 0, -1, 1]
#
# def bfs(x, y, cnt):
#     queue = deque()
#     queue.append((x,y))
#     while queue:
#         x, y = queue.popleft()
#         for k in range(4):
#             nx, ny = x + dx[k], y + dy[k]
#             if (0 <= nx < N and 0 <= ny < N):
#                 if (matrix[nx][ny] == 1 and visited[nx][ny] == 0):
#                     queue.append((nx, ny))
#                     visited[nx][ny] = cnt
#
#
# cnt = 0
# for i in range(N):
#     for k in range(N):
#         if (matrix[i][k] == 1 and visited[i][k] == 0):
#             cnt += 1
#             bfs(i,k,cnt)
# ans = []
# for c in range(1,cnt+1):
#     num = 0
#     for i in range(N):
#         for k in range(N):
#             if(visited[i][k] == c):
#                 num += 1
#     ans.append(num)
#
#
# print(cnt)
# ans.sort()
# for a in ans:
#     print(a)

from collections import deque

N = int(input())
matrix = [[0]*(N) for _ in range(N)]
visited = [[0]*(N) for _ in range(N)]
for i in range(N):
    temp = input()
    for k in range(N):
        matrix[i][k] = int(temp[k])

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

cnt = 0
town_count = []

def bfs(i, k, cnt, town_count):
    queue = deque()
    queue.append((i,k))
    num = 0
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<N and 0<=ny<N:
                if matrix[nx][ny] == 1 and visited[nx][ny] == 0:
                    queue.append((nx,ny))
                    visited[nx][ny] = cnt
                    num += 1
    town_count.append(num)


def dfs(x, y, cnt):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < N:
            if matrix[nx][ny] == 1 and visited[nx][ny] == 0:
                visited[nx][ny] = cnt
                dfs(nx, ny, cnt)


for i in range(N):
    for k in range(N):
        if matrix[i][k] == 1 and visited[i][k] == 0:
            cnt += 1
            dfs(i, k, cnt)

for v in visited:
    print(v)


