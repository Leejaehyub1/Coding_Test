from collections import deque
import sys
sys.stdin = open("sample_input.txt", "r")
pipe_matrix = [ [],
                #위
                [[0, 0, 0, 0, 0, 0, 0, 0],
                 [0, 1, 1, 0, 0, 1, 1, 0],
                 [0, 1, 1, 0, 0, 1, 1, 0],
                 [0, 0, 0, 0, 0, 0, 0, 0],
                 [0, 1, 1, 0, 0, 1, 1, 0],
                 [0, 0, 0, 0, 0, 0, 0, 0],
                 [0, 0, 0, 0, 0, 0, 0, 0],
                 [0, 1, 1, 0, 0, 1, 1, 0]],

                #아래
                [[0, 0, 0, 0, 0, 0, 0, 0],
                 [0, 1, 1, 0, 1, 0, 0, 1],
                 [0, 1, 1, 0, 1, 0, 0, 1],
                 [0, 0, 0, 0, 0, 0, 0, 0],
                 [0, 0, 0, 0, 0, 0, 0, 0],
                 [0, 1, 1, 0, 1, 0, 0, 1],
                 [0, 1, 1, 0, 1, 0, 0, 1],
                 [0, 0, 0, 0, 0, 0, 0, 0]],

                #좌
                [[0, 0, 0, 0, 0, 0, 0, 0],
                 [0, 1, 0, 1, 1, 1, 0, 0],
                 [0, 0, 0, 0, 0, 0, 0, 0],
                 [0, 1, 0, 1, 1, 1, 0, 0],
                 [0, 0, 0, 0, 0, 0, 0, 0],
                 [0, 0, 0, 0, 0, 0, 0, 0],
                 [0, 1, 0, 1, 1, 1, 0, 0],
                 [0, 1, 0, 1, 1, 1, 0, 0]],

                #우
                [[0, 0, 0, 0, 0, 0, 0, 0],
                 [0, 1, 0, 1, 0, 0, 1, 1],
                 [0, 0, 0, 0, 0, 0, 0, 0],
                 [0, 1, 0, 1, 0, 0, 1, 1],
                 [0, 1, 0, 1, 0, 0, 1, 1],
                 [0, 1, 0, 1, 0, 0, 1, 1],
                 [0, 0, 0, 0, 0, 0, 0, 0],
                 [0, 0, 0, 0, 0, 0, 0, 0]]]


dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
def bfs(matrix, visited, N, M, R, C, L):
    changed = deque()
    changed.append((R,C))
    visited[R][C] = True
    for _ in range(L-1):
        length = len(changed)
        for _ in range(length):
            r, c = changed.popleft()
            for i in range(4):
                nr = r + dr[i]
                nc = c + dc[i]
                if 0 <= nr < N and 0 <= nc < M:
                    current_pipe = matrix[r][c]
                    future_pipe = matrix[nr][nc]
                    if pipe_matrix[i+1][current_pipe][future_pipe] == 1:
                        if not visited[nr][nc]:
                            changed.append((nr, nc))
                            visited[nr][nc] = True

    ans = 0
    for v in visited:
        ans += v.count(True)
        # print(v)
    return ans


for test_case in range(1, T + 1):

    # N,M은 행렬 세로, 가로
    # R,C은 맨홀뚜껑 세로, 가로위치
    # L은 탈출 후 소요시간
    N, M, R, C, L = map(int, input().split())

    matrix = []
    visited = [[False]*M for _ in range(N)]

    for _ in range(N):
        matrix.append(list(map(int, input().split())))

    ans = bfs(matrix, visited, N, M, R, C, L)
    print("#{} {}".format(test_case, ans))








