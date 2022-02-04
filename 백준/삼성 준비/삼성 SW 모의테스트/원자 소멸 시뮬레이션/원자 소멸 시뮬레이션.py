import sys

sys.stdin = open("sample_input.txt", "r")
# sys.stdin = open("sample_input.txt", "r")

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.


dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def add_dic(d1, x,y, direction, energy):
    if (x, y) not in d1:
        d1[(x, y)] = [[direction, energy]]

    else:

        temp = d1[(x, y)]
        temp.append([direction, energy])
        d1[(x, y)] = temp



def move_all(dic):
    ans = {}
    for d in dic:
        temp = dic[d]
        for t in temp:
            x, y, direction, energy = d[0], d[1], t[0], t[1]
            nx, ny = x + (0.5) * dx[direction], y + (0.5) * dy[direction]
            if -1000<=nx<1000 and -1000<=ny<=1000:
                add_dic(ans, nx, ny, direction, energy)

    return ans

def check(dic):
    global point
    del_list = []
    for d in dic:
        temp = dic[d]
        # print(temp)
        if len(temp) > 1:
            for t in temp:
                point += t[1]
            del_list.append(d)


    for d in del_list:
        del dic[d]



for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    N = int(input())
    energy = 0
    dic = {}
    point = 0

    for _ in range(N):
        # x, y, 이동방향, 에너지
        x, y, direction, energy = map(int, input().split())
        add_dic(dic, x, y, direction, energy)

    # for d in dic:
    #     print(d, dic[d])

    # dic = move_all(dic)
    # check(dic)
    # dic = move_all(dic)
    # check(dic)
    for _ in range(4000):
        if len(dic) < 2:
            break
        else:
            dic = move_all(dic)
            check(dic)
            dic = move_all(dic)
            check(dic)

    print("#{} {}".format(test_case, point))



    # ///////////////////////////////////////////////////////////////////////////////////

#
#
# qw = {}
# qw[(0,0)] = [[1,2,3],[4,5,6]]
# qw[(1,1)] = [[4,6,9]]


