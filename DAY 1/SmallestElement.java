// You are given an array consisting of N integers, and an integer, K. 
// Your task is to determine the minimum element in subarrays of size K.

// Sample Input1:
// --------------
// 5
// 10 12 14 11 15
// 3

// Sample Output1:
// ---------------
// 10 11 11

// Sample Input2:
// --------------
// 5
// 5 2 1 1 1
// 4

// Sample Output2:
// ---------------
// 1 1


import java.util.*;
//import java.stream.*;

class SmallestElement
{
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        
        int n=sc.nextInt();
        int arr[]=new int[n];
        
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        
        int k=sc.nextInt();
        ArrayList<Integer> sub = new ArrayList<>();
        int mino=Integer.MAX_VALUE;
        
        for(int i=0;i<k;i++)
        {
            sub.add(arr[i]);
            mino=Math.min(mino,arr[i]);
        }
        
        System.out.print(mino+" ");
        for(int i=k;i<n;i++)
        {
            //System.out.println("indexes : "+(i-k)+"   -   "+i);
            sub.remove(i-k);
            sub.add(arr[i]);
            mino=sub.stream().mapToInt(Integer::intValue).min().orElse(mino);
            System.out.print(mino+" ");
        }
    }
}