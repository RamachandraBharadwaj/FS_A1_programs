# You are navigating a spaceship through a galaxy represented as an m x n space 
# map.The spaceship starts from the top-left sector (sector[0][0]) and its 
# mission is to safely reach the bottom-right sector (sector[m-1][n-1]).

# Each sector on the map can either be clear (0) or blocked by an 
# asteroid field (1).  
# The spaceship can only move right or downward at any moment.  
# It cannot pass through sectors with asteroid fields.

# Return the total number of distinct safe routes the spaceship can take to 
# reach its destination at the bottom-right corner.


# Input format:
# -------------
# 2 space seperated integers, m & n
# next m lines of representing the sector 

# Output format:
# --------------
# An integer, the total number of distinct safe routes

# Example 1:
# ----------
# Input:
# 3 3
# 0 0 0
# 0 1 0
# 0 0 0

# Output:
# 2

# Explanation:  
# There’s one asteroid field blocking the center of the 3×3 map.  
# Two possible safe navigation paths:
# - Move → Move → Down → Down
# - Down → Down → Move → Move

# Example 2:
# ---------
# Input:
# 2 2
# 0 1
# 0 0

# Output:
# 1


# Constraints:
# - m == sectorMap.length
# - n == sectorMap[i].length
# - 1 <= m, n <= 100
# - sectorMap[i][j] is either 0 (clear) or 1 (asteroid field)

m,n= map(int,input().split(" "))

grid=[]
for i in range(m):
    tem=list(map(int,input().split(" ")))
    grid.append(tem)
    

dp=[[0 for i in range(n)]for j in range(m)]

if(grid[0][0]==0):
    dp[0][0]=1
    
    
for i in range(m):
    for j in range(n):
        if i==0 and j==0:
            continue
        if grid[i][j]==1:
            dp[i][j]=0
        else:
            top=0
            down=0
            if(i>0):
                top=dp[i-1][j]
            if(j>0):
                down=dp[i][j-1]
                
            dp[i][j]=top+down
         
#print(dp)
            
if(grid[0][0]==1):
    print(0)
else:
    print(dp[m-1][n-1])
