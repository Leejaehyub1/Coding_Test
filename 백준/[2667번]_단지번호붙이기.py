N = int(input())
matrix = [[0]*(N+1) for _ in range(N+1)]
part = []
visited = []
queue = []

for i in range(1,N+1):
    temp = input()
    for k in range(len(temp)):
        matrix[i][k] = int(temp[k])
        if (temp[k])== 0:
            visited.append([i,k])

for i in range(1,N+1):
    for k in range(1,N+1):
        if matrix[i][k] == 1:
            queue.append([i,k])
            visited.append([i,k])
            while queue:
                temp = queue.pop(0)
                s,t = temp[0], temp[1]




