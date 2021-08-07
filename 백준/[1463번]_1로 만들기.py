N = int(input())
num = 0
DP = {1}

while(N not in DP):
    temp = set()
    for i in DP:
        temp.update([i+1, 2*i, 3*i])

    DP = temp
    num += 1

print(num)