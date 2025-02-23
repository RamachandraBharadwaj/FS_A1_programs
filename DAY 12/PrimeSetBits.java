// Given two integers left and right, return the count of numbers in the inclusive range [left, right]
//  having a prime number of set bits in their binary representation.

// Recall that the number of set bits an integer has the number of 1's present when written in binary.

// For example, 21 written in binary is 10101, which has 3 set bits.
 
// Input Format:
// -------------
// Line-1: Two separated integers

// Output Format:
// --------------
// Line-1: An integer

// Sample Input-1:
// ---------------
// 6  10

// Sample Output-1:
// ---------------
// 4

// Explanation:
// ------------
// 6  -> 110 (2 set bits, 2 is prime)
// 7  -> 111 (3 set bits, 3 is prime)
// 8  -> 1000 (1 set bit, 1 is not prime)
// 9  -> 1001 (2 set bits, 2 is prime)
// 10 -> 1010 (2 set bits, 2 is prime)
// 4 numbers have a prime number of set bits.

// Sample Input-2:
// ---------------
// 10 15

// Sample Output-2:
// ---------------
// 5

// Explanation:
// ------------
// 10 -> 1010 (2 set bits, 2 is prime)
// 11 -> 1011 (3 set bits, 3 is prime)
// 12 -> 1100 (2 set bits, 2 is prime)
// 13 -> 1101 (3 set bits, 3 is prime)
// 14 -> 1110 (3 set bits, 3 is prime)
// 15 -> 1111 (4 set bits, 4 is not prime)
// 5 numbers have a prime number of set bits.

import java.util.*;
class PrimeSetBits
{
    public static boolean isPrime(int x)
    {
        int factors=0;
        for(int i=1;i<=x;i++)
        {
            if(x%i==0)
            {
                factors++;
            }
        }
        
        if(factors==2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static int PrimeSet(int m, int n)
    {
        int primecount=0;
        
        for(int i=m;i<=n;i++)
        {
            int onez=0;
            int num=i;
            
            while(num>0)
            {
                onez=(num&1)==1?onez+1:onez;
                num=num>>1;
            }
            
            if(isPrime(onez))
            {
                //System.out.println("number : "+i+" ones : "+onez);
                primecount++;
            }
        }
        
        return primecount;
    }
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int n= sc.nextInt();
        
        System.out.println(PrimeSet(m,n));
    }
}