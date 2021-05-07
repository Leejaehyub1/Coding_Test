#String 정리.


#split 함수는 한번만 사용하면 알아서 배열로 저장된다.
A = "Enter uuid1234 Muzi"
b = A.split(' ')
# b = ["Enter", "uuid1234", "Muzi"]



#Format 함수
a = 30
b = "abcd"
s = 'Example number is {}, Example String is {}'.format(a,b)
s = 'Example number is {0}, Example String is {1}'.format(a,b)

#진짜 중괄호를 프린트하고 싶을 때는 이중괄호
s = 'Example number is {{}}, Example String is {{}}'.format(a,b)

# 간격을 맞추고 싶을 때
s = 'this is {0:<10} | done {1:<5} |'.format('left', 'a')
s = 'this is {0:>10} | done {1:>5} |'.format('right', 'b')
s = 'this is {0:^10} | done {1:^5} |'.format('center', 'c')
# this is left       | done a    |
# this is      right | done    b |
# this is   center   | done  c   |

# 공백 대신 특정 문자를 넣고 싶을 때
s = 'this is {0:-<10} | done {1:<5} |'.format('left', 'a')
s = 'this is {0:+>10} | done {1:>5} |'.format('right', 'b')
s = 'this is {0:*^10} | done {1:^5} |'.format('center', 'c')
# this is left------ | done a    |
# this is +++++right | done    b |
# this is **center** | done  c   |


# 자리수와 소수점 표현하기
s1 = '정수 3자리 : {0:03d, {1:03d}'.format(12345,12)
# print(s1)
# 12345, 012

s2 = '아래 2자리 : {0:0.2f, {1:0.5f}'.format(123.1234567, 3.14)
#123.12, 3.14000

# %s 사용 가능
a = 30
b = "abcd"
s = 'Example number is %d, Example String is %s'%(a,b)





