package epi.ch4;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class PalindromeNumberTest {
    private boolean check(int x) {
        String s = String.valueOf(x);
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    @Test
    public void check() throws Exception {
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            int x = r.nextInt(Integer.MAX_VALUE);
            assertEquals(PalindromeNumber.check(x), check(x));
        }
    }
}