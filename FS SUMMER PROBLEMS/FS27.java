// You are given a string S representing a positive integer and an integer k. Your task is to find the smallest possible number that can be formed by performing at most k swaps between any two digits of the string.
// If k == 0, return the original number.
// If the number is already the smallest possible permutation, return it as-is.
// If the input is null or empty, return it unchanged.

// A swap operation means exchanging the positions of any two digits (not necessarily adjacent). Each swap counts as one operation. The goal is to minimize the number.

// Input Format:
// -----------
// A string S of digits (1 ≤ S.length ≤ 10)
// An integer k (0 ≤ k ≤ 10) representing the number of allowed swaps.

// Output Format:
// ------------
// A string representing the smallest number possible after performing at most k swaps.

// Constraints:
// --------------
// 1 ≤ length(S) ≤ 10
// 0 ≤ k ≤ 10
// Digits are in the range '0' to '9'
// No leading zeros in input unless the number is exactly "0"
// Each swap counts as 1 operation, regardless of position

// Sample Input-1:
// ------------
// 934651
// 2

// Sample Output-1:
// ----------------
// 134569

// Sample Input-2:
// -------------
// 11111
// 3
// Sample Output-2:
// --------------
// 11111

import java.util.*;
class numshort
{
    static int mino=Integer.MAX_VALUE;
    
    public static void backer(char[] arroma, int k,int idx,int swapz)
    {
        if(idx>=arroma.length)
        {
            return;
        }
        if(swapz>k)
        {
            return;
        }
        int x=Integer.parseInt(new String(arroma));
        mino=Math.min(mino,x);
        
        for(int i=idx+1;i<arroma.length;i++)
        {
            char t=arroma[i];
            arroma[i]=arroma[idx];
            arroma[idx]=t;
            
            backer(arroma,k,i,swapz+1);
            
            t=arroma[i];
            arroma[i]=arroma[idx];
            arroma[idx]=t;
            
            backer(arroma,k,i,swapz);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String x=sc.nextLine();
        char[] arroma=x.toCharArray();
        //sc.nextLine();
        int k=sc.nextInt();
        
        backer(arroma,k,0,0);
        
        System.out.println(mino);
        
        
    }
}