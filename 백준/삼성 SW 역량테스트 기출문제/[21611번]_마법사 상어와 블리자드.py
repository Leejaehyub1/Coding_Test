N, M = map(int, input().split())

idxMat = [[0]*N for _ in range(N)]
idxList = [[0,0] for _ in range(N*N)]

curMat = []
curList = []

attack = []

for _ in range(N):
    curMat.append(list(map(int, input().split())))

for _ in range(M):
    d, s = map(int, input().split())
    attack.append([d,s])

num = (N*N)-1
r,c = 0,0
opt = 0  #0은 오른쪽, 1는 아래, 2은 왼쪽, 3는 위로

dr = [0, 1, 0, -1]
dc = [1, 0, -1, 0]


point = [0,0,0]


#idxMat 만든다.
#idxMat는 나선형으로 몇번째 순서인지 알 수 있음.
while(num > 0):
    idxMat[r][c] = num
    num -= 1

    next_r, next_c = r+dr[opt], c+dc[opt]
    if (0 <= next_r < N and 0 <= next_c < N and idxMat[next_r][next_c] == 0):
        r, c = next_r, next_c
    else:
        opt = (opt+1) % 4
        r, c = r+dr[opt], c+dc[opt]


#idxList 만든다.
#idxList[0] = [N//2, N//2 -1]
#index확인용
for i in range(N):
    for k in range(N):
        idxList[idxMat[i][k]][0], idxList[idxMat[i][k]][1] = i, k

idxList.pop(0)


#curList는 현재 나선형 상태
for temp in idxList:
    a,b = map(int, temp)
    curList.append(curMat[a][b])


dr = [0, -1, 1, 0, 0]
dc = [0, 0, 0, -1, 1]


#주문에 의해서 없어질 블록 확인
for i in range(M):
    d, s = map(int, attack[i])
    fade_list = []
    r, c = (N)//2, (N)//2

    for k in range(0,s):
        next_r, next_c = r+dr[d], c+dc[d]
        if (0<=next_r<N and 0<=next_c<N):
            fade_list.insert(0, (next_r, next_c))
            r,c = next_r, next_c

        else:
            break

    # print(fade_list)
    # print(curList)


    while fade_list:
        x_mat, y_mat = fade_list.pop(0)
        idx = idxMat[x_mat][y_mat]
        curList = curList[0:idx-1] + curList[idx:]

    if len(curList) < len(idxList):
        curList = curList + [0]*(len(idxList)-len(curList))

    for i in range(len(curList)):
        curMat[idxList[i][0]][idxList[i][1]] = curList[i]


    # curList = curList + ([0]*(N*N-1+len(curList)))
    # for z in range(len(idxList)):
    #     y, x = map(int, idxList[z])
    #     curMat[y][x] = curList[z]

    group = []
    # print(curList)
    while True:
        same_number = []
        left = 0
        right = 0
        count = 1
        for v in range(len(curList)):
            if curList[left] == curList[v]:
                right = v
                count += 1
            else:
                if count >= 4:
                    same_number.insert(0, [left, right])

                left = v
                count = 1


        if len(same_number)==0:
            break

        for x,y in same_number:
            point[curList[x]-1] += (y-x+1)
            curList = curList[0:x] + curList[y+1:]

    left = 0
    right = 0

    for p in range(1, len(curList)):
        if curList[left] != curList[p]:
            group.append([right-left+1, curList[left]])
            left = p
        right = p

    after = []
    for gr in group:
        x,y = gr[0], gr[1]
        after.append(x)
        after.append(y)

    if len(after) < len(idxList):
        after = after + [0]*(len(idxList)-len(after))

    else:
        after = after[0:len(idxList)]
    curList = after

    for i in range(len(curList)):
        curMat[idxList[i][0]][idxList[i][1]] = curList[i]

    print(curMat)
print(point[0] + 2*point[1] + 3*point[2])




