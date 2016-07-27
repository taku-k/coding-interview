package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by taku on 7/12/16.
 */
@RunWith(Parameterized.class)
public class TopkFrequentElementsTest {
    private static TopkFrequentElements obj = new TopkFrequentElements();

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][][] {
                { new Integer[]{1,1,1,2,2,3}, new Integer[]{2}, new Integer[]{1,2} },
                { new Integer[]{1}, new Integer[]{1}, new Integer[]{1} },
                { new Integer[]{4,1,-1,2,-1,2,3}, new Integer[]{2}, new Integer[]{-1,2} },
        });
    }

    @Parameter // first data value (0) is default
    public Integer[] nums;

    @Parameter(value = 1)
    public Integer[] k;

    @Parameter(value = 2)
    public Integer[] expected;

    @Test
    public void test() {
        assertArrayEquals(expected, obj.topKFrequent(ArrayUtils.toPrimitive(nums), k[0]).toArray());
    }

}