# 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
# 아래 표준 입출력 예제 필요시 참고하세요.

# 표준 입력 예제
'''
a = int(input())                        정수형 변수 1개 입력 받는 예제
b, c = map(int, input().split())        정수형 변수 2개 입력 받는 예제
d = float(input())                      실수형 변수 1개 입력 받는 예제
e, f, g = map(float, input().split())   실수형 변수 3개 입력 받는 예제
h = input()                             문자열 변수 1개 입력 받는 예제
'''

# 표준 출력 예제
'''
a, b = 6, 3
c, d, e = 1.0, 2.5, 3.4
f = "ABC"
print(a)                                정수형 변수 1개 출력하는 예제
print(b, end = " ")                     줄바꿈 하지 않고 정수형 변수와 공백을 출력하는 예제
print(c, d, e)                          실수형 변수 3개 출력하는 예제
print(f)                                문자열 1개 출력하는 예제
'''



class cell:
    def __init__(self,x,y,time):

        #생명력
        self.hp = x

        #활성화 하는데 걸리는 시간
        self.ahp = x

        #0은 없음, 1은 비활성, 2는 활성, 3은 죽음
        self.status = y

        #처음 생명력
        self.first_hp = x

        #처음 생명력
        self.birth = time

def time_change(map1):
    for map in map1:
        for m in map:
            if m.status == 1:
                m.ahp -= 1
            if m.status == 2:
                m.hp -= 1

def make_cell(map1, x, y, time):
    dx = [0, -1, 1, 0]
    dy = [-1, 0, 0, 1]

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if map1[nx][ny].birth == time:
            if map1[nx][ny].first_hp < map1[x][y].first_hp:
                map1[nx][ny].first_hp = map1[x][y].first_hp
        else:
            if map1[nx][ny].status == 0:
                map1[nx][ny] = cell(map1[x][y].first_hp, 1, time)

def calculate(map1, time):
    for i in range(N+K):
        for k in range(M+K):
            if map1[i][k].ahp == 0 and map1[i][k].status == 1:
                    map1[i][k].status += 1

            if map1[i][k].status == 2 and map1[i][k].hp == map1[i][k].first_hp-1:
                make_cell(map1, i, k, time)

            if map1[i][k].status == 2 and map1[i][k].hp == 0:
                map1[i][k].status += 1



def print_mat(map1):
    for m in map1:
        for k in range(len(m)):
            print("[%d, %d, %d, %d]"%(m[k].hp, m[k].ahp, m[k].first_hp, m[k].status), end=" ")
        print()
    print()

import sys
sys.stdin = open("sample_input.txt", "r")
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    N, M, K = map(int, input().split())

    #HP, waiting time, status
    map1 = [[cell(0, 0, 0) for _ in range(M+K+1)] for _ in range(N+K+1)]
    start_x = (N+K)//2 - 1
    start_y = (M+K)//2 - 1
    map2 = [list(map(int,input().split())) for _ in range(N)]
    for i in range(N):
        for k in range(M):
            if map2[i][k] != 0:
                map1[start_x + i][start_y + k].hp = map2[i][k]
                map1[start_x + i][start_y + k].ahp = map2[i][k]
                map1[start_x + i][start_y + k].first_hp = map2[i][k]
                map1[start_x + i][start_y + k].status = 1



    # print_mat(map1)
    for time in range(K+1):
        time_change(map1)
        calculate(map1, time+1)
        # print(time+1)
        # print_mat(map1)

    ans = 0
    for m in map1:
        for k in range(len(m)):
            if 1 <= m[k].status <= 2:
                ans += 1

    print("#{} {}".format(test_case, ans))



    # ///////////////////////////////////////////////////////////////////////////////////
