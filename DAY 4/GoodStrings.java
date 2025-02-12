// A string is good if there are no repeated characters.
// Given a string s, return the number of good substrings of length three in s.
// Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
// A substring is a contiguous sequence of characters in a string.

// Sample Input-1:
// ---------------
// xyzzaz

// Sample Output-1:
// ----------------
// 1

// Explanation: 
// ------------
// There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
// The only good substring of length 3 is "xyz".

// Sample Input-2:
// ---------------
// aababcabc

// Sample Output-2:
// ----------------
// 4

// Explanation: 
// ------------
// There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
// The good substrings are "abc", "bca", "cab", and "abc".


import java.util.*;

class GoodStrings
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        
        HashMap<Character,Integer> mapper= new HashMap<>();
        int good_c=0;
        
        for(int i=0;i<3;i++)
        {
            mapper.put(s.charAt(i),mapper.getOrDefault(s.charAt(i),0)+1);
        }
        if(mapper.size()==3)
        {
            good_c++;
        }
        
        for(int i=3;i<s.length();i++)
        {
            mapper.put(s.charAt(i-3),mapper.get(s.charAt(i-3))-1);
            
            if(mapper.get(s.charAt(i-3))==0)
            {
                mapper.remove(s.charAt(i-3));
            }
            
            mapper.put(s.charAt(i),mapper.getOrDefault(s.charAt(i),0)+1);
            if(mapper.size()==3)
            {
                good_c++;
            }
        }
        
        System.out.println(good_c);
    }
}