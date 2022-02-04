def solution(progresses, speeds):
    answer = []
    for i in range(len(progresses)):
        progresses[i] = 100 - progresses[i]
        if (progresses[i] % speeds[i]):
            progresses[i] = (progresses[i] // speeds[i]) + 1
        else:
            progresses[i] = (progresses[i] // speeds[i])

    while (len(progresses) != 0):
        num = 1
        temp = progresses.pop(0)
        while (len(progresses) != 0 and progresses[0] <= temp):
            num += 1
            progresses.pop(0)

        answer.append(num)

    return answer