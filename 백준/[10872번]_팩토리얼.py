N = int(input())

def Factorial(N):
    if N==1 or N==0:
        return 1
    else:
        return N*Factorial(N-1)

print(Factorial(N))