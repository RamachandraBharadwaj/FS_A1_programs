// -4 -Given an integer array nums sorted in non-decreasing order, 
// return an array of the squares of each number sorted in non-decreasing order.

// Input Format:
// -------------
// Line-1: An integer N
// Line-2: N space seperated integers

// Output Format:
// --------------
// Line-1: A list of integers

// Sample Input-1:
// ---------------
// 5
// -4 -1 0 3 10

// Sample Output-1: 
// ----------------
// [0, 1, 9, 16, 100]


import java.util.*;

class squares
{
    public static ArrayList<Integer> squares(int [] arr)
    {
        ArrayList<Integer> ar= new ArrayList<>();
        int l=0;
        int r=arr.length-1;
        
        while(l<=r)
        {
            if((arr[l]*arr[l])<(arr[r]*arr[r]))
            {
                ar.add(arr[r]*arr[r]);
                r--;
            }
            else
            {
                ar.add(arr[l]*arr[l]);
                l++;
            }
        }
        Collections.reverse(ar);
        return ar;
    }
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println(squares(arr));
        
    }
}
