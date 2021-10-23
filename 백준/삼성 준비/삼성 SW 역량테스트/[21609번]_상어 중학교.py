from collections import deque
N, M = map(int, input().split())

dr = [0, 0, -1, 1]
dc = [-1, 1, 0, 0]

matrix = [list(map(int, input().split())) for _ in range(N)]

def calculate(matrix):
    N = len(matrix)
    visited = [[False]*N for _ in range(N)]

    # [기준 블록, 블록 수, 무지개 수, 연결된 점들의 배열]
    max_group_list = []
    max_rainbow = 0
    for i in range(N):
        for k in range(N):
            if (0 < matrix[i][k]) and (not visited[i][k]):
                group_list = [(i,k)]
                group_rainbow= []

                visited[i][k] = True

                queue = deque()
                queue.append((i,k))

                color = matrix[i][k]
                while queue:
                    r, c = queue.popleft()
                    for w in range(4):
                        nr = r + dr[w]
                        nc = c + dc[w]
                        if 0 <= nr < N and 0 <= nc < N:
                            if (not visited[nr][nc]):
                                if matrix[nr][nc] == 0:
                                    if (nr,nc) not in group_rainbow:
                                        group_list.append((nr, nc))
                                        group_rainbow.append((nr,nc))
                                        queue.append((nr, nc))
                                    # print(nr,nc, 'a')

                                elif matrix[nr][nc] == color:
                                    group_list.append((nr, nc))
                                    visited[nr][nc] = True
                                    queue.append((nr, nc))
                                    # print(nr, nc, 'b')

                if (len(group_list) > len(max_group_list)):
                    max_group_list = group_list
                    max_rainbow = len(group_rainbow)
                elif (len(group_list) == len(max_group_list)):
                    if (max_rainbow <= len(group_rainbow)):
                        max_group_list = group_list
                        max_rainbow = len(group_rainbow)
    return max_group_list

def delete(matrix, max_group_list, point):
    point += len(max_group_list) **2
    while max_group_list:
        r,c = max_group_list.pop()
        matrix[r][c] = -2

    return point

def rotate(matrix):
    N = len(matrix)
    ans = [[0]*N for _ in range(N)]
    for i in range(N):
        for k in range(N):
            ans[N-k-1][i] = matrix[i][k]

    return ans

def gravity(matrix):
    N = len(matrix)
    for c in range(N):
        fixed = [False] * N
        fixed[-1] = True
        for r in range(N-1, -1, -1):
            if 0 <= matrix[r][c]:
                temp = r
                while True:
                    if 0 <= temp+1 < N and matrix[temp+1][c] == -2:
                        matrix[temp+1][c] = matrix[temp][c]
                        matrix[temp][c] = -2
                        temp += 1
                    else:
                        break
    return

def print_mat(matrix):
    for m in matrix:
        print(m)



point = 0

while True:
    max_list = calculate(matrix)
    if len(max_list) <= 1:
        break
    else:
        point = delete(matrix, max_list, point)
        gravity(matrix)
        matrix = rotate(matrix)
        gravity(matrix)
print(point)
# print_mat(matrix)

# while True:
#     calculate(matrix)
#     delete(matrix)
#     gravity(matrix)
#     rotate(matrix)
#     gravity(matrix)

