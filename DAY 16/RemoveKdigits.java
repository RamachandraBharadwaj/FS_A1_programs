// Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

// Example 1:
// input =1432219
// 3
// output =1219

// num = "1432219", k = 3
// Output: "1219"
// Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.


// Input: num = "10200", k = 1
// Output: "200"
// Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
// Example 3:

// Input: num = "10", k = 2
// Output: "0"
// Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

import java.util.*;
class RemoveKdigits
{
    public static int retdigits(String xyz,int k)
    {
        if(xyz.length()==k)
        {
            return 0;
        }
        Stack<Character> sta = new Stack<>();
        sta.add(xyz.charAt(0));
        
        for(int i=1;i<=xyz.length()-1;i++)
        {
            if(k>0)
            {
                //sta.add(xyz.charAt(i));
                
                int a=sta.peek()-'0';
                int b=xyz.charAt(i)-'0';
                //System.out.println(a+" "+b);
                if(a<b)
                {
                    sta.add(xyz.charAt(i));
                }
                else
                {
                    sta.pop();
                    sta.add(xyz.charAt(i));
                    k--;
                }
                //System.out.println(sta);
            }
            else
            {
                sta.add(xyz.charAt(i));
            }
            //System.out.println(sta);
        }
        
        String fin="";
        for(int i=0;i<sta.size();i++)
        {
            fin+=sta.get(i);
        }
        
        return Integer.valueOf(fin);
        
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s= sc.nextLine();
        int k=sc.nextInt();
        
        System.out.println(retdigits(s,k));

    }
}