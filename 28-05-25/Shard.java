// +
// You are given a crystal with an energy level n. Your goal is to discover all the different ways this crystal could have been created by combining smaller shards.

// Each combination must:
// - Use only shards with energy values between 2 and n - 1.
// - Be represented as a list of shard values whose product equals n.
// - Use any number of shards (minimum 2), and the order is ascending order.

// Your task is to return all unique shard combinations that can multiply together to recreate the original crystal.

// Input Format:
// -------------
// Line-1: An integer

// Output Format:
// --------------
// Line-1: List of all unique shard combinations

// Sample Input-1:
// ---------------
// 28

// Sample Output-1:
// ----------------
// [[2, 14], [2, 2, 7], [4, 7]]

// Sample Input-2:
// ---------------
// 23

// Sample Output-2:
// ----------------
// []


// Constraints:
// - 1 <= n <= 10^4
// - Only shards with energy between 2 and n - 1 can be used.

import java.util.*;
class Shard
{
    static LinkedHashSet<ArrayList<Integer>> arl = new LinkedHashSet<>();
    
    public static void backtrack(int num, ArrayList<Integer> ar, int prod)
    {
        if(prod>num)
        {
            return;
        }
        if(num==prod)
        {
            //System.out.println("num : "+num+" prod : "+prod);
            ArrayList<Integer> aro= new ArrayList<>(ar);
            Collections.sort(aro);
            //System.out.println("arl : "+arl);
            arl.add(new ArrayList<>(aro));
            return;
        }
        
        for(int i=2;i<num;i++)
        {
            if(num%i==0)
            {
                ar.add(i);
                backtrack(num,ar,prod*i);
                ar.remove(ar.size()-1);
            }
        }
    }
    
    public static void main(String [] args)
    {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        
        backtrack(n,new ArrayList<>(),1);
        System.out.println(arl);
        
        
    }
}