N = int(input())
arr = []
for _ in range(N):
    temp = []
    num_str = input()
    for num in num_str:
        temp.append(int(num))
    arr.append(temp)



def sol(arr):
    a = len(arr)
    # print(a)
    arr_sum = 0
    for i in range(a):
        arr_sum += sum(arr[i])

    if arr_sum == (a * a):
        print("1", end="")
    elif arr_sum == 0:
        print("0", end="")
    else:
        print("(", end="")
        temp1 = []
        temp2 = []
        temp3 = []
        temp4 = []
        for i in range(0, a//2):
            temp1.append(arr[i][:a//2])
            temp2.append(arr[i][a//2:])
            temp3.append(arr[i + a//2][:a//2])
            temp4.append(arr[i + a//2][a//2:])

        sol(temp1)
        sol(temp2)
        sol(temp3)
        sol(temp4)
        print(")", end="")

sol(arr)


