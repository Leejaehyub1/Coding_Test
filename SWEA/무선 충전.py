from collections import deque
# import sys
# sys.stdin = open("sample_input.txt", "r")

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
dx = [0, 0, 1, 0, -1]
dy = [0, -1, 0, 1, 0]


def charge(ay,ax,by,bx, matrix, BC_matrix):

    #사용자 A,B가 받는 BC의 번호 리스트
    t1 = BC_matrix[ay][ax]
    t2 = BC_matrix[by][bx]

    ans = 0
    if t1:
        if t2:
            for i in range(len(t1)):
                for k in range(len(t2)):

                    #같은 번호라면
                    if t1[i] == t2[k]:
                        ans = max(ans, matrix[ay][ax][i])

                    else:
                        ans = max(ans, matrix[ay][ax][i] + matrix[by][bx][k])

        else:
            ans = max(matrix[ay][ax])

    else:
        if t2:
            ans = max(matrix[by][bx])

    return ans



for test_case in range(1, T + 1):

    #해당 point에서 BC의 energy가 저장(큰 값 2개)
    matrix = [[[] for _ in range(10)] for _ in range(10)]

    #해당 point에서 BC의 "번호" 저장
    BC_matrix = [[[] for _ in range(10)] for _ in range(10)]


    #M은 이동시간, N은 BC의 갯수
    M, N = map(int, input().split())
    A_move = list(map(int, input().split()))
    B_move = list(map(int, input().split()))
    ax, ay = 0, 0
    bx, by = 9, 9

    energy_sum = 0
    for w in range(N):
        x, y, dist, energy = (map(int, input().split()))
        x, y = x-1, y-1

        for i in range((-1)*dist, dist+1):
            for k in range((-1)*dist, dist+1):
                if abs(i)+abs(k) <= dist:
                    nx = x+i
                    ny = y+k
                    if 0 <= nx < 10 and 0 <= ny < 10:
                        length = len(matrix[ny][nx])
                        if length <= 1:
                            matrix[ny][nx].append(energy)
                            BC_matrix[ny][nx].append(w)
                        else:
                            min_energy = min(matrix[ny][nx])
                            if min_energy < energy:
                                min_index = matrix[ny][nx].index(min_energy)
                                del matrix[ny][nx][min_index]
                                del BC_matrix[ny][nx][min_index]
                                matrix[ny][nx].append(energy)
                                BC_matrix[ny][nx].append(w)


    energy_sum += charge(ay, ax, by, bx, matrix, BC_matrix)
    #이동X, 상, 우, 하, 좌
    for i in range(M):
        ax = ax + dx[A_move[i]]
        ay = ay + dy[A_move[i]]
        bx = bx + dx[B_move[i]]
        by = by + dy[B_move[i]]
        energy_sum += charge(ay,ax,by,bx,matrix, BC_matrix)


    print("#{} {}".format(test_case, energy_sum))



