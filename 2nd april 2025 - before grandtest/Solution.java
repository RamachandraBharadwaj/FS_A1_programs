// Imagine you're the master chef in a renowned kitchen, tasked with preparing a 
// spectacular dinner consisting of numDishes unique dishes, labeled from 
// 0 to numDishes - 1. However, the recipes have dependencies—certain dishes can 
// only be prepared after completing others. You’re given a list called dependecies, 
// where each element dependencies[i] = [Xi, Yi] means that you must finish 
// preparing dish Yi before starting dish Xi.

// For instance, the pair [2, 1] implies that to create dish 2, 
// dish 1 must be prepared first.

// Return the ordering of dishes that a chef should take to finish all dishes.
// 	- the result set should follow the given order of conditions.
// 	- If it is impossible to complete all dishes, return an empty set.


// Input Format:
// -------------
// Line-1: An integer numDishes, number of Dishes.
// Line-2: An integer m, number of dependencies.
// Next m lines: Two space separated integers, Xi and Yi.

// Output Format:
// --------------
// Return a list of integers, the ordering of dishes that a chef should finish.

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

// Explanation: There are 4 dishes. Since dish 1 requires dish 2, dish 3 requires 
// dish 0 and dish 0 requires dish 1, you can prepare dishes in the order 2 1 0 3.


// Sample Input-2:
// ---------------
// 2
// 2
// 1 0
// 0 1

// Sample Output-1:
// ----------------
// []

// Explanation: There are 2 dishes, but dish 1 depends on dish 0 and dish 0 depends 
// on dish 1. This circular dependency makes it impossible to prepare all dishes.

// Constraints:
// ------------
// - 1 <= numDishes <= 2000  
// - 0 <= m <= 5000  
// - dependencies[i].length == 2  
// - 0 <= Xi, Yi < numDishes  
// - All the dependency pairs are unique.

import java.util.*;
public class Solution{
    //static ArrayList<Integer> ar= new ArrayList<>();
    
    public static List<Integer> find(int numDishes, int[][]dependencies ){
        //Write your code here
        List<Integer> result = new ArrayList<>();
        if (numDishes == 0) {
          return result;
        }

        // Build adjacency list and in-degree array
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numDishes; i++) 
        {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[numDishes];
        for (int[] dep : dependencies) 
        {
            int x = dep[0];
            int y = dep[1];
            adj.get(y).add(x);
            inDegree[x]++;
        }

        // Queue for nodes with zero in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numDishes; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) 
        {
            int u = queue.poll();
            result.add(u);
            count++;
            for (int v : adj.get(u)) {
                if (--inDegree[v] == 0) 
                {
                    queue.add(v);
                }
            }
        }
        if (count != numDishes) 
        {
            return new ArrayList<>(); // cycle detected
        }
        return result;
    }
        
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int numDishes = sc.nextInt(),m = sc.nextInt();
        int[][] dependencies = new int[m][2];
        for (int i=0;i<m ;i++ )
        {
            dependencies[i][0] = sc.nextInt();
            dependencies[i][1] = sc.nextInt();
        }
        System.out.println(find(numDishes,dependencies));
    }
}