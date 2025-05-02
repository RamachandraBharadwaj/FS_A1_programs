// Program to implement Disjoint Set Data Structure.

/*
5 = number of friends
3 = number of relationships
2 = number of friendship check
input=5
3
0 2
4 2
3 1
2
4 0
1 0
output=4 is a friend of 0
1 is not a friend of 0

*/
import java.io.*;
import java.util.*;

class DisjointUnionSets {
	int[] rank, parent;
	int n;

	public DisjointUnionSets(int n){
		rank = new int[n];
		parent = new int[n];
		this.n = n;
		makeSet();
	}
	// Creates n sets with single item in each
	void makeSet(){
	    for(int i=0;i<n;i++)
	    {
	        parent[i]=i;
	    }
		
	}

	// Returns representative of x's set
	int find(int x){
	    if(parent[x]!=x)
	    {
	        parent[x]= find(parent[x]);
	    }
	    return x;
	}

	// Unites the set that includes x and the set that includes x
	void union(int x, int y){
	    int rootx= find(x);
	    int rooty= find(y);
	    
	    if(rank[rootx]>rank[rooty])
	    {
	        parent[y]=x;
	    }
	    else if(rank[rooty]>rank[rootx])
	    {
	        parent[x]=y;
	    }
	    else
	    {
	        parent[x]=y;
	        rank[rooty]+=1;
	    }
	
	}
}

class test {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int r=sc.nextInt();
		DisjointUnionSets dus= new DisjointUnionSets(n);
		
		for(int i=0;i<r;i++)
		{
		    int a =sc.nextInt();
		    int b=sc.nextInt();
		    
		    dus.union(a,b);
		}
		int fc=sc.nextInt();
		
		//System.out.println("rank : "+Arrays.toString(dus.rank));
		//System.out.println("parent : "+Arrays.toString(dus.parent));
		
		for(int j=0;j<fc;j++)
		{
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    
		    int par1=dus.parent[a];
		    int par2=dus.parent[b];
		    //System.out.println(par1+" --- "+par2);
		    
		    if(par1==par2)
		    {
		        System.out.println(a+" is a friend of "+b);
		    }
		    else
		    {
		        System.out.println(a+" is not a friend of "+b);
		    }
		}
		
	}
}
