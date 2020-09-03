"""
B Cutten
Sept 3, 2020
Trying this with the python
   This problem was asked by Microsoft.

    Let's represent an integer in a linked list format by having each node 
    represent a digit in the number. The nodes make up the number in reversed order.

    For example, the following linked list:

    1 -> 2 -> 3 -> 4 -> 5
    is the number 54321.

    Given two linked lists in this format, return their sum in the same linked list format.

    For example, given

    9 -> 9
    5 -> 2
    return 124 (99 + 25) as:

    4 -> 2 -> 1
"""
#create the initial lists
num1 = [9,9]
num2 = [5,2]

#reverse em
num1.reverse()
num2.reverse()

#convert each list to a String
s_num1 = ""
s_num2 = ""

for num in num1:
    s_num1 = s_num1 + str(num)

for num in num2:
    s_num2 = s_num2 + str(num)

#convert each String to an int so the numbers can be added
total = int(s_num1) + int(s_num2)

# using list comprehension 
# to convert number to list of integers 
#https://www.geeksforgeeks.org/python-convert-number-to-list-of-integers/
total_list = [int(x) for x in str(total)] 

#reverse the sum
total_list.reverse()

print(total_list)