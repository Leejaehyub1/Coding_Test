def solution(s):
    answer = []

    count = 0
    zero_num = 0

    while len(s) != 1:

        while '0' in s:
            s = s.replace('0', '', 1)
            zero_num += 1

        s = bin(len(s))[2:]
        count += 1

    return [count, zero_num]