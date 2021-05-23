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
s1 = '정수 3자리 : {0:03d}, {1:03d}'.format(12345, 12)
# print(s1)
# 12345, 012

s2 = '아래 2자리 : {0:0.2f}, {1:0.5f}'.format(123.1234567, 3.14)
#123.12, 3.14000

# %s 사용 가능
a = 30
b = "abcd"
s = 'Example number is %d, Example String is %s'%(a,b)




# 문자열을 대문자/소문자로 변경
s1 = 'LeeJaehyub'
s2 = s1.upper()
s3 = s1.lower()
print(s2)   #LEEJAEHYUB
print(s3)   #leejaehyub


# 문자열을 대문자/소문자 확인
# 모든 문자가 대문자인지? 혹은 소문자인지?
s1.isupper()
s1.islower()


# find, rfind, index
# find 함수: "문자열"만 사용 가능. 찾는 문자가 없는 경우 return -1
# rfind 함수: 역순으로 find
# index 함수: 문자열, 리스트, 튜플에서 사용 가능. 찾는 문자가 없으면 Error





#십진법, 이진법 변경

# 문자열 이진법을 십진법 int로 변경하기
a = '1011'
ans = int(a,2)
print(ans)

# 십진법을 이진법으로 변경
a = 5
temp = bin(a)    #0b101
ans = temp[2:]   #101