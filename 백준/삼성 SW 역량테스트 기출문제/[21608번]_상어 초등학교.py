# 인접한 학생의 번호를 적은 matrix
# 인접한 비어있는 칸의 수를 적은 matrix
# Candidate

N = int(input())
state = [[0]*N for _ in range(N)]
likedict = {}

dr = [0,0,1,-1]
dc = [-1,1,0,0]

for _ in range(N*N):
    temp = list(map(int, input().split()))
    likedict[temp[0]] = temp[1:]

    max_x = 0
    max_y = 0
    max_like = -1
    max_empty = -1

    for i in range(N):
        for k in range(N):
            if state[i][k] == 0:
                likecnt = 0
                emptycnt = 0
                for w in range(4):
                    next_r = i + dr[w]
                    next_c = k + dc[w]
                    if 0 <= next_r < N and 0 <= next_c < N:
                        if state[next_r][next_c] in temp:
                            likecnt += 1
                        if state[next_r][next_c] == 0:
                            emptycnt += 1

                if max_like < likecnt or (max_like == likecnt and max_empty < emptycnt):
                    max_x = i
                    max_y = k
                    max_like = likecnt
                    max_empty = emptycnt

    state[max_x][max_y] = temp[0]

result = 0
for i in range(N):
    for j in range(N):
        cnt = 0
        like = likedict[state[i][j]]
        for k in range(4):
            nx = i + dr[k]
            ny = j + dc[k]
            if 0 <= nx < N and 0 <= ny < N:
                if state[nx][ny] in like:
                    cnt += 1
        if cnt != 0:
            result += 10 ** (cnt - 1)

print(result)
