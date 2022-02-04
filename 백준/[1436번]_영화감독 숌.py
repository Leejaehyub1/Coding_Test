N = int(input())

def sol(N):
    count = 0
    num = 665
    while(count < N):
        num += 1
        num_str = str(num)
        if num_str.count('666') >= 1:
            count += 1
    print(num)

sol(N)
