import math
a, b, c = map(int, input().split())

def sol(a,b,c):
    if b == 1:
        return a%c
    else:
        temp = sol(a, b//2, c)
        if b % 2 == 0:
            return temp*temp %c
        else:
            return temp * temp * a % c

print(sol(a,b,c))




