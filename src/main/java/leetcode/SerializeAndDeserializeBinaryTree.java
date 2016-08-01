package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taku on 8/1/16.
 */
public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> preOrdered = new ArrayList<>();
        if (root == null) {
            return "null";
        }
        preOrderTravarse(root, preOrdered);
        StringBuilder sb = new StringBuilder();
        for (Integer val : preOrdered) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            if (val == null) {
                sb.append("null");
            } else {
                sb.append(val.toString());
            }
        }
        return sb.toString();
    }

    private void preOrderTravarse(TreeNode n, List<Integer> l) {
        if (n == null) {
            l.add(null);
            return;
        }
        l.add(n.val);
        preOrderTravarse(n.left, l);
        preOrderTravarse(n.right, l);
    }

    private class IntHolder {
        public Integer val;
        IntHolder(int v) {
            val = v;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] serialized = data.split(",");
        if (serialized.length == 0 || serialized[0] == "null") {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(serialized[0]));
        IntHolder idx = new IntHolder(1);
        root.left = construct(serialized, idx);
        idx.val += 1;
        if (idx.val == serialized.length - 1) return null;
        root.right = construct(serialized, idx);
        return root;
    }

    public TreeNode construct(String[] serialized, IntHolder idx) {
        if (idx.val > serialized.length - 1) return null;
        if (serialized[idx.val].equals("null")) {
            return null;
        }
        TreeNode n = new TreeNode(Integer.parseInt(serialized[idx.val]));
        idx.val += 1;
        n.left = construct(serialized, idx);
        idx.val += 1;
        n.right = construct(serialized, idx);
        return n;
    }
}
