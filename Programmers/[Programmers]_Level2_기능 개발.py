# def solution(progresses, speeds):
#     answer = []
#     for i in range(len(progresses)):
#         progresses[i] = 100 - progresses[i]
#         if (progresses[i] % speeds[i]):
#             progresses[i] = (progresses[i] // speeds[i]) + 1
#         else:
#             progresses[i] = (progresses[i] // speeds[i])
#
#     while (len(progresses) != 0):
#         num = 1
#         temp = progresses.pop(0)
#         while (len(progresses) != 0 and progresses[0] <= temp):
#             num += 1
#             progresses.pop(0)
#
#         answer.append(num)
#
#     return answer

a = list(map(int, input().split()))
a.sort()

min = 10000000
def averge(a):
    sum = 0
    for i in a:
        sum+= i
    return sum//len(a)

min = 1000000
for i in range(1, len(a)):
    b = a[:i]
    c = a[i:]
    avg_b = averge(b)
    avg_c = averge(c)
    sum = 0
    for k in b:
        sum += abs(avg_b-k)
    for k in c:
        sum += abs(avg_c-k)
    if sum < min:
        min = sum


print(min)


