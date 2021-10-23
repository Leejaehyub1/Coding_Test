#
#
# def rotate_90(matrix):
#     N = len(matrix)
#     ans = [[0]*N for _ in range(N)]
#     for r in range(N):
#         for c in range(N):
#             ans[c][N-1-r] = matrix[r][c]
#
#     return ans
#
#
# def symmetric_1(matrix):
#     N = len(matrix)
#     ans = [[0] * N for _ in range(N)]
#     for r in range(N):
#         for c in range(N):
#             ans[c][r] = matrix[r][c]
#     return ans
#
# def symmetric_2(matrix):
#     N = len(matrix)
#     ans = [[0] * N for _ in range(N)]
#     for r in range(N):
#         for c in range(N):
#             ans[N-c-1][N-1-r] = matrix[r][c]
#     return ans
#
#
# N, M= map(int, input().split())
# matrix = [list(map(int, input().split())) for _ in range(N)]
#
# # for m in matrix:
# #     print(m)
# #
# # print()
# #
# # for m in rotate_90(matrix):
# #     print(m)
# #
# # print()
# # for m in symmetric_1(matrix):
# #     print(m)
# # print()
# # for m in symmetric_2(matrix):
# #     print(m)
# # print()
#
# #단순히 위로 옮기는 함수
# def move_up(matrix, N, M):
#     for r in range(1, N):
#         for c in range(0, M):
#             matrix[r-1][c] = matrix[r][c]
#     for c in range(0, M):
#         matrix[N-1][c] = 0
#
#
# #0을 제거하면서 위로 당겨지는 함수
# def remove_zero_up(matrix, N, M):
#     ans = [[0] * M for _ in range(N)]
#     for c in range(0, M):
#         for r in range(N-2, -1, -1):
#             if matrix[r][c] == 0:
#                 for w in range(r,N-1):
#                     matrix[w][c] = matrix[w+1][c]
#                 matrix[N-1][c] = 0
#
#
# def remove_zero_down(matrix, N, M):
#     ans = [[0] * M for _ in range(N)]
#
#
#
#
# # move_up(matrix, N, M)
# remove_zero_up(matrix, N, M)
# for m in matrix:
#     print(m)
#
#
#
matrix = [[0,2,3],[4,0,0],[7,0,8]]

# for c in range(len(matrix[0])):
#     for r in range(len(matrix)):
#         temp = []
#         if matrix[r][c] != 0:
#             temp.append(matrix[r][c])
#             matrix[r][c] = 0
#
#     N = len(matrix)
#     for r in range(len(temp)):
#         matrix[N-r-1][c] = temp.pop()

for c in range(len(matrix[0])):
    temp = []
    for r in range(len(matrix)):


        #0이 아니면 push
        if matrix[r][c] != 0:
            temp.append(matrix[r][c])
            matrix[r][c] = 0

        #-1 만나는 순간 전부 pop
        elif matrix[r][c] == -1:
            N = len(matrix)
            for w in range(len(temp)):
                matrix[N - w - 1][c] = temp.pop()

