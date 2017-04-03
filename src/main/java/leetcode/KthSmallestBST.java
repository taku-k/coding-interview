package leetcode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> topk = new ArrayList<>();
        dfs(root, topk, k);
        return topk.get(k-1);
    }

    private void dfs(TreeNode root, List<Integer> topk, int k) {
        if (root != null && topk.size() < k) {
            dfs(root.left, topk, k);
            if (topk.size() < k) {
                topk.add(root.val);
                dfs(root.right, topk, k);
            }
        }
    }
}
