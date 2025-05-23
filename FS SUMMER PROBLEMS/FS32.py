# A financial analytics platform is monitoring short-term stock price changes 
# to identify patterns of investor sentiment. 

# Each price movement is recorded as an integer:
# A positive number means the price increased (bullish sentiment).
# A negative number means the price decreased (bearish sentiment).

# Analysts are interested in finding the longest continuous period where stock sentiment alternates
# —i.e., gains are followed by losses and vice versa—without interruption. 
# This helps flag volatile periods for closer examination.

# Your task is to identify the longest contiguous subarray of alternating stock price changes. 
# The pattern must be strictly alternating in sign, and the subarray must occupy consecutive positions in the original array.


# Constraints:
# --------------
# 2 ≤ N ≤ 100,000 (length of the array).
# All values are non-zero integers.
# At least one alternating pair exists in the array.

# Input Format:
# -------------
# Line-1: An integer N: number of price changes.
# Line-2: N space-separated integers representing changes.

# Output Format:
# ---------------
# Line-1: List of sub array elements

# Sample Input-1:
# ---------------
# 9  
# -5 6 -3 2 -1 4 4 -6 7

# Sample Output-1:
# -----------------
# [-5, 6, -3, 2, -1, 4]


# Explanation:
# -------------
# The subarray [-5, 6, -3, 2, -1, 4] alternates in sign and is the longest such sequence. 
# The sequence ends when the next element 4 repeats the positive sign.


# Sample Input-2:
# -------------
# 5
# -5 -4 -3 -2 -1

# Sample Output-2:
# ----------------
# [-5]
n=int(input())
lis=list(map(int,input().split(" ")))


curr_len=1
maxi=1

curr_start=0
max_start=0

for i in range(1,n):
    if(lis[i]*lis[i-1]<0):
        curr_len+=1
    else:
        #maxi=max(cur_len,maxi)
        if(curr_len>maxi):
            maxi=curr_len
            max_start=curr_start
            
        curr_len=1
        curr_start=i
        
if curr_len>maxi:
    maxi=curr_len
    max_start=curr_start
        
        
print(lis[max_start:max_start+maxi])