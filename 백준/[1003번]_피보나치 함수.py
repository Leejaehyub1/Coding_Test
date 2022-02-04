num = int(input())
for _ in range(num):
    N = int(input())
    i = 2
    zero = [1, 0]
    one = [0, 1]
    if N ==0:
        print("1 0")
    elif N==1:
        print("0 1")
    else:
        for i in range(2, N+1):
            zero[0], zero[1] = zero[1], zero[0]+zero[1]
            one[0], one[1] = one[1], one[0]+one[1]

        print(zero[1], one[1])






