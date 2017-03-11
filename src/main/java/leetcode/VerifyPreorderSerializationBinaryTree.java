package leetcode;

public class VerifyPreorderSerializationBinaryTree {
    private class IndexHolder {
        public int idx;
        public IndexHolder(int idx) {
            this.idx = idx;
        }
    }
    public boolean isValidSerialization(String preorder) {
        if (preorder.equals("")) return true;
        String[] order = preorder.split(",");
        IndexHolder idx = new IndexHolder(0);
        return verify(order, idx) && idx.idx == order.length;
    }

    private boolean verify(String[] preorder, IndexHolder idx) {
        if (idx.idx >= preorder.length) return false;
        String val = preorder[idx.idx];
        idx.idx++;
        return val.equals("#") || verify(preorder, idx) && verify(preorder, idx);
    }
}
