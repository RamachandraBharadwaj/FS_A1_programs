// VishnuVardan is working with Decision Trees for AI-based predictions.
// To analyze alternative outcomes, Kishore has planned to flip the decision 
// tree horizontally to simulate a reverse processing approach.

// Rules for Flipping the Decision Tree:
// 	- The original root node becomes the new rightmost node.
// 	- The original left child becomes the new root node.
// 	- The original right child becomes the new left child.
// This transformation is applied level by level recursively.

// Note:
// ------
// - Each node in the given tree has either 0 or 2 children.
// - Every right node in the tree has a left sibling sharing the same parent.
// - Every right node has no further children (i.e., they are leaf nodes).

// Your task is to help VishnuVardan flip the Decision Tree while following 
// the given transformation rules.

// Input Format:
// -------------
// Space separated integers, nodes of the tree.

// Output Format:
// --------------
// Print the list of nodes of flipped tree as described below.


// Sample Input-1:
// ---------------
// 4 2 3 5 1

// Sample Output-1:
// ----------------
// 5 1 2 3 4


// Sample Input-2:
// ---------------
// 4 2 5

// Sample Output-2:
// ----------------
// 2 5 4

import java.util.*;

class TreeNode {
    Integer val;
    TreeNode left, right;
    
    TreeNode(Integer val) {
        this.val = val;
        this.left = this.right = null;
    }
}
public class UpsideDown {
    
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
    //Write your code here 
    public static TreeNode upsideDownBinaryTree(TreeNode root)
    {
        if(root==null || root.left==null)
        {
            return root;
        }
        TreeNode new_root=upsideDownBinaryTree(root.left);
        
        root.left.left=root.right;
        root.left.right=root;
        
        root.left=null;
        root.right=null;
        
        return new_root;
    }
    public static List<Integer> levelOrderTraversal(TreeNode root)
    {
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        ArrayList<Integer> al= new ArrayList<>();
        
        while(!q.isEmpty())
        {
            TreeNode nodey=q.poll();
            
            if(nodey==null)
            {
                continue;
            }
            
            al.add(nodey.val);
            if(nodey.left!=null)
            {
                q.add(nodey.left);
            }
            if(nodey.right!=null)
            {
                q.add(nodey.right);
            }
        }
        
        return al;
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
        List<Integer> al=levelOrderTraversal(upsideDownBinaryTree(root));
        for(int x: al)
        System.out.print(x+" ");
    }
}
	  
	  
	  