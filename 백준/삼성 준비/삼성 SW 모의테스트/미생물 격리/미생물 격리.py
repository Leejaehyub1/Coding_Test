# import sys
# sys.stdin = open("sample_input.txt", "r")

di = [0, -1, 1, 0, 0]
dk = [0, 0, 0, -1, 1]
change = [0, 2, 1, 4, 3]


def move(matrix, N):
    temp = []
    for i in range(N):
        for k in range(N):
            if len(matrix[i][k]) > 0:
                while matrix[i][k]:
                    m = matrix[i][k].pop()
                    ni = i + di[m.direction]
                    nk = k + dk[m.direction]
                    if not (1 <= ni < N-1 and 1 <= nk < N-1):
                        m.direction = change[m.direction]
                    temp.append([ni, nk, m])
    for t in temp:
        r,c,m = t[0], t[1], t[2]
        matrix[r][c].append(m)



def calculate(matrix, N):
    for i in range(N):
        for k in range(N):
            if not (1 <= i < N-1 and 1 <= k < N-1):
                if len(matrix[i][k]) == 1:
                    matrix[i][k][0].num = matrix[i][k][0].num//2
                    continue

            if len(matrix[i][k]) >= 2:
                max_num = -1
                max_direction = -1
                sum_num = 0
                while matrix[i][k]:
                    temp = matrix[i][k].pop()
                    sum_num += temp.num
                    if max_num < temp.num:
                        max_num = temp.num
                        max_direction = temp.direction
                temp.num = sum_num
                temp.direction = max_direction
                matrix[i][k].append(temp)




def print_mat(matrix):
    for i in range(N):
        for k in range(N):
            if len(matrix[i][k]) > 0:
                for m in matrix[i][k]:
                    print(i, k, m.num, m.direction)

class cell():
    def __init__(self, num, direction):
        self.num = num
        self.direction = direction



T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    #N은 matrix크기, M은 시간, K는 미생물 갯수
    N, M, K = map(int, input().split())
    matrix = [[[] for _ in range(N)] for _ in range(N)]
    cell_list = []
    for _ in range(K):
        r, c, num, direction = map(int, input().split())
        temp = cell(num, direction)
        matrix[r][c].append(temp)

    # for i in range(N):
    #     for k in range(N):
    #         if len(matrix[i][k]) > 0:
    #             for m in matrix[i][k]:
    #                 print(m.num, m.direction)

    for _ in range(M):
        move(matrix, N)
        calculate(matrix, N)
        # print_mat(matrix)
        # print()

    answer = 0
    for i in range(N):
        for k in range(N):
            if len(matrix[i][k]) > 0:
                for m in matrix[i][k]:
                    answer += m.num
    print("#{} {}".format(test_case, answer))

