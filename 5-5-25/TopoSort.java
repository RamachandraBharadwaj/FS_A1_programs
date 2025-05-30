/* A Java program to print topological sorting of a graph using indegrees

Sample Input=1:
---------------
6 //no of vertices
6 //no of edges
5 2
5 0
4 0
4 1
2 3
3 1

Sample Output-1:
----------------
4 5 2 0 3 1

Sample Input-2:
---------------
5
5
4 0
4 1
2 3
3 1
2 0

Sample Output-2:
----------------
2 4 3 0 1

*/

import java.util.*;

// Class to represent a graph
class Graph 
{
	// No. of vertices
	int V;

	// An Array of List which contains references to the Adjacency List of each vertex
	List<Integer> adj[];
	// Constructor
	public Graph(int V)
	{
		this.V = V;
		adj = new ArrayList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new ArrayList<Integer>();
	}

	// Function to add an edge to graph
	public void addEdge(int u, int v)
	{
		adj[u].add(v);
	}

	public void topologicalSort()
	{
		//Write your code here and print the vertices order after sorting
		Queue<Integer> q = new LinkedList<>();
		int[] indegree= new int[V];
		for(int i=0;i<V;i++)
		{
		    for(int x : adj[i])
		    {
		        indegree[x]+=1;
		    }
		}
		//System.out.println(Arrays.toString(indegree));
		boolean [] visited=new boolean[V];
		
		for(int i=0;i<indegree.length;i++)
		{
		    if(indegree[i]==0)
		    {
		        q.add(i);
		        visited[i]=true;
		    }
		}
		
		ArrayList<Integer> tops= new ArrayList<>();
		int cnt=0;
		
		while(!q.isEmpty())
		{
		    int x =q.poll();
		    System.out.println("x : "+x);
		    //visited[x]=true;
		    tops.add(x);
		    
		    for(int y : adj[x])
		    {
		        indegree[y]-=1;
		    }
		    
		    for(int i=0;i<indegree.length;i++)
		    {
		        if(!visited[i] && indegree[i]==0)
		        {
		            q.add(i);
		            visited[i]=true;
		        }
		    }
		    cnt+=1;
		}
		
		if(cnt!=V)
		{
		    System.out.println(-1);
		}
		else
		{
    		for(int x : tops)
    		{
    		    System.out.print(x+" ");
    		}
		}
	}
}

class test 
{
	public static void main(String args[])
	{
		// Create a graph 
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Graph g = new Graph(n);
        int e=sc.nextInt();
		for(int i=0;i<e;i++){
			int e1=sc.nextInt();
			int e2=sc.nextInt();
			g.addEdge(e1,e2);
		}

		//System.out.println("Following is a Topological Sort");
		g.topologicalSort();
	}
}
