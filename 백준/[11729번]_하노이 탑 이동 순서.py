n = int(input())
A = []
def Hanoi(a, b, c,N):
    global A
    if N == 1:
        A.append([a,c])
    else:
        (Hanoi(a, c, b, N-1))
        A.append([a, c])
        Hanoi(b, a, c, N-1)

Hanoi(1,2,3, n)
print(len(A))
for a in A:
    print(a[0], a[1])
