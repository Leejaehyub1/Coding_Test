import sys
from collections import Counter
N = int(input())
A = []
for _ in range(N):

    A.append(int(sys.stdin.readline()))

if N == 1:
    print(A[0])
    print(A[0])
    print(A[0])
    print("0")

else:
    A.sort()
    print(round(sum(A)/len(A)))
    print(A[len(A)//2])

    cnt = Counter(A)
    mode = cnt.most_common(2)
    if mode[0][1] != mode[1][1]:
        print(mode[0][0])
    else:
        print(mode[1][0])

    print(max(A)-min(A))



