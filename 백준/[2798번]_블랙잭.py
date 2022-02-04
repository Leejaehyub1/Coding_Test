from itertools import combinations

_, M = input().split()
M =int(M)
num_list = list(map(int, input().split()))

for i in num_list:
    if i > M:
        num_list.remove(i)

answer = -1
for com in combinations(num_list, 3):
    s = sum(com)
    if (answer < s and s <= M):
        answer = s

print(answer)