package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by taku on 7/12/16.
 */
public class MergeTwoSortedListsTest {
    @Test
    public void mergeTwoLists() throws Exception {
        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
        assertEquals(Utils.lnd(mtsl.mergeTwoLists(Utils.lns("2,6,8"), Utils.lns("1,2,5"))), "1,2,2,5,6,8");
        assertEquals(Utils.lnd(mtsl.mergeTwoLists(Utils.lns("1,6,8"), Utils.lns("1,2,5"))), "1,1,2,5,6,8");
        assertEquals(Utils.lnd(mtsl.mergeTwoLists(Utils.lns("1,6,8"), Utils.lns("1"))), "1,1,6,8");
        assertEquals(Utils.lnd(mtsl.mergeTwoLists(Utils.lns("1"), Utils.lns("1"))), "1,1");
        assertEquals(Utils.lnd(mtsl.mergeTwoLists(Utils.lns("1"), Utils.lns("2"))), "1,2");
        assertEquals(Utils.lnd(mtsl.mergeTwoLists(Utils.lns("3"), Utils.lns("2"))), "2,3");
    }

}