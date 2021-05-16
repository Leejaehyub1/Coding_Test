#List 정리.


#Stack
stack = []

stack.append('a')   #push 대신 append를 사용한다.
stack.append('b')
stack.append('c')
stack.pop(-1)   #pop(), pop(-1) 똑같음. -> c가 나옴
stack.pop(0)    #첫번째 원소 pop (Queue 에서 사용) -> a가 나옴





#append와 extend의 차이점.
#extend는 iterable한 모든 항목을 넣는다.
x = ['a', 'b', 'c']
y = ['d', 'e']
x.append(y)
print(x) #['a', 'b', 'c', ['d', 'e']]

x = ['a', 'b', 'c']
y = ['d', 'e']
x.extend(y)
print(x) #['a', 'b', 'c', 'd', 'e']

#만약 문자열이면?
x = ['aaa', 'bbb', 'ccc']
y = 'def'
x.extend(y)
print(x) #['aaa', 'bbb', 'ccc', 'd', 'e', 'f']
