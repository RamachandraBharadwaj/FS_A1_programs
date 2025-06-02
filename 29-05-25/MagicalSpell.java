// In the ancient land of Palindoria, wizards write magical spells as strings of lowercase letters. However, for a spell to be effective, each segment of the spell must read the same forward and backward.

// Given a magical spell 'spell', your task is to partition it into sequences of valid magical spell segments. 

// Your goal is to help the wizard discover all valid combinations of magical spell segmentations.

// Sample Input-1:
// ---------------
// aab
  
// Sample Output-1:  
// ----------------
// [[a, a, b], [aa, b]]

// Sample Input-2:
// --------------- 
// a
  
// Sample Output-2:  
// ----------------
// [[a]]

// Spell Constraints:
// ------------------
// - The length of the spell is between 1 and 16 characters.  
// - The spell contains only lowercase English letters.  
import java.util.*;
class MagicSpell
{
    static ArrayList<ArrayList<String>> arl = new ArrayList<>();
    
    public static boolean isPalin(String s)
    {
        int n=s.length();
        for(int i=0;i<=n/2;i++)
        {
            if(s.charAt(i)!=s.charAt(n-1-i))
            {
                return false;
            }
        }
        return true;
    }

    public static void backtrack(String x, int idx,ArrayList<String> ar)
    {
        if(idx==x.length())
        {
            arl.add(new ArrayList<>(ar));
        }
        for(int i=idx+1;i<=x.length();i++)
        {
            String subs=x.substring(idx,i);
            if(isPalin(subs))
            {
                ar.add(subs);
                backtrack(x,i,ar);
                ar.remove(ar.size()-1);
            }
        }
        
    }
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        backtrack(s,0,new ArrayList<>());
        
        System.out.println(arl);
    }
}