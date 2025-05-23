// There are N cities, and M routes[], each route is a path between two cities.
// routes[i] = [city1, city2], there is a travel route between city1 and city2.
// Each city is numbered from 0 to N-1.
 
// There are one or more Regions formed among N cities. 
// A Region is formed in such way that you can travel between any two cities 
// in the region that are connected directly and indirectly.
 
// Your task is to findout the number of regions formed between N cities. 
 
// Input Format:
// -------------
// Line-1: Two space separated integers N and M, number of cities and routes
// Next M lines: Two space separated integers city1, city2.
 
// Output Format:
// --------------
// Print an integer, number of regions formed.
 
 
// Sample Input-1:
// ---------------
// 5 4
// 0 1
// 0 2
// 1 2
// 3 4
 
// Sample Output-1:
// ----------------
// 2
 
 
// Sample Input-2:
// ---------------
// 5 6
// 0 1
// 0 2
// 2 3
// 1 2
// 1 4
// 2 4
 
// Sample Output-2:
// ----------------
// 1

import java.util.*;

class ConnectedComponents 
{
    
    public void union(int[] parent, int x, int y)
    {
        int px=findParent(parent,x);
        int py=findParent(parent,y);
        
        if(px<py)
        {
            parent[y]=x;
            return;
        }
        
        if(py<px)
        {
            parent[x]=y;
            return;
        }
    }
    public int countComponents(int n, int[][] edges) 
	{
        //Write your code here and retun number of components
        
        int c=n;
        int[]parent=new int[n+1];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }
        
        for(int [] e : edges)
        {
            int par1=findParent(parent,e[0]);
            int par2=findParent(parent,e[1]);
            
            if(par1!=par2)
            {
                union(parent,par1,par2);
                c--;
            }
        }
        return c;
    }

    private int findParent(int[] parent, int i) 
	{
        if (i == parent[i]) return i;
        return parent[i] = findParent(parent, parent[i]); // Path compression
    }
	
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int e=sc.nextInt();
		int edges[][]=new int[e][2]; 
		for(int i=0;i<e;i++)
			for(int j=0;j<2;j++)
				edges[i][j]=sc.nextInt();

		System.out.println(new ConnectedComponents().countComponents(n,edges));
	}	
}