def solution(n, times):
    right = n * max(times)
    left = 1
    answer = 0
    while (left <= right):
        mid = (right + left) // 2
        temp = 0
        for t in times:
            temp += mid // t

        if (n <= temp):
            right = mid - 1

        else:
            left = mid + 1

    return left