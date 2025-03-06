// You are given an m x n grid where each cell can have one of three values:
// -> 0 representing an empty cell,
// -> 1 representing a fresh orange, or
// -> 2 representing a rotten orange.

// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. 
// If this is impossible, return -1.


// Input Format:
// -------------
// Line-1: Two integers, m and n, represents grid[] sizes
// Line-2 to m: n Space separated integers, represents grid[i][j]

// Output Format:
// --------------
// Line-1: An integer

// Sample Input-1:
// ---------------
// 3 3
// 2 1 1
// 1 1 0
// 0 1 1

// Sample Output-1:
// ----------------
// 4

// Sample Input-2:
// ---------------
// 3 3
// 2 1 1
// 0 1 1
// 1 0 1

// Sample Output-2:
// ----------------
// -1

// Explanation: 
// -------------
// The orange in the bottom left corner (row 2, column 0) is never rotten, 
// because rotting only happens 4-directionally.

// Sample Input-3:
// ---------------
// 1 1
// 0 2

// Sample Output-3:
// ----------------
// 0

// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 
// Constraints:
// ------------
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] is 0, 1, or 2.

import java.util.*;
class RottingOranges
{
    
    public static int BFS(int[][]arr, Queue<int[]> q, int ones)
    {
        
        int[][]dirs= new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        
        while(!q.isEmpty())
        {
            int[] paris=q.poll();
            int x=paris[0];
            int y=paris[1];
            System.out.println(paris[0]+" "+paris[1]+" "+paris[2]);
            
            arr[x][y]=2;
            ones--;
            
            if(ones==0)
            {
                return paris[2];
            }
            for(int[] dir : dirs)
            {
                int nx=x+dir[0];
                int ny=y+dir[1];
                
                if(nx>=0 && nx<arr.length && ny>=0 && ny<arr[0].length && arr[nx][ny]==1)
                {
                    System.out.println("nx : "+nx+" ny : "+ny+" "+paris[2]+1);
                    q.add(new int[]{nx,ny,paris[2]+1});
                }
            }
        }
        
        return -1;
        
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        
        int arr[][]= new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        int ones=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j]=sc.nextInt();
                if(arr[i][j]==2)
                {
                    q.add(new int[]{i,j,0});
                }
                if(arr[i][j]==1)
                {
                    ones++;
                }
            }
        }
        //System.out.println("ones : "+ones);
        if(ones==0)
        {
            System.out.println(0);
        }
        else
        {
            System.out.println(BFS(arr,q,ones));
        }
    }
}