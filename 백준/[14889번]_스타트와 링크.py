import sys
import itertools

N = int(input())
A = []
total_sum = 0
for _ in range(N):
    temp = list(map(int, input().split()))
    total_sum += sum(temp)
    A.append(temp)


half_num = N//2
temp = [i for i in range(N)]
combi_half =  list(itertools.combinations(temp, half_num))

minimum = 36101
# for a in A:
#     print(*a)

for combi in combi_half:
    # print(combi)
    team_not = [i for i in range(N)]
    # print(team_not)
    for c in combi:
        # print(c)
        team_not.remove(c)

    combi_1 = list(itertools.combinations(combi, 2))
    sum1 = 0
    for c in combi_1:
        # print(c)
        sum1 += (A[c[0]][c[1]] + A[c[1]][c[0]])

    combi_2 = list(itertools.combinations(team_not, 2))
    sum2 = 0
    for c in combi_2:
        # print(c)
        sum2 += (A[c[0]][c[1]] + A[c[1]][c[0]])

    diff = abs(sum1 - sum2)
    if diff < minimum:
        minimum = diff
    # print()


# print("ans")
print(minimum)