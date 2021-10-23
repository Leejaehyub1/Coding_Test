from collections import deque
N = int(input())

def make_index_list(N):
    index_list = deque()
    temp = deque()
    size = N
    n = 0
    x, y = -1, 0
    step = 1
    while True:
        for _ in range(size):  # 몇 칸 진행할까
            n += 1
            x += step
            temp.append((x, y))
        size -= 1
        if size < 1:  # 출력할 게 없으면 종료
            break
        for _ in range(size):  # 몇 줄 진행할까
            n += 1
            y += step
            temp.append((x, y))
        step = -step  # 증감 방향을 반대로
    while temp:
        index_list.append(temp.pop())

    return index_list

def print_mat(matrix):
    for m in matrix:
        print(m)





matrix = [list(map(int, input().split())) for _ in range(N)]
flag = 0
ans = 0
time = 1

dr = [0, 1, 0, -1]
dc = [-1, 0, 1, 0]

while flag != 1:
    for i in range(4):
        for k in range(time):
            r, c = r+dr[i], c+dc[i]
            if i ==0:
                spread(r,c)

# index_list = make_index_list(N)


out = 0
# while index_list:
#     r,c = index_list.popleft()
#     print(r,c)



