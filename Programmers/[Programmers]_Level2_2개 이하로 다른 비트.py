def solution(numbers):
    answer = []
    for num in numbers:
        temp = bin(num)[2:]
        i = temp.rfind('0')
        temp = list(temp)
        if i == -1:
            temp[0] = '0'
            temp.insert(0, '1')

        elif i == len(temp) - 1:
            temp[i] = '1'

        else:
            temp[i], temp[i + 1] = '1', '0'

        temp = ''.join(temp)
        temp = '0b' + temp
        ans = int(temp, 2)
        answer.append(ans)
    return answer