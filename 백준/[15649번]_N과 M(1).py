# from itertools import permutations
# N, M = map(int, input().split(" "))
# A = [i for i in range(1,N+1)]
#
# for i in permutations(A, M):
#     print(' '.join(list(map(str, i))))
#

N, M = map(int, input().split())

s = []
def f():
    if len(s) == M:
        print(' '.join(map(str, s)))
        return

    for i in range(1, N+1):
        if i in s:
            continue

        s.append(i)
        f()
        s.pop()

f()