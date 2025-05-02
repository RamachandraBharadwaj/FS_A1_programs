// An 8th standard student has been assigned a task as part of punishment for his mistake.

// The task is, there is an input string STR(without any space) and an array of 
// strings words[]. Print all the pairs of indices [s, e] where s, e are starting 
// index and ending index of every string in words[] in the input string STR.

// Note: Print the pairs[s, e] in sorted order.
// (i.e., sort them by their first coordinate, and in case of ties sort them by 
// their second coordinate).

// Input Format
// ------------
// Line-1: string STR(without any space)
// Line-2: space separated strings, words[]

// Output Format
// -------------
// Print the pairs[s, e] in sorted order.


// Sample Input-1:
// ---------------
// thekmecandngitcolleges
// kmec ngit colleges

// Sample Output-1:
// ----------------
// 3 6
// 10 13
// 14 21


// Sample Input-2:
// ---------------
// xyxyx
// xyx xy

// Sample Output-2:
// ----------------
// 0 1
// 0 2
// 2 3
// 2 4

// Explanation: 
// ------------
// Notice that matches can overlap, see "xyx" is found at [0,2] and [2,4].


// Sample Input-3:
// ---------------
// kmecngitkmitarecsecolleges
// kmit ngit kmec cse

// Sample Output-3:
// ----------------
// 0 3
// 4 7
// 8 11
// 15 17


import java.util.*;

class IndexPairs
{
    static int num_chars=26;
    static boolean isDelted=false;
    
    static class TrieNode
    {
        TrieNode children[]= new TrieNode[num_chars];
        boolean isEndOfWord;
        
        TrieNode()
        {
            isEndOfWord=false;
            for(int i=0;i<num_chars;i++)
            {
                children[i]=null;
            }
        }
    }
    
    static TrieNode root;
    
    static void insert(String key)
    {
        int level;
        int length=key.length();
        int index;
        
        TrieNode currentNode=root;
        
        for(level=0;level<length;level++)
        {
            index=key.charAt(level)-'a';
            if(currentNode.children[index]==null)
            {
                currentNode.children[index]=new TrieNode();
            }
            
            currentNode=currentNode.children[index];
            
        }
        
        currentNode.isEndOfWord=true;
    }
    
    static boolean search(String key)
    {
        int level;
        int length=key.length();
        
        TrieNode currentNode=root;
        
        
        for(level=0;level<length;level++)
        {
            index=key.charAt(level)-'a';
            if(currentNode.children[index]==null)
            {
                return false;
            }
            
            currentNode=currentNode.children[index];
        }
        
        return (currentNode.isEndOfWord);
    }   
}