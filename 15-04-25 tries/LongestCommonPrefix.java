// Mr.Uday is trying to develop a software which reads array of strings from user and gives the
// longest common prefix of those strings, if no common prefix then it will give empty string. 
// Help uday to develop program.


// Input Format: 
// -------------
// Line-1: array of strings seperated by ','

// Output Foramt: 
// --------------
// longest common prefix.

// Sample Input-1:
// ---------------
// flower,flow,flight

// Sample Output-1: 
// ----------------
// fl

// Sample Input-2:
// --------------
// dog,racecar,car

// Sample Output-2:
// ----------------
// ""

// Explanation: There is no common prefix among the input strings.

// Note: USE TRIE DATASTRUCTURE
//       STRING SHOULD CONTAIN ONLY LOWER CASE ALPHABETS(a to z  only)

import java.util.*;

class TrieNode {
    char val;
    boolean isEnd;
    TrieNode[] children;

    public TrieNode() {
        this.children = new TrieNode[26];
    }

    public TrieNode(char c) {
        this();
        this.val = c;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.root;

        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode(c);
            }
            curr = curr.children[c - 'a'];
        }

        curr.isEnd = true;
    }

    public String longestCommonPrefix() {
        StringBuilder prefix = new StringBuilder();
        TrieNode curr = this.root;

        while (true) {
            int count = 0;
            int index = -1;

            // Count non-null children
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    count++;
                    index = i;
                }
            }

            if (count != 1 || curr.isEnd) {
                break;
            }

            // Append the character and move to next node
            curr = curr.children[index];
            prefix.append((char) (index + 'a'));
        }

        return prefix.toString();
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        Trie trie = new Trie();
        for (String word : strs) {
            trie.insert(word);
        }

        return trie.longestCommonPrefix();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(",");
        System.out.println(new Solution().longestCommonPrefix(str));
    }
}
