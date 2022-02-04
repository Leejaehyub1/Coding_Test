N = int(input())

def Fib(N):
    if N==0 or N==1:
        return N

    else:
        return Fib(N-1) + Fib(N-2)

print(Fib(N))

