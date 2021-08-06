ans = [[[0]*21 for _ in range(21)] for _ in range(21)]
def w(a,b,c):

    if (a <= 0 or b <= 0 or c <= 0):
        return 1

    if (20 < a or 20 < b or 20 < c):
        return w(20,20,20)

    if (ans[a][b][c] != 0):
        return ans[a][b][c]

    if(a < b and b < c):
        ans[a][b][c] = w(a,b,c-1) + w(a, b-1, c-1) - w(a, b-1, c)
        return ans[a][b][c]

    else:
        ans[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
        return ans[a][b][c]





while(True):
    a, b, c = map(int, input().split(" "))
    if(a==-1 and b==-1 and c==-1):
        break
    print('w({0}, {1}, {2}) = {3}'.format(a,b,c,w(a,b,c)))


