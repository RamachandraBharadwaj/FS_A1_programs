// A Kid built a structure using building blocks, 
// by placing the building-blocks adjacent to each other.

// A building-block is a vertical alignment of blocks.
// 									___
// here one block each represents  as |___|.

// The following structure made up of using building blocks

//                           ___
//                       ___|___|    ___
//                      |___|___|_w_|___|___              ___
//                   ___|___|___|___|___|___| w   _w_  w |___| 
//               ___|___|___|___|___|___|___|_w__|___|_w_|___|____________
    
//                0  1   3   4   2   3    2   0   1   0   2

// Once the structure is completed, kid pour water(w) on it.

// You are given a list of integers, heights of each building-block in a row.
//  Now your task How much amount of water can be stored by the structure.

// Input Format:
// -------------
// Space separated integers, heights of the blocks in the structure. 

// Output Format:
// --------------
// Print an integer, 
  
// Sample Input:
// -------------
// 0 1 3 4 2 3 2 0 1 0 2
    
// Sample Output:
// --------------
// 6
    
// Explanation:
// -----------
// In the above structure,  6 units of water (w represents the water in the 
// structure) can be stored.

import java.util.*;
class Blocks
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        String [] arr= s.split(" ");
        int[] arroma= new int[arr.length];
        for(int i=0;i<arroma.length;i++)
        {
            arroma[i]=Integer.parseInt(arr[i]);
        }
        
        int n=arroma.length;
        
        int leftMax[]=new int[arroma.length];
        int rightMax[]=new int[arroma.length];
        
        leftMax[0]=arroma[0];
        rightMax[n-1]=arroma[n-1];
        
        for(int i=1;i<n;i++)
        {
            leftMax[i]=Math.max(leftMax[i-1],arroma[i]);
        }
        
        for(int j=n-2;j>=0;j--)
        {
            rightMax[j]=Math.max(rightMax[j+1],arroma[j]);
        }
        
        int tot=0;
        for(int i=0;i<n;i++)
        {
            int temm=Math.min(leftMax[i],rightMax[i])-arroma[i];
            if(temm>0)
            {
                tot+=temm;
            }
        }
        System.out.println(tot);
    }
}