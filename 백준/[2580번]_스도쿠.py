# def dfs(depth):
#     if depth == blank_num:
#         for v in board:
#             print(' '.join(map(str,v)))
#         exit(0)
#
#     y, x = pos[depth]
#     for n in range(1, 10):
#         if not row_arr[y][n] and not col_arr[x][n] and not box_arr[(y//3)*3 + x//3][n]:
#             row_arr[y][n] = col_arr[x][n] = box_arr[(y//3)*3 + x//3][n] = True
#             board[y][x] = n
#             dfs(depth+1)
#             row_arr[y][n] = col_arr[x][n] = box_arr[(y//3)*3 + x//3][n] = True
#             board[y][x] = 0
#
#
#
# board = [list(map(int, input().split())) for _ in range(9)]
# row_arr = [[False] * 10 for _ in range(10)]
# col_arr = [[False] * 10 for _ in range(10)]
# box_arr = [[False] * 10 for _ in range(10)]
#
# pos = []
#
# for i in range(9):
#     for k in range(9):
#         if not board[i][k]:
#             pos.append([i,k])
#         else:
#             row_arr[i][board[i][k]] = True
#             col_arr[i][board[i][k]] = True
#             box_arr[(i//3)*3 + k//3][board[i][k]] = True
#
#
# blank_num = len(pos)
# dfs(0)
#
import sys
import itertools
board = [list(map(int, sys.stdin.readline().split())) for _ in range(9)]
zero_pos = [(x,y) for x in range(9) for y in range(9) if board[x][y] == 0]
z_len = len(zero_pos)
offset = list(itertools.product([1,-1,0],repeat=2))
offset_pos = [1]*3+[4]*3+[7]*3
finished = False
def choice(x,y):
    nums = list(range(1,10))
    for n in range(9):
        if board[x][n] in nums:
            nums.remove(board[x][n])
        if board[n][y] in nums:
            nums.remove(board[n][y])
    for off in offset:
        dx = offset_pos[x]+off[0]
        dy = offset_pos[y]+off[1]
        if board[dx][dy] in nums:
            nums.remove(board[dx][dy])
    return nums

def dfs(cur):
    global finished
    if finished == True :
        return
    if cur == z_len:
        for item in board:
            print(*item)
        finished = True
        return
    else:
        (x,y) = zero_pos[cur]
        for c in choice(x,y):
            board[x][y] = c
            dfs(cur+1)
            board[x][y] = 0
dfs(0)