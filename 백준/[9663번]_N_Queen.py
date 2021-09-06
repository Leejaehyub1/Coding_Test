def adjacent(x):
    for i in range(x):
        if row[x] == row[i] or (abs(row[x]-row[i]) == x - i):
            return False
    return True


def dfs(x):
    global count
    if x == N:
        count += 1

    else:
        for i in range(N):
            row[x] = i
            if adjacent(x):
                dfs(x+1)

N = int(input())
row = [0] * N
count = 0
dfs(0)
print(count)
