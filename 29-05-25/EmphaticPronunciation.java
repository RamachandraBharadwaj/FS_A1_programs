// "Emphatic Pronunciation" of a given word is where we take the word and
// replicate some of the letter to emphasize their impact.

// Instead of saying 'oh my god', someone may say "ohhh myyy goddd", 
// We define emphatic pronunciation of a word, which is derived by replicating 
// a group (or single) of letters in the original word. 

// So that the replicated group is atleast 3 characters or more and 
// greater than or equal to size of original group. 
// For example Good -> Goood is an emphatic pronunciation,
// but Goodd is not because in Goodd the 'd' are only occuring twice consecutively.
 
// In the question you are given the "Emphatic pronunciation" word, 
// you have to findout how many words can legal result in the 
// "emphatic pronunciation" word.

// Input Format:
// -------------
// Line-1 -> A String contains a single word, Emphatic Pronunciation word
// Line-2 -> Space seperated word/s

// Output Format:
// --------------
// Print an integer as your result


// Sample Input-1:
// ---------------
// goood
// good goodd

// Sample Output-1:
// ----------------
// 1


// Sample Input-2:
// ---------------
// heeelllooo
// hello hi helo

// Sample Output-2:
// ----------------
// 2


import java.util.*;
class Empha
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String emphasis=sc.nextLine();
        String wordsss=sc.nextLine();
        
        String[] words=wordsss.split(" ");
        int c=0;
        
        
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<emphasis.length();i++)
        {
            char x= emphasis.charAt(i);
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        
        OUTER:
        for (String xx : words)
        {
            //System.out.println("xx : "+xx);
            HashMap<Character,Integer> hm2= new HashMap<>();
            for(int i=0;i<xx.length();i++)
            {
                char z=xx.charAt(i);
                hm2.put(z,hm2.getOrDefault(z,0)+1);
            }
            
            if(hm.size()!=hm2.size())
            {
                continue;
            }
            
            boolean chl=true;
            
            //System.out.println(hm);
           // System.out.println(hm2);
            
            for(Map.Entry<Character,Integer> ent : hm.entrySet())
            {
                for(Map.Entry<Character,Integer> ent2 : hm2.entrySet())
                {
                    char k1=ent.getKey();
                    char k2=ent2.getKey();
                    
                    int val1=ent.getValue();
                    int val2=ent2.getValue();
                    
                    if(k1==k2)
                    {
                        if(val2<=val1)
                        {
                           chl=chl & true;
                        }
                        else
                        {
                            chl=chl & false;
                        }
                    }
                }
            }
            
            if(chl)
            {
                c+=1;
            }
            hm2.clear();
        }
        System.out.println(c);
        
    }
}