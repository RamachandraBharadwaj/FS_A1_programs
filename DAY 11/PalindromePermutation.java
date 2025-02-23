// AlphaCipher is a string formed from another string by rearranging its letters

// You are given a string S.
// Your task is to check, can any one of the AlphaCipher is a palindrome or not.

// Input Format:
// -------------
// A string S

// Output Format:
// --------------
// Print a boolean value.


// Sample Input-1:
// ---------------
// carrace

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// code

// Sample Output-2:
// ----------------
// false

import java.util.*;

class PalindromePermutation
{
    public static boolean perms(String s)
    {
        char arr[] = s.toCharArray();
        
        int bitmask=0;
        
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]-'a');
            
            int shifts=arr[i]-'a';
            int te=1<<shifts;
            bitmask^=te;
        }
        
        if(bitmask==0 || (bitmask&(bitmask-1))==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(perms(s));
    }
}