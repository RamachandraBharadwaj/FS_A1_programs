// You are given an integer N. Your task is to return an array ans of length N + 1 
// where each ans[i] represents the number of 1's in the binary representation of i.

// Input Format:
// --------------
// A single integer N, representing the range from 0 to N.

// Output Format:
// ---------------
// An array of N+1 integers where each element represents the count of 1s in the binary representation of each number from 0 to N.

// Sample Input-1:
// ---------------
// 2

// Sample Output-1:
// ----------------
// [0,1,1]

// Explanation:
// ------------
// 0 --> 0
// 1 --> 1
// 2 --> 10

// Sample Input-2:
// ---------------
// 5

// Sample Output-2:
// --------------- 
// [0,1,1,2,1,2]

// Explanation:
// ------------
// 0 --> 0
// 1 --> 1
// 2 --> 10
// 3 --> 11
// 4 --> 100
// 5 --> 101

import java.util.*;
class CountingBits
{
    public static int[] count_bits(int n)
    {
        int res[]= new int[n+1];
        
        for(int i=0;i<res.length;i++)
        {
            int c=0;
            int num=i;
            
            while(num>0)
            {
                if((num&1)==1)
                {
                    c++;
                }
                num=num>>1;
            }
            res[i]=c;
        }
        return res;
    }
    
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(Arrays.toString(count_bits(n)));
    }
}