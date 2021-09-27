N = 2
b = int(input())
matrix1 = [[1,1],[1,0]]

def multiple(matrix1, matrix2):
    answer = [[0]*N for _ in range(N)]
    for n in range(N):
        for m in range(N):
            for k in range(N):
                answer[n][m] += (matrix1[n][k] * matrix2[k][m])
            answer[n][m] %= 1000000007
    return answer

def sol(b, matrix):
    if b == 1:
        return matrix
    elif b == 2:
        return multiple(matrix, matrix)
    else:
        temp = sol(b//2, matrix)
        if b%2 == 0:
            return multiple(temp, temp)
        else:
            return multiple(matrix, multiple(temp,temp))


ans = (sol(b, matrix1))
print(ans[0][1]%1000000007)





