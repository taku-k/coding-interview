package leetcode;

import java.util.Map;

/**
 * Created by taku on 7/25/16.
 */
public class AddAndSearchWord {
    // Adds a word into the data structure.
    private TrieNode root;

    AddAndSearchWord() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!now.labels.containsKey(c)) {
                now.labels.put(c, new TrieNode());
            }
            now = now.labels.get(c);
        }
        now.termination = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return find(word, 0, root);
    }

    private boolean find(String word, int index, TrieNode node) {
        if (index == word.length()) {
            if (node.termination) {
                return true;
            } else {
                return false;
            }
        }
        Character c = word.charAt(index);
        if (node.labels.containsKey(c)) {
            return find(word, index + 1, node.labels.get(c));
        } else if (c == '.') {
            for (Map.Entry<Character, TrieNode> e : node.labels.entrySet()) {
                if (find(word, index + 1, e.getValue())) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }
}
