import sys
N = int(input())
A = list(map(int,sys.stdin.readline().split()))
B = dict()
for a in A:
    B[a] = 0

C = list(set(A))
C.sort()

for i in range(1, len(C)):
    if(C[i] != C[i-1]):
        B[C[i]] = i

for a in A:
    print(B[a])

# print(A)
# print(B)
# print(C)