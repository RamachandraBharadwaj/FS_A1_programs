// Malika taught a new fun time program practice for Engineering Students.
// As a part of this she has given set of N numbers, and asked the students 
// to perform the operations listed below:
// 1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
// 2. update(ind, val) - update the value at the index 'ind' to 'val'.

// Your task is to solve this problem using Fenwick Tree concept.

// Input Format:
// -------------
// Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
// Line-2: N space separated integers.
// next Q lines: Three integers option, start/ind and end/val.

// Output Format:
// --------------
// An integer result, for every sumRange query.


// Sample Input-1:
// ---------------
// 8 5
// 1 2 13 4 25 16 17 8
// 1 2 6		//sumRange
// 1 0 7		//sumRange
// 2 2 18	//update
// 2 4 17	//update
// 1 2 7		//sumRange

// Sample Output-1:
// ----------------
// 75
// 86
// 80



// Sample Input-2:
// ---------------
// 8 5
// 1 2 13 4 25 16 17 8
// 1 2 6		
// 1 0 7		
// 2 2 18	
// 2 4 17	
// 1 0 7

// Sample Output-2:
// ----------------
// 75
// 86
// 83
// Malika taught a new fun time program practice for Engineering Students.
// As a part of this she has given set of N numbers, and asked the students 
// to perform the operations listed below:
// 1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
// 2. update(ind, val) - update the value at the index 'ind' to 'val'.

// Your task is to solve this problem using Fenwick Tree concept.

// Input Format:
// -------------
// Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
// Line-2: N space separated integers.
// next Q lines: Three integers option, start/ind and end/val.

// Output Format:
// --------------
// An integer result, for every sumRange query.


// Sample Input-1:
// ---------------
// 8 5
// 1 2 13 4 25 16 17 8
// 1 2 6		//sumRange
// 1 0 7		//sumRange
// 2 2 18	//update
// 2 4 17	//update
// 1 2 7		//sumRange

// Sample Output-1:
// ----------------
// 75
// 86
// 80



// Sample Input-2:
// ---------------
// 8 5
// 1 2 13 4 25 16 17 8
// 1 2 6		
// 1 0 7		
// 2 2 18	
// 2 4 17	
// 1 0 7

// Sample Output-2:
// ----------------
// 75
// 86
// 83

import java.util.*;

class FenWickTree
{
    static int BIT[];
    static int n;
    static int arr[];
    
    public static int sum(int idexo)
    {
        idexo++;
        int sumo=0;
        
        while(idexo>0)
        {
            sumo+=BIT[idexo];
            idexo-=(idexo&-idexo);
        }
        return sumo;
    }
    
    public static int sumRange(int i, int j)
    {
        return sum(j)-sum(i-1);
    }
    
    public static void update(int idx, int val)
    {
        int diff=val-arr[idx];
        init(idx,diff);
        
    }
    public static void init(int i,int valo)
    {
        //int x=arr[i];
        i++;
        while(i<=n)
        {
            BIT[i]+=valo;
            i+=(i&-i);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        
        int q= sc.nextInt();
        arr= new int[n];
        BIT= new int[n+1];
        
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            init(i,arr[i]);
        }
        
        while(q-->0)
        {
            int opt=sc.nextInt();
            int num1=sc.nextInt();
            int num2=sc.nextInt();
            
            if(opt==1)
            {
                System.out.println(sumRange(num1,num2));
            }
            else
            {
                update(num1,num2);
            }
        }

    }
}