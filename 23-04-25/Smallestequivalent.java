// Vihaar is working with strings. 
// He is given two strings A and B, and another string T,
// where the length of A and B is same.

// You can find the relative groups of letters from A and B,
// using the following rule set:
// - Equality rule: 'p' == 'p'
// - Symmetric rule: 'p' == 'q' is same as 'q' == 'p'
// - Transitive rule: 'p' == 'q' and 'q' == 'r' indicates 'p' == 'r'.

// Vihaar has to form the relatively smallest string of T,
// using the relative groups of letters.

// For example, if A ="pqr" and B = "rst" , 
// then we have 'p' == 'r', 'q' == 's', 'r' == 't' .

// The relatives groups formed using above rule set are as follows: 
// [p, r, t] and [q,s] and  String T ="tts", then relatively smallest string is "ppq".

// You will be given the strings A , B and T.
// Your task is to help Vihaar to find the relatively smallest string of T.


// Input Format:
// -------------
// Three space separated strings, A , B and T

// Output Format:
// --------------
// Print a string, relatively smallest string of T.


// Sample Input-1:
// ---------------
// kmit ngit mgit

// Sample Output-1:
// ----------------
// ggit

// Explanation: 
// ------------
// The relative groups using A nd B are [k, n], [m, g], [i], [t] and
// the relatively smallest string of T is "ggit"


// Sample Input-2:
// ---------------
// attitude progress apriori

// Sample Output-2:
// ----------------
// aaogoog

// Explanation: 
// ------------
// The relative groups using A nd B are [a, p], [t, r, o], [i, g] and [u, e, d, s]
// the relatively smallest string of T is "aaogoog"

import java.util.*;

class SmallestString
{
    int n;
    int rank[];
    int parent[];
    
    SmallestString()
    {
        this.n=26;
        this.parent=new int[26];
        init();
    }
    
    
    public void init()
    {
        for(int i=0;i<26;i++)
        {
            parent[i]=i;
        }
    }
    
    public int find(int x)
    {
        if(parent[x]!=x)
        {
            parent[x]=find(parent[x]);
        }
        
        return x;
    }
    
    public void union(char x, char y)
    {
        int d_x=x-'a';
        int d_y=y-'a';
        
        //System.out.println(d_x+" "+d_y);
        
        int rootX=find(d_x);
        int rootY=find(d_y);
        if(rootX<rootY)
        {
            this.parent[d_y]=Math.min(this.parent[d_y],d_x);
            
        }
        else
        {
            this.parent[d_x]=Math.min(this.parent[d_x],d_y);
        }

    }
    
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        String x=sc.nextLine();
        String arr[]= x.split(" ");
        
        SmallestString s= new SmallestString();
        //System.out.println(Arrays.toString(arr));
        
        for(int i=0;i<arr[0].length();i++)
        {
            s.union(arr[0].charAt(i),arr[1].charAt(i));
        }
        String fin="";
        
        System.out.println(Arrays.toString(s.parent));
        
        for(int i=0;i<arr[2].length();i++)
        {
            char ch=arr[2].charAt(i);
            int val=s.parent[ch-'a'];
            fin+=(char)('a'+val);
        }
        
        System.out.println(fin);
        
        
    }
}