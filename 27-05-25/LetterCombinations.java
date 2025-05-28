// Imagine you're a top-secret agent receiving an encrypted directive from headquarters. 
// The message comes as a string of digits, 
// and each digit (from 2 to 9) is a cipher for a set of potential code letters. 

// To uncover the true instruction, you must translate the string into 
// every possible combination of letters by substituting each digit with 
// its corresponding set of letters. The final decoded messages listed in lexicographycal order.

// Below is the mapping of digits to letters (as found on a traditional telephone keypad):

// | Digit | Letters       |
// |-------|---------------|
// | 2     | a, b, c       |
// | 3     | d, e, f       |
// | 4     | g, h, i       |
// | 5     | j, k, l       |
// | 6     | m, n, o       |
// | 7     | p, q, r, s    |
// | 8     | t, u, v       |
// | 9     | w, x, y, z    |

// Note: The digit 1 does not correspond to any letters.

// Input Format:
// -------------
// Line-1: A string, represents the message (2-9 inclusive)

// Output Format:
// --------------
// Line-1: List of valid combination

// Sample Input-1:
// ---------------
// 23

// Sample Output-1:
// ----------------
// [ad, ae, af, bd, be, bf, cd, ce, cf]


// Sample Input-2: 
// ---------------
// 2

// Sample Output-2:
// ----------------
// [a, b, c]


// Constraints:
// ------------
// - 0 <= digits.length <= 4  
// - Each digit in the input is between '2' and '9'.

import java.util.*;
class aulikara
{
    static ArrayList<String> arl = new ArrayList<>();
    
    public static void backtrack(int idx, HashMap<Integer,String> hm,String fin, String orig)
    {
        if(idx==orig.length())
        {
            arl.add(fin);
            return;
        }
        int key=orig.charAt(idx)-'0';
        String val=hm.get(key);
        
        for(int i=0;i<val.length();i++)
        {
            String tem=fin;
            fin+=val.charAt(i);
            backtrack(idx+1,hm,fin,orig);
            fin=tem;
        }
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String x=sc.nextLine();
        HashMap<Integer,String> hm = new HashMap<>();
        
        hm.put(2,"abc");
        hm.put(3,"def");
        hm.put(4,"ghi");
        hm.put(5,"jkl");
        hm.put(6,"mno");
        hm.put(7,"pqrs");
        hm.put(8,"tuv");
        hm.put(9,"wxyz");
        
        backtrack(0,hm,"",x);
        System.out.println(arl);
        
        
    }
}


//yashodharman will rise