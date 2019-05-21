#b cutten
#may 21, 2019
'''
This problem was asked by Amazon.

Given a string, find the longest palindromic contiguous substring. 
If there are more than one with the maximum length, return any one.

For example, the longest palindromic substring of "aabcdcb" is "bcdcb". 
The longest palindromic substring of "bananas" is "anana".
'''

#a recursive function which checks if a string is a palindrome
def is_palindrome(s):    
    if len(s) == 0 or len(s) == 1:
        return True
    elif s[0] != s[len(s) -1]:
        return False
    else:
        return is_palindrome(s[1:len(s)-1])
    
word = "aabcdcb"
max_length = 0
longest_palindromic_substring = ""

#need nested loops to check all possible substring lengths
for start in range(len(word)):
    for end in range(start, len(word)):
        #slice the word up into a sub string
        sub_word = word[start:end + 1]
        #check if it's longer than the current longest, and also a palindrome
        if len(sub_word) > max_length and is_palindrome(sub_word):
            #save these values
            max_length = len(sub_word)
            longest_palindromic_substring = sub_word
print(longest_palindromic_substring)

