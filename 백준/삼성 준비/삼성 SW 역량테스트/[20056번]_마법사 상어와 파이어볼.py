import sys

N, M, K = map(int, input().split())
fire_list = []

dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, 1, 1, 1, 0, -1, -1, -1]

matrix = [[[] for _ in range(N)] for _ in range(N)]
fire_balls = []

for _ in range(M):
    r, c, m, s, d = map(int, sys.stdin.readline().split())
    matrix[r-1][c-1].append([m,s,d])
    fire_balls.append([r-1, c-1, m, s, d])


def move(matrix):
    while fire_balls:
        r, c, m, s, d = fire_balls.pop()
        nr, nc = (r + s * dr[d]) % N, (c + s * dc[d]) % N
        matrix[nr][nc].append([m,s,d])



#m은  질량, s는 속도, d는 방향
def sum_fire(matrix):
    for r in range(N):
        for c in range(N):
            if len(matrix[r][c]) > 1:
                sum_m, sum_s, sum_d = 0, 0, 0
                cnt = len(matrix[r][c])
                cnt_even = 0

                while matrix[r][c]:
                    m, s, d = matrix[r][c].pop(0)
                    sum_m += m
                    sum_s += s
                    sum_d += d
                    if d %2 == 0:
                        cnt_even += 1

                sum_m //= 5
                sum_s //= cnt

                if sum_m != 0:
                    if (cnt_even == 0 or cnt_even == cnt):
                        for i in range(0, 7, 2):
                            fire_balls.append([r, c, sum_m, sum_s, i])

                    else:
                        for i in range(1,8,2):
                            fire_balls.append([r, c, sum_m, sum_s, i])

            elif len(matrix[r][c]) == 1:
                fire_balls.append([r, c] + matrix[r][c].pop())


def result(matrix):
    ans = 0
    for f in fire_balls:
        ans += f[2]
    return ans


for _ in range(K):
    move(matrix)
    sum_fire(matrix)
# print(matrix)
# print(fire_balls)
print(result(matrix))














