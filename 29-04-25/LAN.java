// In your computer lab, network switches are connected using Ethernet cables to form a LAN. 
// However, a new hardware technician inadvertently connected switches in a way that created a cycle,
// resulting in a network loop. 
// As a consequence, the network has become unstable. You need to identify and remove the specific cable that 
// is causing the loop. 
// If there are multiple cables contributing to the loop, you should remove the one that was most recently added

// Sample Input-1:
// ---------------
// 3
// 0 1
// 0 2
// 1 2

// Sample Output-1:
// ----------------
// [1 2]

// Sample Input-2:
// ---------------
// 5
// 0 1
// 1 2
// 2 3
// 0 3
// 0 4

// Sample Output-2:
// ----------------
// [0,3]
 

// Constraints:
// ------------
// -> n == edges.length
// -> 3 <= n <= 1000
// -> edges[i].length == 2
// -> 1 <= ai < bi <= edges.length
// -> ai != bi
// -> There are no repeated edges.
// -> The given graph is connected.

import java.util.*;

class LAN
{
    static int[]parent;
    
    public static int find(int x)
    {
        int par;
        if(parent[x]!=x)
        {
            par=find(parent[x]);
        }
        else
        {
            par=x;
        }
        
        return par;
    }
    
    public static boolean union(int a , int b)
    {
        int par1=find(a);
        int par2=find(b);
        
        if(par1==par2){return false;}
        parent[par2]=par1;
        
        return true;
    }
    
    public static int[] repeats(int[][]edges)
    {
        int n=edges.length;
        parent= new int[edges.length];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }
        
        for(int i=0;i<n;i++)
        {
            int[]p=edges[i];
            if(!union(p[0],p[1]))
            {
                return p;
            }
        }
        
        return new int[]{0,0};
        
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[][]edges= new int[n][2];
        
        for(int i=0;i<n;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            
            edges[i]=new int[]{a,b};
        }
        
        int[] pairz=repeats(edges);
        System.out.println(Arrays.toString(pairz));
    }
}