from itertools import product

N, M = map(int, input().split())
for i in product(range(1,N+1), repeat=M):
    print(' '.join(map(str,i)))





# N, M = map(int, input().split())
# s = []
# def f():
#     if len(s) == M:
#         print(' '.join(map(str, s)))
#         return
#
#     for i in range(1, N+1):
#
#         s.append(i)
#         f()
#         s.pop()
#
# f()