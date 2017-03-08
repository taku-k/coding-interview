package leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BalancedBinaryTreeTest {
    @Parameterized.Parameters(name = "Test {index}: apply({0})")
    public static Collection<Object []> data() {
        return Arrays.asList(new Object[][] {
                {"null", true},
                {"0,1,3,2,null,4,5,null,null,null,null,6,null", true}
        });
    }

    private TreeNode root;

    private boolean expected;

    private static BalancedBinaryTree inst = new BalancedBinaryTree();

    public BalancedBinaryTreeTest(String input, boolean expected) {
        this.root = Utils.toTreeNode(input);
        this.expected = expected;
    }

    @Test
    public void apply() throws Exception {
        boolean actual = inst.isBalanced(root);
        assertEquals(expected, actual);
    }
}