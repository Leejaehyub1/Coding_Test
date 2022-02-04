import sys

N, B = map(int, input().split())
matrix1 = []

for _ in range(N):
    matrix1.append(list(map(int, sys.stdin.readline().split())))


def multiple(matrix1, matrix2):
    answer = [[0] * N for _ in range(N)]
    for n in range(N):
        for m in range(N):
            for k in range(N):
                answer[n][m] += (matrix1[n][k] * matrix2[k][m])
            answer[n][m] %= 1000
    return answer


def sol(b, matrix):
    if b == 1:
        return matrix
    elif b == 2:
        return multiple(matrix, matrix)
    else:
        temp = sol(b // 2, matrix)
        if b % 2 == 0:
            return multiple(temp, temp)
        else:
            return multiple(matrix, multiple(temp, temp))


ans = (sol(B, matrix1))
for a in ans:
    for k in a:
        print(k % 1000, end=' ')
    print()

#
# def mul(n,matrix1,matrix2):
#     result = [[0 for _ in range(n)] for _ in range(n)]
#
#     for i in range(n):
#         for j in range(n):
#             for k in range(n):
#                 result[i][j] += matrix1[i][k] * matrix2[k][j]
#             result[i][j] %= 1000
#
#     return result
# def devide(n,b,matrix):
#     if b == 1:
#         return matrix
#     elif b == 2:
#         return mul(n,matrix,matrix)
#     else:
#         tmp = devide(n,b//2,matrix)
#         if b%2 == 0:
#             return mul(n,tmp,tmp)
#         else:
#             return mul(n,mul(n,tmp,tmp),matrix)
#
# # 입력
# n, b = map(int, input().split())
# a = [list(map(int, input().split())) for _ in range(n)]
#
# result = devide(n,b,a)
# for row in result:
#     for num in row:
#         print(num%1000, end=' ')
#     print()