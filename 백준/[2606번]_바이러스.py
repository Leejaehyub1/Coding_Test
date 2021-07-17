N = int(input())
M = int(input())

matrix = [[0]*(N+1) for _ in range(N+1)]

for _ in range(M):
    temp = input().split()
    a, b = int(temp[0]), int(temp[1])

    matrix[a][b], matrix[b][a] = 1, 1

def BFS(start):
    queue = [start]
    visited = [start]

    while queue:
        n = queue.pop(0)
        for c in range(len(matrix[0])):
            if( (matrix[n][c] ==1) and (c not in visited)):
                visited.append(c)
                queue.append(c)
    return len(visited)-1

print(BFS(1))