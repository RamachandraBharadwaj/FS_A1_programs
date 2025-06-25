// You are controlling a battlefield represented by an m x n grid. 
// Each cell on this grid can be one of the following:

// - A reinforced barrier ('B'), blocking your laser.
// - An enemy drone ('D'), your target.
// - An open cell ('0'), where you can position your robot to fire.

// When your robot fires its powerful laser from an open cell, 
// the beam destroys all enemy drones in the same row and column 
// until the beam hits a barrier ('B'). The barrier completely stops 
// the laser, protecting anything behind it.

// Your goal is to identify the best position (open cell) to place 
// your robot so that firing the laser destroys the maximum number 
// of enemy drones in a single shot. Return this maximum number.

// Input format:
// -------------
// Line 1: Two space separated integers, represents m & n
// Next M lines: each row of battlefield


// Output format:
// --------------
// An integer, maximum number of enemy drones destroyed in a single shot.

// Sample Input-1:
// ---------------
// 3 4
// 0 D 0 0
// D 0 B D
// 0 D 0 0

// Sample Output-1:
// ----------------
// 3

// Explanation: placing robot at battlefield[1][1] destroys 3 enemy drones in a single shot.

// Sample Input-2:
// ---------------
// 3 3
// B B B
// 0 0 0
// D D D

// Sample Output-2:
// ----------------
// 1


// Constraints:
// - 1 <= m, n <= 500
// - battlefield[i][j] is either 'B', 'D', or '0'.

import java.util.*;
class BattleField
{

    public static int helper(char[][] arr)
    {
        int m=arr.length;
        int n=arr[0].length;
        
        int max=0;
        int rowHits=0;
        int[]colHits=new int[n];
        
        for(int i=0;i<arr.length;i++)
        {
            rowHits=0;
            for(int j=0;j<arr[0].length;j++)
            {
                if(j==0 || arr[i][j-1]=='B')
                {
                    rowHits=0;
                    for(int k=j;k<n && arr[i][k]!='B';k++)
                    {
                        if(arr[i][k]=='D')rowHits++;
                    }
                }
                if(i==0 || arr[i-1][j]=='B')
                {
                    colHits[j]=0;
                    for(int k=i;k<m && arr[k][j]!='B';k++)
                    {
                        if(arr[k][j]=='D')colHits[j]++;
                    }
                }
                if(arr[i][j]=='0')
                {
                    max=Math.max(max,rowHits+colHits[j]);
                }
            }
        }
        return max;
    }
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        
        sc.nextLine();
        
        char[][] arr= new char[m][n];
        for(int i=0;i<m;i++)
        {
            String x=sc.nextLine();
            arr[i]=x.toCharArray();
        }
        System.out.println(helper(arr));
        
    }
}