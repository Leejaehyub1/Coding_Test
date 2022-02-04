import copy

def dfs(idx, mapp2):
    global block_cnt
    if idx == N:
        cnt = 0
        for z in range(H):
            cnt += mapp2[z].count(0)
        result_cnt = W*H - cnt
        if result_cnt < block_cnt:
            block_cnt = result_cnt
        return

    for y in range(W):
        check = 0
        for x in range(H):
            if not mapp2[x][y]:
                continue
            else:
                init_mapp = copy.deepcopy(mapp2)
                q = [(x,y,mapp2[x][y])]
                while q:
                    qq = q.pop(0)
                    if qq[2] == 1:
                        mapp2[qq[0][qq[1]]] = 0
                    else:
                        mapp2[qq[0][qq[1]]] = 0
                        for k in range(1,qq[2]):




T = int(input())
for t in range(1, T+1):
    N, W, H = map(int, input().split())
    mapp = [list(map(int, input().split())) for _ in range(H)]
    block_cnt = 999999999
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    dfs(0, mapp)
    print("#{} {}".fomat(t, block_cnt))
