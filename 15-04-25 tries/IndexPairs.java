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

class IndexPairs {
    static int num_chars = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[num_chars];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < num_chars; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    // Insert word into Trie
    static void insert(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode currentNode = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }

            currentNode = currentNode.children[index];
        }

        currentNode.isEndOfWord = true;
    }

    // Search for matches starting from index 'start' in STR
    static List<int[]> searchAllFrom(String STR, int start) {
        List<int[]> result = new ArrayList<>();
        TrieNode currentNode = root;

        for (int i = start; i < STR.length(); i++) {
            int index = STR.charAt(i) - 'a';
            if (index < 0 || index >= num_chars || currentNode.children[index] == null)
                break;

            currentNode = currentNode.children[index];
            if (currentNode.isEndOfWord) {
                result.add(new int[]{start, i});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String STR = sc.nextLine();
        String[] words = sc.nextLine().split(" ");

        root = new TrieNode();

        // Insert all words into Trie
        for (String word : words) {
            insert(word);
        }

        List<int[]> result = new ArrayList<>();

        // Try to find matches starting from each index
        for (int i = 0; i < STR.length(); i++) {
            result.addAll(searchAllFrom(STR, i));
        }

        result.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        for (int[] pair : result) {
            System.out.println(pair[0] + " " + pair[1]);
        }
    }
}
