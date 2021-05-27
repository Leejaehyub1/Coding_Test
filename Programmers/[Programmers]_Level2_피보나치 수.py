def solution(n):
    answer = 1
    prev = 0

    for i in range(2, n + 1):
        prev, answer = answer, answer + prev

    return answer % 1234567