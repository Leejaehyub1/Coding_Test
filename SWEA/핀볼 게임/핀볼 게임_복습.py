import sys
sys.stdin = open("input.txt", "r")

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.

#상, 하, 좌, 우
dc = [0, 0, -1, 1]
dr = [-1, 1, 0, 0]
change = [1, 0, 3, 2]

#ndirection = dir_change[방향][벽번호]
dir_change = [[0,1,3,2,1,1],  #방향이 상승일때
              [0,3,0,0,2,0],  #방향이 하락일때
              [0,0,1,3,3,3],  #방향이 왼쪽일때
              [0,2,2,1,0,2]]  #방향이 오른쪽일때

def print_mat(matrix):
    for m in matrix:
        print(m)

def calculate(matrix, r, c, direction):
    start_r, start_c = r, c
    r, c = r+dr[direction], c+dc[direction]
    count = 0
    while count<100:
        #제자리
        if r == start_r and c == start_c:
            print("제자리")
            break

        if (r<0 or c<0 or N-1<r or N-1<c):
            direction = change[direction]
            r, c = r + dr[direction], c + dc[direction]
            count += 1
            print("벽", r, c, count)

        #블랙홀
        elif matrix[r][c] == -1:
            break

        #그냥 빈칸
        elif matrix[r][c] == 0:
            print("빈칸", r, c, count)
            r, c = r + dr[direction], c + dc[direction]

        #벽
        elif 1 <= matrix[r][c] <= 5:
            ndirection = dir_change[direction][matrix[r][c]]
            print("방향변경", r,c,count)
            direction = ndirection
            r, c = r + dr[direction], c + dc[direction]
            count += 1


        #웜홀
        else:
            r,c = worm[(r,c)]
            print("웜홀", r, c, count)
            r, c = r + dr[direction], c + dc[direction]

    return count

for test_case in range(1, T + 1):
    N = int(input())
    matrix = []
    worm_hole = [[],[],[],[],[]]
    worm = dict()
    for i in range(N):
        temp = list(map(int, input().split()))
        matrix.append(temp)
        for k in range(N):
            if 6 <= temp[k] <= 10:
                worm_hole[temp[k]-6].append([i,k])

    for wor in worm_hole:
        if len(wor) > 0:   #wor = [[2,3],[4,5]]
            r1, c1 = wor[0][0], wor[0][1]
            r2, c2 = wor[1][0], wor[1][1]
            worm[(r1,c1)] = [r2,c2]
            worm[(r2, c2)] = [r1, c1]


    ans = 0
    # for r in range(N):
    #     for c in range(N):
    #         if matrix[r][c] == 0:
    #             for direction in range(4):
    #                 # print(r, c, direction)
    #                 temp = calculate(matrix, r, c, direction)
    #                 if temp > ans:
    #                     ans = temp
    #                     print(r,c,temp)


    print(calculate(matrix, 0, 2, 2))
    # print(ans)



