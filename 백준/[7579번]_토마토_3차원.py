import sys
from collections import deque
r = sys.stdin.readline

M, N, K = map(int, input().split())

matrix = []
complete = deque()
for k in range(K):
    temp = []
    for n in range(N):
        t = list(map(int, r().split()))
        temp.append(t)
        for m in range(M):
            if(t[m] == 1):
                complete.append((m,n,k))
    matrix.append(temp)

dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]

# x,y,z = complete.popleft()
# print(matrix[z][y][x])
def BFS(matrix):
    day = -1
    while complete:
        day += 1
        for _ in range(len(complete)):
            x, y, z = complete.popleft()
            for i in range(6):
                nx, ny, nz = x + dx[i], y + dy[i], z + dz[i]
                if((0 <= nx < M) and (0 <= ny <N) and (0 <= nz < K)):
                    if (matrix[nz][ny][nx] == 0):
                        matrix[nz][ny][nx] = matrix[z][y][x] + 1
                        complete.append((nx,ny,nz))


    for mat in matrix:
        for m in mat:
            if 0 in m:
                return -1
    return day

print(BFS(matrix))