T = int(input())

block = {}
block[1] = [1, 3, 0, 2]
block[2] = [3, 0, 1, 2]
block[3] = [2, 0, 3, 1]
block[4] = [1, 2, 3, 0]
block[5] = [1, 0, 3, 2]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for t in range(T):
    n = int(input())
    board = []
    worm_hole = {}

    for i in range(n):
        temp = list(map(int, input().split()))
        for j in range(n):
            if 6 <= temp[j] <= 10:  # 웜홀
                if temp[j] in worm_hole:
                    worm_hole[temp[j]].append([i, j])
                else:
                    worm_hole[temp[j]] = [[i, j]]
        board.append(temp)


    def game(x, y, d):  # 게임

        cx = x + dx[d]
        cy = y + dy[d]
        direc = d
        score = 0

        while True:
            # print(x, y, d, direc, cx, cy)
            if 0 > cx or cx >= n or 0 > cy or cy >= n:
                # print("범위~")
                cx = cx - dx[direc]
                cy = cy - dy[direc]
                direc = block[5][direc]
                score += 1
                continue

            if board[cx][cy] == -1:  # 블랙홀인 경우
                # print("블랙홀~")
                break
            if cx == x and cy == y:
                # print("처음 위치~")
                break

            if board[cx][cy] == 0:
                # print("그냥 빈칸~")
                cx = cx + dx[direc]
                cy = cy + dy[direc]
            elif 1 <= board[cx][cy] <= 5:
                # print("블럭~")
                direc = block[board[cx][cy]][direc]
                cx = cx + dx[direc]
                cy = cy + dy[direc]
                score += 1
            elif 6 <= board[cx][cy] <= 10:
                # print("웜홀~")
                for k in range(2):
                    nx = worm_hole[board[cx][cy]][k][0]
                    ny = worm_hole[board[cx][cy]][k][1]
                    # print(worm_hole[board[cx][cy]][k], direc,cx, cy, nx, ny)
                    if (cx, cy) != (nx, ny):
                        cx = nx + dx[direc]
                        cy = ny + dy[direc]
                        # print(cx, cy)
                        break
                continue

        return score


    max_score = -1
    for i in range(n):
        for j in range(n):
            if board[i][j] == 0:
                for k in range(4):
                    score = game(i, j, k)
                    if max_score < score:
                        max_score = score
    print("#" + str(t + 1) + ' ' + str(max_score))




