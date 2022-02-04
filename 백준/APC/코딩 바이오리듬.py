import sys
birth = sys.stdin.readline().rstrip()
N = int(input())
person = []
for b in birth:
    person.append(int(b))

temp = (sys.stdin.readline().rstrip())
arr = []
for t in temp:
    arr.append(int(t))

year_sum = 0
month_sum = 0
day_sum = 0
for i in range(4):
    year_sum += (person[i]-arr[i])**2

for i in range(2):
    month_sum += (person[i+4]-arr[i+4])**2
    day_sum += (person[i+6]-arr[i+6])**2

max = year_sum * month_sum * day_sum
ans = int(temp)
multi = 0
for _ in range(N-1):
    year_sum = 0
    month_sum = 0
    day_sum = 0
    temp = (sys.stdin.readline().rstrip())
    arr = []
    for t in temp:
        arr.append(int(t))

    for i in range(4):
        year_sum += (person[i] - arr[i]) ** 2

    for i in range(2):
        month_sum += (person[i + 4] - arr[i + 4]) ** 2
        day_sum += (person[i + 6] - arr[i + 6]) ** 2

    multi = year_sum * month_sum * day_sum
    if max < multi:
        max = multi
        ans = int(temp)

    elif max == multi:
        if ans > int(temp):
            max = multi
            ans = int(temp)


print(str(ans))



