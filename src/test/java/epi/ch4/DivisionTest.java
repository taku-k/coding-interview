package epi.ch4;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class DivisionTest {
    @Test
    public void div() throws Exception {
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            int x = r.nextInt(Integer.MAX_VALUE);
            int y = r.nextInt(Integer.MAX_VALUE);
            long expected = Division.div(x, y);
            long actual = x / y;
            assertEquals(String.format("%d / %d", x, y), expected, actual);
        }
    }
}