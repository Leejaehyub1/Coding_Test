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

# N=6, 6C3
#combi_half = [(0,1,2),(0,1,3) ]

for combi in combi_half:
    team_not = [i for i in range(N)] # 0 ~ 5
    for c in combi:
        team_not.remove(c)
    # team_not은 combi에 없는 애들
    #combi_1은 combi(크기가 3)에서 선택된 애들 끼리 choose 2(3choose 2) 해서 sum을 구한다

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

print(minimum)