import sys
sys.stdin = open("sample_input.txt", "r")

change =    [[0,0,0,0],
    [1,3,0,2],
    [3,0,1,3],
    [2,0,3,1],
    [1,2,3,0],
    [1,0,3,2]]

dr = [0, 0, -1, 1]
dc = [-1, 1, 0, 0]


T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    field = []
    portal = {}
    zeros = []
    answer = 0
    for i in range(n):
        s = list(map(int,input().split()))
        for k in range(n):
            if s[k] == 0:
                zeros.append([i,k])
            if 5 < s[k]:
                if portal.get(s[k]) is None:
                    portal[s[k]] = [[i,k]]
                else:
                    portal[s[k]].append([i, k])

        field.append(s)

    for r in range(n):
        for c in range(n):
            if field[r][c] == 0:
                for w in range(4):
                    cnt = 0
                    nr, nc = r + dr[w], c + dc[w]
                    while True:
                        if (nr, nc) ==(r, c) or field[r][c] == -1:
                            break

                        elif 1<= field[nr][nc] <= 5:
                            w = change[field[nr][nc]][w]
                            cnt += 1
                        elif 6<= field[nr][nc] <= 10:
                            temp = portal[field[nr][nc]][0]
                            if temp != [nr, nc]:
                                nr, nc = portal[field[nr][nc]][1]

                        nr, nc = nr+dr[w], nc+dc[w]



                    if cnt > answer:
                        answer = cnt

    print(answer)