// GridFlow Technologies is developing a path optimization tool for data transmission in a grid-based communication network, 
// represented as an N × N square matrix of integers. 
// Each cell contains a numeric value, and the goal is to find the longest "snake sequence" within the grid. 
// A snake sequence is a path of numbers where each subsequent number 
// is located either to the right or down of the current number and differs from it by exactly + or - 1. 
// The task is to compute the maximum length of such a snake sequence and outputs one valid sequence.

// Constraints:
// ------------
// 1 ≤ N ≤ 100 (matrix dimension)
// -1000 ≤ Matrix[i][j] ≤ 1000 (value in each cell)
// At least one snake sequence exists in the matrix.

// Input Format:
// --------------
// Line-1: An integer: N (size of the square matrix).
// Line-2 to N: The next N lines each contain N integers, representing the values in the matrix.

// Output Format:
// ---------------
// Line-1: Maximum length number. If maximum length not exists then write 0.

// Sample Input-1:
// ---------------
// 3
// 1 3 5
// 7 9 11
// 13 15 17

// Sample Output-1:
// ----------------
// 0

// Explanation:
// -------------
// No two adjacent elements differ by + or - 1.

// Sample Input-2:
// ---------------
// 5
// 7 5 2 3 1
// 3 4 1 4 4
// 1 5 6 7 8
// 3 4 5 8 9
// 3 2 2 7 6

// Sample Output-2:
// ----------------
// 7

// Explanation:
// ----------------
// The 5 × 5 matrix contains several snake sequences. One maximum length snake sequence is:
// - Start at (0,1): 5
// - Move down to (1,1): 4 (5-1)
// - Move down to (2,1): 5 (4+1)
// - Move right to (2,2): 6 (5+1)
// - Move right to (2,3): 7 (6+1)
// - Move right to (2,4): 8 (7+1)
// - Move down to (3,4): 9 (8+1, invalid, but check down to (3,3))
// - From (2,3): 7, move down to (3,3): 8 (7+1)
// - Move down to (4,3): 7 (8-1)
// This sequence (5 → 4 → 5 → 6 → 7 → 8 → 7) has a length of 7 and satisfies the + or - 1 constraint for each step, moving only right or down.

import java.util.*;
class SnakeSequence
{
    public static int backer(int[][]arr, int i, int j, int c)
    {
        if(i>=arr.length || i<0 || j>=arr[0].length || j<0 )
        {
            return 0;
        }
        int val=arr[i][j];
        //c+=1;
        
        int t1=0;
        int t2=0;
        if(i<arr.length-1 && ((arr[i+1][j]==val-1)||(arr[i+1][j]==val+1)))
        {
            t1=1+backer(arr,i+1,j,c);
        }
        if(j<arr[0].length-1 && ((arr[i][j+1]==val-1)||(arr[i][j+1]==val+1)))
        {
            t2=1+backer(arr,i,j+1,c);
        }
        
        c=Math.max(t1,t2);
        return c;
    }
    public static int helper(int[][]arr)
    {
        int maxi=0;
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int x= backer(arr,i,j,0);
                
                if(x==1)
                {
                    continue;
                }
                maxi=Math.max(maxi,x);
            }
        }
        return maxi;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[][]arr= new int[n][n];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(helper(arr));
    }
}