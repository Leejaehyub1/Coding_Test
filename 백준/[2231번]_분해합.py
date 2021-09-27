n = int(input())
ans = 0
def sol(n):
    for num in range(1, n-1):
        num_str = str(num)
        num_int = num
        for s in num_str:
            num_int += int(s)

        if num_int == n:
            return num
    return 0

print(sol(n))