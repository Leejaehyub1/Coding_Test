N = int(input())

def Star(N):
    if N==1:
        print("*",end="")
    else:
        for i in range(3):
            Star(N//3)
        print()
        for i in range(3):
            Star(N//3)


Star(N)