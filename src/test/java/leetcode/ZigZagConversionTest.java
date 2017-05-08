package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

/** Created by taku on 7/11/16. */
public class ZigZagConversionTest {
  @Test
  public void convert() throws Exception {
    ZigZagConversion zzc = new ZigZagConversion();
    assertEquals(zzc.convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
    assertEquals(zzc.convert("AB", 1), "AB");
    assertEquals(zzc.convert("ABCDE", 2), "ACEBD");
  }
}
