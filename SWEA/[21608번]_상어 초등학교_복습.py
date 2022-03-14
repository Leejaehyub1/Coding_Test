N = int(input())
matrix = [[0]*N for _ in range(N)]
like_list_all = {}
dr = [0, 0, -1, 1]
dc = [1, -1, 0, 0]

for _ in range(N*N):
    temp = list(map(int, input().split()))
    like_list_all[temp[0]] = temp[1:]

    max_r = 0
    max_c = 0
    max_empty = -1
    max_like = -1


    for r in range(N):
        for c in range(N):
            if matrix[r][c] == 0:
                count_empty = 0
                count_like = 0
                for i in range(4):
                    nr = r + dr[i]
                    nc = c + dc[i]
                    if 0 <= nr < N and 0 <= nc < N:
                        if matrix[nr][nc] in like_list_all[temp[0]]:
                            count_like += 1
                        if matrix[nr][nc] == 0:
                            count_empty += 1

                if max_like < count_like or (max_like == count_like and max_empty < count_empty):
                    max_r = r
                    max_c = c
                    max_like = count_like
                    max_empty = count_empty

    matrix[max_r][max_c] = temp[0]

answer = 0


for r in range(N):
    for c in range(N):
        count_like = 0
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < N and 0 <= nc < N:
                if matrix[nr][nc] in like_list_all[matrix[r][c]]:
                    count_like += 1
        if count_like !=0:
            answer += 10 ** (count_like -1)


print(answer)
