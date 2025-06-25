class pro
{
    boolean check_bst(TreeNode root)
    {
        if(root==null)
        {
            return true;
        }
        if(root.left!=null && root.val<root.left.val)
        {
            return false;
        }
        if(root.right!=null && root.val>root.right.val)
        {
            return false;
        }
        
        return check_bst(root.left) && check_bst(root.right);
    }
}