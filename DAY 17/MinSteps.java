// Given a positive integer n, you can apply one of the following operations:

// If n is even, replace n with n / 2.
// If n is odd, replace n with either n + 1 or n-1 .
// Return the minimum number of operations needed for n to become 1.

// Sample Input-1:
// ---------------
// 8


// Sample Output-1: 
// ----------------
// 3

// Explanation: 8 -> 4 -> 2 -> 1

// Sample Input-2:
// ---------------
// 7

// Sample Output-2: 
// ----------------
// 4

// Explanation: 7 -> 8 -> 4 -> 2 -> 1
// or 7 -> 6 -> 3 -> 2 -> 1

import java.util.*;
class MinSteps
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        
        int c=0;
        
        while(n>0)
        {
            if((n&1)==0)
            {
                //System.out.println("even : "+n);
                n=n>>1;
                //c++;
            }
            else
            {
                //System.out.println("odd : "+n);
                if((n&2) == 2 && n!=3)
                {
                    n+=1;
                }
                else
                {
                    n-=1;
                }
            }
            c++;
        }
        System.out.println(c-1);
    }
}