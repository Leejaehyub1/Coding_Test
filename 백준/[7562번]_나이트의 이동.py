from collections import deque


dx = [-2, -2, -1, -1, +1, +1, +2, +2]
dy = [-1, +1, -2, +2, -2, +2, -1, +1]
def BFS(x_init, y_init, x_final, y_final):
        matrix = [[0]*N for _ in range(N)]
        visited = [[False] * N for _ in range(N)]
        queue = deque()
        queue.append((x_init,y_init))
        visited[x_init][y_init] = True
        while queue:
            x, y = queue.popleft()
            if (x==x_final and y==y_final):
                return matrix[x][y]

            for i in range(len(dx)):
                nx, ny = x+dx[i], y+dy[i]
                if(0 <= nx < N and 0 <= ny < N):
                    if(visited[nx][ny] == False):
                        queue.append((nx, ny))
                        visited[nx][ny] = True
                        matrix[nx][ny] = matrix[x][y]+1




test_num = int(input())
for _ in range(test_num):
    N = int(input())
    x_init, y_init = map(int, input().split())
    x_final, y_final = map(int, input().split())
    print(BFS(x_init, y_init, x_final, y_final))

