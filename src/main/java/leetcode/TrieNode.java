package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by taku on 2016/05/28.
 */
public class TrieNode {
    // Initialize your data structure here.
    public boolean termination;
    public Map<Character, TrieNode> labels;

    public TrieNode() {
        labels = new HashMap<>();
        termination = false;
    }
}
