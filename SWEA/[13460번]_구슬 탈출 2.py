N, M = map(int, input().split())

matrix = []

rx, ry = 0, 0
bx, by = 0, 0
ox, oy = 0, 0

queue = []

for i in range(N):
    temp = input()
    for k in range(M):
        c = temp[k]
        if c == 'R':
            rx, ry = i, k

        if c == 'B':
            bx, by = i, k

    matrix.append(list(temp))


visited = {}
visited[rx, ry, bx, by] = True
queue.append((rx, ry, bx, by, 1))

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def move(x, y, dx ,dy):
    cnt = 0
    while matrix[x+dx][y+dy] != '#' and matrix[x][y] != 'O':
        x += dx
        y += dy
        cnt += 1
    return x,y,cnt

def bfs():
    while queue:
        rx, ry, bx, by, depth = queue.pop(0)
        if depth > 10:
            break

        for i in range(4):
            nrx, nry, rcnt = move(rx, ry, dx[i], dy[i])
            nbx, nby, bcnt = move(bx, by, dx[i], dy[i])

            if matrix[nbx][nby] != 'O':
                if matrix[nrx][nry] == 'O':
                    print(depth)
                    return

                if nrx == nbx and nry == nby:
                    if rcnt > bcnt:
                        nrx -= dx[i]
                        nry -= dy[i]
                    else:
                        nbx -= dx[i]
                        nby -= dy[i]

                if not (nrx, nry, nbx, nby) in visited:
                    visited[nrx, nry, nbx, nby] = True
                    queue.append((nrx, nry, nbx, nby, depth+1))

    print("-1")

bfs()






