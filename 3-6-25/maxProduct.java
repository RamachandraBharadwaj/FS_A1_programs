// Balbir Singh is working with Binary Trees.
// The elements of the tree is given in the level order format.
// Balbir has a task to split the tree into two parts by removing only one edge
// in the tree, such that the product of sums of both the splitted-trees should be maximum.

// You will be given the root of the binary tree.
// Your task is to help the Balbir Singh to split the binary tree as specified.
// print the product value, as the product may be large, print the (product % 1000000007)
	
// NOTE: 
// Please do consider the node with data as '-1' as null in the given trees.

// Input Format:
// -------------
// Space separated integers, elements of the tree.

// Output Format:
// --------------
// Print an integer value.


// Sample Input-1:
// ---------------
// 1 2 4 3 5 6

// Sample Output-1:
// ----------------
// 110

// Explanation:
// ------------
// if you split the tree by removing edge between 1 and 4, 
// then the sums of two trees are 11 and 10. So, the max product is 110.


// Sample Input-2:
// ---------------
// 3 2 4 3 2 -1 6

// Sample Output-2:
// ----------------
// 100

import java.util.*;

class TreeNode {
    Integer val;
    TreeNode left, right;
    
    TreeNode(Integer val) {
        this.val = val;
        this.left = this.right = null;
    }
}
class Solution {
    
    static int sumoha=0;
    static int subsumoha=0;
    
    public static void calc_sum(TreeNode nodey, boolean flag)
    {
        if(nodey==null)
        {
            return;
        }
        
        if(flag)
        {
            sumoha+=nodey.val;
        }
        else
        {
            subsumoha+=nodey.val;
        }
        
        calc_sum(nodey.left,flag);
        calc_sum(nodey.right,flag);
    }
    public int maxProduct(TreeNode root) {
        //WRITE YOUR CODE HERE AND RETURN THE MAXIMUM PRODUCT
        
        calc_sum(root,true);
        Queue<TreeNode> q = new LinkedList<>();
        
        int maxi_prod=Integer.MIN_VALUE;
        q.add(root);
        
        while(!q.isEmpty())
        {
            TreeNode xyz= q.poll();
            calc_sum(xyz,false);
            
            maxi_prod=Math.max(maxi_prod,sumoha*(sumoha-subsumoha));
            subsumoha=0;
            
            if(xyz.left!=null)
            {
                q.add(xyz.left);
            }
            if(xyz.right!=null)
            {
                q.add(xyz.right);
            }
        }
        
        return maxi_prod;
    }
}
public class MaxProduct {
    
    public static TreeNode buildTree(List<Integer> data) {
        if (data.isEmpty() || data.get(0) == -1) return null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(data.get(0));
        queue.offer(root);
        
        int i = 1;
        while (i < data.size()) {
            TreeNode current = queue.poll();
            
            if (i < data.size() && data.get(i) != -1) {
                current.left = new TreeNode(data.get(i));
                queue.offer(current.left);
            }
            i++;
            
            if (i < data.size() && data.get(i) != -1) {
                current.right = new TreeNode(data.get(i));
                queue.offer(current.right);
            }
            i++;
        }
        
        return root;
    }
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Integer> data = new ArrayList<>();
        for(String s:input) {
            data.add(Integer.parseInt(s));
        }
        scanner.close();
        
        TreeNode root = buildTree(data);
        
        System.out.println(new Solution().maxProduct(root));
    }
}