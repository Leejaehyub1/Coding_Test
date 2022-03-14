def permutation(arr, r):
    for i in range(len(arr)):
        if r==1:
            yield [arr[i]]
        else:
            for next in permutation(arr[:i]+arr[i+1:], r-1):
                yield [arr[i]]+next

def combination(arr,r):
    for i in range(len(arr)):
        if r==1:
            yield [arr[i]]
        else:
            for next in combination(arr[i+1:], r-1):
                yield [arr[i]]+next

def permutation2(arr,r):
    for i in range(len(arr)):
        if r==1:
            yield [arr[i]]
        else:
            for next in permutation2(arr,r-1):
                yield [arr[i]] + next

def combination2(arr,r):
    for i in range(len(arr)):
        if r==1:
            yield [arr[i]]
        else:
            for next in combination2(arr[i:], r-1):
                yield [arr[i]] + next


n=0
r,c = 0, -1
size=5
step = 1
while True:
    for _ in range(size):
        n += 1
        c += step
        arr[r][c] = n
    size -= 1
    if size<1:
        break
    for _ in range(size):
        n += 1
        r += step
        arr[r][c] = n
    size = -size

