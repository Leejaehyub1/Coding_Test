#List 정리.


#Stack
stack = []

stack.append('a')   #push 대신 append를 사용한다.
stack.append('b')
stack.append('c')
stack.pop(-1)   #pop(), pop(-1) 똑같음. -> c가 나옴
stack.pop(0)    #첫번째 원소 pop (Queue 에서 사용) -> a가 나옴
