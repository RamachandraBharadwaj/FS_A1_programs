// Viraj Aanand is a wedding planner, He ordered his assistant to decorate a wall.
// The decorator plans to decorate the wall with two different colored balloons.
// The wall size is M*N, The decorator can decorate the wall using M*N balloons
// the balloons are blue or white in color.

// Blue colored ballons represented with digit-1 and 
// White colored ballons represented with digit-0.

// The blue colored balloons forms different shapes, that are connected 4 directonally.
// The directons are upwards, downwards, left, and right. Viraj Aanand got an idea to 
// count the unique shapes formed by blue colored ballons.

// You will be given the decorated wall as a matrix wall[][].
// Your task is to help, Viraj Aanand to count the unique shapes.

// Input Format:
// -------------
// Line-1: Two space separated integers M and N, size of the wall.
// Next M lines: N space separated integers, either 0 or 1.

// Output Format:
// --------------
// Print an integer, Number of distinct shapes formed by blue balloons.


// Sample Input-1:
// ---------------
// 4 5
// 1 1 0 0 0
// 1 1 0 0 0
// 0 0 0 1 1
// 0 0 0 1 1

// Sample Output-1:
// ----------------
// 1


// Sample Input-2:
// ---------------
// 5 5
// 1 1 0 1 1
// 1 0 0 0 1
// 0 0 0 0 0
// 1 0 0 0 1
// 1 1 0 1 1

// Sample Output-2:
// ----------------
// 4

import java.util.*;
class DistinctShapes
{
    public static String BFS(int[][] arr, int x, int y)
    {
        int base[]= new int[]{x,y};
        Queue<int[]> q = new LinkedList<>();
        q.add(base);
        String cords="";
        
        int[][]pairs=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        
        while(!q.isEmpty())
        {
            int[] pair=q.poll();
            int now_x=pair[0];
            int now_y=pair[1];
            
            //System.out.println(Arrays.toString(pair));
            
            cords+=new String((pair[0]-x)+""+(pair[1]-y));
            arr[now_x][now_y]=0;
            
            for(int[] par : pairs)
            {
                int nx=now_x+par[0];
                int ny=now_y+par[1];
                
                if(nx>=0 && nx<arr.length && ny>=0 && ny<arr[0].length && arr[nx][ny]!=0)
                {
                    q.add(new int[]{nx,ny});
                }
            }
        }
        //System.out.println(cords+" for "+x+" "+y);
        return cords;
        
    }
    public static int shapey(int[][] arr)
    {
        Set<String> se = new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j]==1)
                {
                    String fino=BFS(arr,i,j);
                    se.add(fino);
                }
            }
        }
        //System.out.println(se);
        return se.size();
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
        
        System.out.println(shapey(arr));
        
    }
}