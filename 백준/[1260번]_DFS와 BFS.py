# import sys
# r = sys.stdin.readline
# r().split()
# N,M = map(int, input().split())

a = input().split()
N, M, start = int(a[0]), int(a[1]), int(a[2])
matrix = [[0]*(N+1) for _ in range(N+1)]


for _ in range(M):
    a, b = map(int, input().split())
    matrix[a][b] = 1
    matrix[b][a] = 1

def BFS(start):
    queue = [start]
    visited = [start]
    while queue:
        n = queue.pop(0)
        for c in range(len(matrix[0])):
            if((matrix[n][c]==1) and (c not in visited)):
                visited.append(c)
                queue.append(c)
    return visited

def DFS(start, visited):
    visited += [start]
    for c in range(len(matrix[0])):
        if ((matrix[start][c]==1) and (c not in visited)):
            DFS(c, visited)
    return visited

print(*DFS(start, []))
print(*BFS(start))






