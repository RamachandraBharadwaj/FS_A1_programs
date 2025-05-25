// You're given a binary tree represented in level-order (with -1 denoting nulls). Your task is to print all paths from each leaf node to the root, preserving the order from leaf → parent → … → root. Each path should be printed on a new line, with node values joined by " —> ".
// If the current node is null, return.
// If the current node is a leaf (no left or right children), print the current path.

// Input Format:
// ------------
// Line-1: A single line containing space-separated integers representing the binary tree in level-order.
// Use -1 to represent a null (no child).

// Output Format:
// --------------
// Each line represents one path from a leaf node to the root.
// Node values must be joined using " —> ".
// Order of output paths may vary based on traversal, but all valid paths must be included

// Constraints:
// -------------
// 1 ≤ number of nodes ≤ 10^4
// Node values are integers in the range [-10^9, 10^9]
// Input tree is binary (each node has at most two children)
// Input is provided in level-order, and -1 denotes nulls

// Sample Input-1:
// ------------------
// 1 2 3 4 5 6 7 -1 -1 -1 -1 8 9 -1 -1

// Sample Output-1:
// --------------
// 4 —> 2 —> 1  
// 5 —> 2 —> 1  
// 8 —> 6 —> 3 —> 1  
// 9 —> 6 —> 3 —> 1  
// 7 —> 3 —> 1

// Sample Input-2:
// -------------
// 1 -1 2 -1 3 -1 4

// Sample Output-2:
// -------------------
// 4 —> 3 —> 2 —> 1


import java.util.*;
class Main
{
    static class Node
    {
        String nod;
        ArrayList<String> arl;
        Node left,right;
        Node(String nod, ArrayList<String> arl)
        {
            this.nod=nod;
            this.arl=arl;
            this.left=null;
            this.right=null;
        }
    }
    public static Node buildTree(String[] arroma)
    {
        Queue<Node> q= new LinkedList<>();
        int c=0;
        
        Node x= new Node(arroma[c],new ArrayList<>(List.of(arroma[c])));
        q.add(x);
        c++;
        
        while(!q.isEmpty())
        {
            Node xx=q.poll();
            //xx.arl.add(xx.nod);
            if(c>=arroma.length)
            {
                break;
            }
            if(xx.left==null && !arroma[c].equals("-1"))
            {
                ArrayList<String> newd=new ArrayList<>(xx.arl);
                newd.add(arroma[c]);
                xx.left=new Node(arroma[c],newd);
                //c+=1;
                q.add(xx.left);
            }
            c+=1;
            if(c<arroma.length && xx.right==null && !arroma[c].equals("-1"))
            {
                ArrayList<String> newd= new ArrayList<>(xx.arl);
                newd.add(arroma[c]);
                
                xx.right= new Node(arroma[c],newd);
                //c+=1;
                q.add(xx.right);
            }
            c+=1;
        }
        
        return x;
        
    }
    public static void prettyPrint(ArrayList<String> ar)
    {
        Collections.reverse(ar);
        for(int i=0;i<ar.size()-1;i++)
        {
            System.out.print(ar.get(i)+" -> ");
        }
        System.out.print(ar.get(ar.size()-1));
    }
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        String x=sc.nextLine();
        String[] arr=x.split(" ");
        
        Stack<Node> q= new Stack<>();
        q.add(buildTree(arr));
        
        //System.out.println("here");
        ArrayList<ArrayList<String>> fins= new ArrayList<>();
        
        while(!q.isEmpty())
        {
            Node nodey =q.pop();
            if(nodey.left==null && nodey.right==null)
            {
                //prettyPrint(nodey.arl);
                fins.add(nodey.arl);
            }
            if(nodey.left!=null)
            {
                q.add(nodey.left);
            }
            if(nodey.right!=null)
            {
                q.add(nodey.right);
            }
        }
        
        Collections.reverse(fins);
        for(ArrayList<String> ar : fins)
        {
            prettyPrint(ar);
            System.out.println();
        }
        
    }
}

//PS : IDK WHY test cases aren't passing, but the code is correct.