
// A graduate at University of China (UoC) has to follow certain rules. The rules are as follows:

// UoC offering K subjects, the subjects are indexed from 0 to K-1.
// Some subjets have to follow the conditions, like condition[i]= [Xi, Yi] which specifies you must
// take the subject Yi before the subject Xi.

// You are given total number of subjects and a list of the condition pairs.
// Return the ordering of subjects that a graduate should take to finish all subjects.
// 	- the result set should follow the given order of conditions.
// 	- If it is impossible to complete all subjects, return an empty set.

// Input Format:
// -------------
// Line-1: An integer K, number of subjects.
// Line-2: An integer C, number of conditions.
// Next C lines: Two space separated integers, Xi and Yi.

// Output Format:
// --------------
// Return a list of integers, the ordering of subjects that a graduate should take to finish all subjects


// Sample Input-1:
// ---------------
// 4
// 3
// 1 2
// 3 0
// 0 1

// Sample Output-1:
// ----------------
// [2, 1, 0, 3]

// Explanation-1:
// --------------
// There are a total of 4 courses to take. 
// Subject 1  should be taken after you finished subject 2.
// Subject 3  should be taken after you finished subject 0.
// Subject 0  should be taken after you finished subject 1.
// So the correct subject order is [2, 1, 0, 3].

// Sample Input-2:
// ---------------
// 5
// 5
// 0 1
// 1 2
// 2 3
// 3 4
// 4 0

// Sample Output-2:
// ----------------
// []

// Explanation-2:
// -------------
// No subject can be completed because they depend on each other.


import java.util.*;
import java.io.*;
import java.util.stream.*;

class CourseSchedule 
{
    public int[] findOrder(int numCourses, int[][] prerequisites) 
	{
        //WRITE YOUR CODE HERE and return the order
        
        int[] indegree= new int[numCourses];
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();
        
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            int[]p=prerequisites[i];
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]+=1;
        }
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        
        //Queue<Integer> q= new LinkedList<>();
        ArrayList<Integer> tops= new ArrayList<>();
        int count=0;
        
        while(!q.isEmpty())
        {
            System.out.println(q);
            
            int u=q.poll();
            tops.add(u);
            
            for(int v : adj.get(u))
            {
                indegree[v]-=1;
                if(indegree[v]==0)
                {
                    q.add(v);
                }
            }
            count+=1;
        }
        
        if(count!=numCourses)
        {
            return new int[0];
        }
        else
        {
            return tops.stream().mapToInt(Integer::intValue).toArray();
        }
        
    }
	
	public static void main(String args[] ) throws IOException 
	{	
		Scanner sc=new Scanner(System.in);	
		int courses,nprerequisites;
		courses=sc.nextInt();
		nprerequisites=sc.nextInt();
		int[][] prerequisites=new int[nprerequisites][2];
		for(int i=0; i<nprerequisites; i++)
		{
			int a=sc.nextInt(),b=sc.nextInt();
			prerequisites[i][0]=a;
			prerequisites[i][1]=b;
		}  	   
		int[] result=new CourseSchedule().findOrder(courses, prerequisites);
		System.out.println(Arrays.toString(result));
	} 
}