package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by taku on 8/1/16.
 */
public class SameTreeTest {
    @Test
    public void test() {
        SameTree st = new SameTree();
        assertEquals(true, st.isSameTree(null, null));
        assertEquals(true, st.isSameTree(Utils.toTreeNode(1,2,3), Utils.toTreeNode(1,2,3)));
        assertEquals(false, st.isSameTree(Utils.toTreeNode(1,2,3), Utils.toTreeNode(1,2)));
        assertEquals(true, st.isSameTree(Utils.toTreeNode(1,null,2), Utils.toTreeNode(1,null,2)));
    }
}