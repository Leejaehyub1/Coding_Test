def gcd(x, y):
    while y:
        x, y = y, x % y

    return x


def solution(arr):
    answer = arr[0]
    for i in range(len(arr) - 1):
        answer = answer * arr[i + 1] // gcd(answer, arr[i + 1])
    return answer