import java.util.*;
class TreapNode
{
    int data;
    int priority;
    TreapNode left;
    TreapNode right;
    TreapNode(int data)
    {
        this.data = data;
        this.priority = new Random().nextInt(1000);
        this.left = this.right = null;
    }
}

class KthLargest
{
    static int k;
    static int c=0;
    public static TreapNode rotateLeft(TreapNode root)
    {
        TreapNode y=root.right;
        TreapNode T2=y.left;
        
        y.left=root;
        root.right=T2;
        
        return y;
        
    }

    public static TreapNode rotateRight(TreapNode root)
    {
        TreapNode x=root.left;
        TreapNode T2=x.right;
        
        x.right=root;
        root.left=T2;
        
        return x;
    }

    public static TreapNode insertNode(TreapNode root, int data)
    {
        if(root==null)
        {
            return new TreapNode(data);
        }
        
        if(data<=root.data)
        {
            root.left=insertNode(root.left,data);
            
            if(root.left.priority>root.priority)
            {
                root=rotateRight(root);
            }
        }
        else
        {
            root.right=insertNode(root.right,data);
            if(root.right.priority>root.priority)
            {
                root=rotateLeft(root);
            }
        }
        return root;
    }

    static void inorder(TreapNode root)
    {
        if(root==null)
        {
            return;
        }
        
        inorder(root.left);
        //System.out.print(root.data+" ");
        c++;
        if(c==k)
        {
            //System.out.println("answer : ");
            System.out.println(root.data+" ");
        }
        //System.out.println("c="+c);
        inorder(root.right);
        
    }

// 	static void printTreap(TreapNode root)
//     {
//         if (root == null)
//             return;
//         printTreap(root.left);
//         System.out.println(root.data + " " + root.priority);
//         printTreap(root.right);
//     }
    public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        k=n-p+1;
        //System.out.println("k="+k);
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        TreapNode root = null;
        for(int a:arr){
            root = insertNode(root,a);
        }
// 		printTreap(root);
        inorder(root);
    }
}
