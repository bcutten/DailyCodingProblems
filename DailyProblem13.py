'''
This problem was asked by Amazon.

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".

B Cutten
April 16, 2019
'''

s = input() #the string to check
k = int(input()) # the numnber of distinct characters allowed

sub = "" #the cuurent substring being built
long_sub = 0 #the longest substring with k characters built so far
limit = 0 #the number of distinct characters 
for i in range(len(s)): #for each character, starting with the first
    sub = "" #start with empty substring
    limit = 0 #reset limit
    rem = s[i:] # make a new string, from i to the end of the String 
    print(rem)
    for c in rem:#loop through each character in the new string
        print(sub)
        if c in sub: #if the letter is already in the substring then just add it
            sub += c
            #check if this is the longest substring so far
            if len(sub) > long_sub:
                long_sub = len(sub)            
        elif not c in sub and limit < k: #it's not already there, but we're still under the limit
            sub += c #add the character
            limit += 1 #add to the limit count
            #check if this is the longest substring so far
            if len(sub) > long_sub:
                long_sub = len(sub)            
        else:

            #the character is not already in the string and we cant add any more without going over the limit so...           
            #reset the substring!
            sub = ""
            #reset the limit!
            limit = 0

print(long_sub)