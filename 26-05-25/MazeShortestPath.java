// You are given a maze represented by a binary matrix of size R × C, where each cell contains either 1 (open) or 0 (blocked).

// You must find the length of the shortest path from a given source cell to a given destination cell. 
// You may move one step at a time in any of the four cardinal directions (up, down, left, right), and you may only traverse cells with value 1. 

// If no valid path exists, return -1.

// Input Format:
// --------------
// Line-1: Two space-separated integers, represents R, C
// Next R lines: Each line contains C space-separated integers 0 or 1, describing one row of the maze.
// Next line: Two space-separated integers, represents (sr, sc), zero-based coordinates of the source cell.
// Next line: Two space-separated integers,represents (dr, dc), zero-based coordinates of the destination cell.

// It is guaranteed that 0 ≤ sr, dr < R and 0 ≤ sc, dc < C, and that both the source and destination cells contain 1.

// Output Format:
// --------------
// Line-1: A single integer, the length of the shortest path (number of steps) from the source to the destination, or -1 if no such path exists.


// Sample Input-1:
// ---------------
// 10 10
// 1 1 1 1 1 0 0 1 1 1
// 0 0 1 0 1 1 0 1 0 1
// 0 0 1 0 1 1 1 0 0 1
// 1 0 1 1 1 0 1 1 0 1
// 0 0 0 1 0 0 0 1 0 1
// 1 0 1 1 1 0 0 1 1 0
// 0 0 0 0 1 0 0 1 0 1
// 0 1 1 1 1 1 1 1 0 0
// 1 1 1 1 1 0 0 1 1 1
// 0 0 1 0 0 1 1 0 0 1
// 0 0
// 5 7

// Sample Output-1:
// ----------------
// 12

// Explanation: 
// ------------
// The shortest path from (0, 0) to (5, 7) has length 12. The shortest path is marked below with x.

// [
// 	[x, x, x, x, x, 0, 0, 1, 1, 1],
// 	[0, 0, 1, 0, x, 1, 0, 1, 0, 1],
// 	[0, 0, 1, 0, x, x, x, 0, 0, 1],
// 	[1, 0, 1, 1, 1, 0, x, x, 0, 1],
// 	[0, 0, 0, 1, 0, 0, 0, x, 0, 1],
// 	[1, 0, 1, 1, 1, 0, 0, x, 1, 0],
// 	[0, 0, 0, 0, 1, 0, 0, 1, 0, 1],
// 	[0, 1, 1, 1, 1, 1, 1, 1, 0, 0],
// 	[1, 1, 1, 1, 1, 0, 0, 1, 1, 1],
// 	[0, 0, 1, 0, 0, 1, 1, 0, 0, 1]
// ]

import java.util.*;
class short_path_maze
{
    static int mino=Integer.MAX_VALUE;
    
    public static void backtrack(int[][]arr,int[]dest, int i, int j,int dis)
    {
        if(i>=arr.length || i<0 || j>=arr[0].length || j<0 || arr[i][j]==0)
        {
            return;
        }
        if(dest[0]==i && dest[1]==j)
        {
            mino=Math.min(mino,dis);
            return;
        }
        
        arr[i][j]=0;
        
        backtrack(arr,dest,i+1,j,dis+1);
        backtrack(arr,dest,i,j+1,dis+1);
        backtrack(arr,dest,i-1,j,dis+1);
        backtrack(arr,dest,i,j-1,dis+1);
        
        arr[i][j]=1;
        
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        
        int[][]arr= new int[m][n];
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        int[]src=new int[2];
        int[]dest=new int[2];
        
        
        for(int i=0;i<2;i++)
        {
            src[i]=sc.nextInt();
        }
        
        for(int j=0;j<2;j++)
        {
            dest[j]=sc.nextInt();
        }
        
        //arr[src[0]]
        backtrack(arr,dest,src[0],src[1],0);
        if(mino!=Integer.MAX_VALUE)
        {
            System.out.println(mino);
        }
        else
        {
            System.out.println(-1);
        }
        

        
    }
}