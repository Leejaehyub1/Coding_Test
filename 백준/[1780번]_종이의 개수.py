N = int(input())
minus, zero, one = 0, 0, 0
arr = []
for _ in range(N):
    arr.append(list(map(int, input().split())))


def sol(arr):
    global minus
    global zero
    global one
    r = len(arr)

    flag_minus, flag_zero, flag_one = True, True, True
    for a in arr:
        if (flag_minus == False and flag_zero == False and flag_one == False):
            break
        for k in a:
            if k == -1:
                flag_zero = False
                flag_one = False
            elif k == 0:
                flag_minus = False
                flag_one = False
            elif k == 1:
                flag_minus = False
                flag_zero = False

    if flag_zero:   zero += 1
    if flag_one:    one += 1
    if flag_minus:  minus += 1

    if (flag_minus == False and flag_zero == False and flag_one == False):
        temp1 = []
        temp2 = []
        temp3 = []
        temp4 = []
        temp5 = []
        temp6 = []
        temp7 = []
        temp8 = []
        temp9 = []
        for i in range(0, r//3):
            temp1.append(arr[i][:r//3])
            temp2.append(arr[i][r//3:(r*2)//3])
            temp3.append(arr[i][(r * 2) // 3:])
            temp4.append(arr[i + r//3][:r//3])
            temp5.append(arr[i + r // 3][r//3:(r*2)//3])
            temp6.append(arr[i + r // 3][(r * 2) // 3:])
            temp7.append(arr[i + (2*r) // 3][:r // 3])
            temp8.append(arr[i + (2*r) // 3][r // 3:(r * 2) // 3])
            temp9.append(arr[i + (2*r) // 3][(r * 2) // 3:])

        sol(temp1)
        sol(temp2)
        sol(temp3)
        sol(temp4)
        sol(temp5)
        sol(temp6)
        sol(temp7)
        sol(temp8)
        sol(temp9)

sol(arr)
print(minus)
print(zero)
print(one)

