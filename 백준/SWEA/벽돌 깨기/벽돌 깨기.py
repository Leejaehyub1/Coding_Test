# # 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
# # 아래 표준 입출력 예제 필요시 참고하세요.
#
# # 표준 입력 예제
# '''
# a = int(input())                        정수형 변수 1개 입력 받는 예제
# b, c = map(int, input().split())        정수형 변수 2개 입력 받는 예제
# d = float(input())                      실수형 변수 1개 입력 받는 예제
# e, f, g = map(float, input().split())   실수형 변수 3개 입력 받는 예제
# h = input()                             문자열 변수 1개 입력 받는 예제
# '''
#
# # 표준 출력 예제
# '''
# a, b = 6, 3
# c, d, e = 1.0, 2.5, 3.4
# f = "ABC"
# print(a)                                정수형 변수 1개 출력하는 예제
# print(b, end = " ")                     줄바꿈 하지 않고 정수형 변수와 공백을 출력하는 예제
# print(c, d, e)                          실수형 변수 3개 출력하는 예제
# print(f)                                문자열 1개 출력하는 예제
# '''
#
# import sys
#
#
# '''
#       아래의 구문은 input.txt 를 read only 형식으로 연 후,
#       앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
#       여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
#       아래 구문을 이용하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
#
#       따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 구문을 사용하셔도 좋습니다.
#       아래 구문을 사용하기 위해서는 import sys가 필요합니다.
#
#       단, 채점을 위해 코드를 제출하실 때에는 반드시 아래 구문을 지우거나 주석 처리 하셔야 합니다.
# '''
# from copy import deepcopy
#
# def gravity(matrix, H, W):
#     ans = deepcopy(matrix)
#     for i in range(0, H, 1):
#         for k in range(W):
#             if ans[i][k] == 0:
#                 for a in range(0, i):
#                     ans[i-a][k] = ans[i-a-1][k]
#                 ans[0][k] = 0
#                 # for m in matrix:
#                 #     print(m)
#                 # print()
#     return ans
# # def gravity(map1, h, w):
# #     map2 = deepcopy(map1)
# #     for y in range(w):
# #         for x in range(h):
# #             if map2[x][y] == 0:
# #                 for j in range(x, 0, -1):
# #                     map2[j][y] = map2[j-1][y]
# #                 map2[0][y] = 0
# #     return map2
#
#
# def destroy(matrix, H, W, x, y):
#     counter = 0
#     dx = [-1, 0, 1, 0]
#     dy = [0, -1, 0, 1]
#     map2 = deepcopy(matrix)
#     s1 = [[x,y]]
#     while s1:
#         nx, ny = s1.pop()
#         number = map2[nx][ny]
#         if map2[nx][ny] == 0:
#             continue
#         map2[nx][ny] == 0
#         counter += 1
#         if number > 1:
#             for i in range(1, number):
#                 for k in range(4):
#                     nx2 = nx + i * dx[k]
#                     ny2 = ny + i * dy[k]
#                     if -1 < nx2 < H and -1 < ny2 < W and map2[nx2][ny2]!=0:
#                         s1.append([nx2, ny2])
#
#     return map2, counter
#
#
#
# def solution(matrix, N, H, W):
#     global num_block
#     answer = H * W
#
#     #공 횟수, 깨트린 블럭, 맵
#     stack = [[0, 0, matrix]]
#     while stack:
#         count, sub, nmap = stack.pop()
#         if sub == num_block:
#             return 0
#         if count == N:
#             if answer > num_block - sub:
#                 answer = num_block - sub
#         else:
#             for y1 in range(W):
#                 flag = 0
#                 x1 = 0
#                 while True:
#                     if x1 == H:
#                         flag = 1
#                         break
#                     elif nmap[x1][y1] == 0:
#                         x1 += 1
#                     else:
#                         break
#                 if flag == 1:
#                     continue
#                 else:
#                     nmap2, nsub = destroy(nmap, H, W, x1, y1)
#                     nmap2 = gravity(nmap2, H, W)
#                     stack.append([count+1, sub + nsub, nmap2])
#
#     return answer
#
#
#
#
#
# sys.stdin = open("sample_input.txt", "r")
# T = int(input())
#
# for test_case in range(1, T + 1):
#     # ///////////////////////////////////////////////////////////////////////////////////
#     N, W, H = map(int, input().split())
#     matrix = []
#     num_block = 0
#     for _ in range(H):
#         temp = list(map(int, input().split()))
#         for t in temp:
#             if t != 0:
#                 num_block += 1
#         matrix.append(temp)
#
#     # print(matrix)
#     answer = solution(matrix, N, H, W)
#     print("#{} {}".format(test_case, answer))
#     # for m in matrix:
#     #     print(m)
#
#
#
#
from copy import deepcopy
def clean(map1, h, w):
    map2 = deepcopy(map1)
    for y in range(w):
        for x in range(h):
            if map2[x][y] == 0:
                for j in range(x, 0, -1):
                    map2[j][y] = map2[j - 1][y]
                map2[0][y] = 0
    return map2


def destroy(map1, h, w, x, y):
    counter = 0
    dx = [-1, 0, 1, 0]
    dy = [0, -1, 0, 1]
    map2 = deepcopy(map1)
    s1 = [[x, y]]
    while s1:
        nx, ny = s1.pop()
        number = map2[nx][ny]
        if map2[nx][ny] == 0:
            continue
        map2[nx][ny] = 0
        counter += 1
        if number == 1:
            for i in range(1, number):
                for d in range(4):
                    nx2 = nx + i * dx[d]
                    ny2 = ny + i * dy[d]
                    if -1 < nx2 < h and -1 < ny2 < w and map2[nx2][ny2] != 0:
                        s1.append([nx2, ny2])
    return map2, counter


def solution(map1, n, h, w):
    global blocks
    answer = h * w
    # 공 횟수 깨뜨린 블럭 맵
    stack = [[0, 0, map1]]
    while stack:
        count, sub, nmap = stack.pop()
        if sub==blocks:
            return 0
        if count == n:
            if answer > blocks - sub:
                answer = blocks - sub
        else:
            # y축 전부 돌면서
            for y1 in range(w):
                flag = 0
                x1 = 0
                while 1:
                    if x1 == h:
                        flag = 1
                        break
                    elif nmap[x1][y1] == 0:
                        x1 += 1
                    else:
                        break
                if flag == 1:
                    continue
                else:
                    nmap2, nsub = destroy(nmap, h, w, x1, y1)
                    nmap2=clean(nmap2,h,w)
                    stack.append([count + 1, sub + nsub, nmap2])
    return answer

t=int(input())
for test in range(1,t+1):
    n, w, h = map(int, input().split())
    map1 = []
    blocks = 0
    for _ in range(h):
        s = list(map(int, input().split()))
        for i in s:
            if i != 0:
                blocks += 1
        map1.append(s)
    answer=solution(map1,n,h,w)
    print('#{} {}'.format(test, answer))