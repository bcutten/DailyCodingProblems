#b cutten
#may 21, 2019
'''
This problem was asked by Facebook.

Given a array of numbers representing the stock prices of a company in 
chronological order, write a function that calculates the maximum profit 
you could have made from buying and selling that stock once. You must 
buy before you can sell it.

For example, given [9, 11, 8, 5, 7, 10], you should return 5, since
you could buy the stock at 5 dollars and sell it at 10 dollars.
'''

prices = [9, 11, 8, 5, 7, 10]

max_profit = -1 

#loop through each price in the list
for buy in range(len(prices)):
    #check the remaining prices in the list, starting from this one
    for sell in range(buy, len(prices)):
        #check if this is the best time to sell 
        if prices[sell] - prices[buy] > max_profit:
            max_profit = prices[sell] - prices[buy]
            
print(max_profit)