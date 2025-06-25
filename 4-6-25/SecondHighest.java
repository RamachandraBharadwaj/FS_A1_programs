// In an Intelligence Agency, each senior officer supervises either two junior officers 
// or none. The senior officer is assigned a clearance level equal to the higher clearance 
// level of the two junior officers they supervise.

// The clearance levels are represented as integer values in the range [1, 50], and multiple 
// officers may have the same clearance level.

// At the end, all officers (senior and junior) are collectively referred to as agents in the system.

// You are provided with a hierarchical clearance level tree where each node represents 
// an officer's clearance level. The tree structure follows these rules:
// 	- If a node has two children, its clearance level is the maximum of the two children's
// 	  clearance levels.
// 	- If a node has no children, it's clearance level is same as exists.
// 	- The value -1 indicates an empty (null) position.
// Your task is to find the second highest clearance level among all agents in the agency. 
// If no such level exists, return -2.

// Input Format:
// -------------
// A single line of space separated integers, clearance levels of each individual.

// Output Format:
// --------------
// Print an integer, second top agent based on rank.


// Sample Input-1:
// ---------------
// 5 5 4 -1 -1 2 4

// Sample Output-1:
// ----------------
// 4


// Sample Input-2:
// ---------------
// 3 3 3 3 3

// Sample Output-2:
// ----------------
// -2

import java.util.*;

class TreeNode {
    Integer val;
    TreeNode left, right;

    TreeNode(Integer val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class SecondHighest {
    
    Set<Integer> se= new TreeSet(Comparator.reverseOrder());
    
    public int dfs(TreeNode nodey)
    {
        if(nodey==null)
        {
            return -1;
        }
        if(nodey.left==null && nodey.right==null)
        {
            se.add(nodey.val);
            return nodey.val;
        }
        
        int left=dfs(nodey.left);
        int right=dfs(nodey.right);
        
        int curr=Math.max(left,right);
        se.add(curr);
        
        return curr;
        
    }
    public int secondHighest(TreeNode root) 
    {
        dfs(root);
        Iterator<Integer> it = se.iterator();
        if(!it.hasNext())
        {
            return -2;
        }
        it.next(); //skipping the first one
        if(!it.hasNext())
        {
            return -2;
        }
        return it.next();
    }
    
    public static TreeNode buildTree(List<Integer> arl)
    {
        TreeNode root= new TreeNode(arl.get(0));
        
        int c=1;
        int n=arl.size();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty() && c<n)
        {
            //System.out.println(q);
            
            TreeNode x= q.poll();
            if(x==null)
            {
                continue;
            }
            
            int z=arl.get(c);
            
            if(z!=-1)
            {
                x.left=new TreeNode(arl.get(c));
                q.add(x.left);
            }
                
            c+=1;
            
            z=arl.get(c);
            
            if(c<n && z!=-1)
            {
                x.right= new TreeNode(arl.get(c));
                q.add(x.right);
            }
            c+=1;
        }
        
        return root;
    }
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Integer> data = new ArrayList<>();
        for (String s : input) {
            data.add(Integer.parseInt(s));
        }
        scanner.close();

        TreeNode root = buildTree(data);
        int secondTop = new SecondHighest().secondHighest(root);
        System.out.println(secondTop);
    }
}
