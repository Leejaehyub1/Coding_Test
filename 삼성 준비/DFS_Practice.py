# from collections import deque
#
# N, M, V = map(int, input().split())
# matrix = [[0] * (N+1) for _ in range(N+1)]
# for _ in range(M):
#     a, b = map(int, input().split())
#     matrix[a][b] = 1
#     matrix[b][a] = 1
#
# def dfs(start, visited):
#     visited += [start]
#     for c in range(len(matrix[start])):
#         if matrix[start][c] == 1 and (c not in visited):
#             dfs(c, visited)
#     return visited
#



# def bfs(start):
#     visited = [start]
#     queue = [start]
#     while queue:
#         n = queue.pop(0)
#         for c in range(len(matrix[start])):
#             if matrix[n][c]==1 and (c not in visited):
#                 visited.append(c)
#                 queue.append(c)
#     return visited
# d = dfs(V, [])
# b = bfs(V)
# print(*d)
# print(*b)

#
# N, M, V = map(int, input().split())
# matrix = [[0]*(N+1) for _ in range (N+1)]

# for _ in range(M):
#     x, y = map(int, input().split())
#     matrix[x][y] = 1
#     matrix[y][x] = 1
#
# def bfs(start):
#     visited = [start]
#     queue = [start]
#     while queue:
#         n = queue.pop(0)
#         for c in range(len(matrix[n])):
#             if matrix[n][c] == 1 and c not in visited:
#                 visited.append(c)
#                 queue.append(c)
#     return visited
#
# def dfs(start, visited):
#     visited += [start]
#     for c in range(len(matrix[start])):
#         if matrix[start][c] == 1 and (c not in visited):
#             dfs(c, visited)
#     return visited
#
# print(dfs(V, []))
# print(bfs(V))
#
#


