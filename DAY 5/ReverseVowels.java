// Given a string s, reverse only all the vowels in the 
// string and return it.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can 
// appear in both lower and upper cases, more than once.

// Sample Input-1:
// ---------------
// hello

// Sample Output-1:
// ----------------
// holle

// Sample Input-2:
// ----------------
// Keshavmemorial

// Sample Output-2:
// ----------------
// Kashivmomerael

import java.util.*;
class ReverseVowels
{
    public static String reverseVow(String s)
    {
        //boolean isVow[]=new boolean[];
        int l=0;
        String vows="aeiou";
        
        char[] arroma= s.toCharArray();
        
        int r=s.length()-1;
        
        while(l<r)
        {
            if(vows.contains(arroma[l]+"") && vows.contains(arroma[r]+""))
            {
                char tempa=arroma[l];
                arroma[l]=arroma[r];
                arroma[r]=tempa;
                
                l++;
                r--;
            }
            else if(vows.contains(arroma[l]+"") && !vows.contains(arroma[r]+""))
            {
                r--;
            }
            else if(!vows.contains(arroma[l]+"") && vows.contains(arroma[r]+""))
            {
                l++;
            }
            else
            {
                l++;
                r--;
            }
            
        }
        return new String(arroma);
        
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s= sc.nextLine();
        System.out.println(reverseVow(s));
        
    }
}