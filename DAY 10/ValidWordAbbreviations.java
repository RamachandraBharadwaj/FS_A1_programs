/*
 * zGiven a non-empty string s and an abbreviation abbr, 
return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

Notice that only the above abbreviations are valid abbreviations of the string "word". 
Any other string is not a valid abbreviation of "word".

Note: Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Input Format:
-------------
Line-1: A string, S contains only lowercase letters
Line-2: A string, abbr contains lowercase letters and digits

Output Format:
--------------
Line-1: A boolean value.
Sample Input-1:
---------------
internationalization
i12iz4n

Sample Output-1:
---------------
true

Sample Input-2:
---------------
apple
a2e

Sample Output-2:
---------------
false

Time Complexity: O(n) where n=max(len(word),len(abbr))
Auxiliary Space:  O(1).
 */


import java.util.*;

class ValidWordAbbreviation
{
    public static boolean Valido(String s1, String s2)
    {
        char[] arr1=s1.toCharArray();
        char[] arr2=s2.toCharArray();
        
        int l=0;
        int r=0;
        
        while(l<arr1.length && r<arr2.length)
        {
            //System.out.println(arr1[l]+" "+arr2[r]);
            
            if(l==arr1.length-1 && r==arr2.length-1)
            {
                if(arr1[l]==arr2[r])
                {
                    return true;
                }
            }
            
            if((arr2[r]-'0'>0) && (arr2[r]-'0'<=9))
            {
                l+=arr2[r]-'0';
                r++;
                continue;
            }
            
            if(arr1[l]!=arr2[r])
            {
                return false;
            }
            
            l++;
            r++;
        }
        return false;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        
        System.out.println(Valido(s1,s2));
    }
}