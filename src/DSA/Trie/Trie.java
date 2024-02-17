package DSA.Trie;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    public TrieNode[] children;
    public boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

public class Trie {

    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }


    public List<String> autoComplete(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode current = root;


        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return results;
            }
            current = current.children[index];
        }

        findAllWords(current, prefix, results);
        return results;
    }

    private void findAllWords(TrieNode node, String prefix, List<String> results) {
        if (node.isEndOfWord) {
            results.add(prefix);
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = ch - 'a';
            if (node.children[index] != null) {
                findAllWords(node.children[index], prefix + ch, results);
            }
        }
    }

    public boolean contains(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current != null && current.isEndOfWord;
    }

    void display() {
        displayHelper(root, "");
    }

    private void displayHelper(TrieNode node, String prefix) {
        if (node == null) return;

        if (node.isEndOfWord) {
            System.out.println(prefix);
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                char ch = (char) ('a' + i);
                displayHelper(node.children[i], prefix + ch);
            }
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();


        trie.insert("word");

        trie.insert("app");
        trie.insert("application");
        trie.insert("apple");


        System.out.println(trie.contains("word"));
        System.out.println(trie.contains("fall"));

        System.out.println(trie.autoComplete("ap"));

        trie.display();
    }

}
