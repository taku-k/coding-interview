package epi.ch12;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.junit.Test;

public class SubseqCoverTest {
  public static String randString(int len) {
    StringBuilder sb = new StringBuilder();
    Random gen = new Random();
    while (len-- != 0) {
      sb.append((char) (gen.nextInt('z' + 1 - 'a') + 'a'));
    }
    return sb.toString();
  }

  @Test
  public void smallTest() {
    List<String> a3 =
        Arrays.asList(
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "2", "4", "6", "10", "10", "10", "3",
            "2", "1", "0");
    List<String> subseq4 = Arrays.asList("0", "2", "9", "4", "6");
    Subarray rr = SubseqCover.findSmallestSequentiallyCoveringSubset(a3, subseq4);
    assertEquals((int) rr.start, 0);
    assertEquals((int) rr.end, 12);
  }

  @Test
  public void test() {
    Random gen = new Random();
    for (int times = 0; times < 1000; ++times) {
      int n = gen.nextInt(10000) + 1;
      List<String> A = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        A.add(randString(gen.nextInt(5) + 1));
      }
      Set<String> dict = new HashSet<>(A);
      int m = gen.nextInt(Math.min(dict.size(), 10)) + 1;
      List<String> Q = new ArrayList<>(m);
      Iterator<String> it = dict.iterator();
      for (int i = 0; i < m; i++) {
        if (it.hasNext()) {
          Q.add(it.next());
        }
      }
      Subarray res = SubseqCover.findSmallestSequentiallyCoveringSubset(A, Q);
      if (res.start != -1 && res.end != Q.size()) {
        dict.clear();
        dict.addAll(Q);
        for (int i = res.start; i <= res.end; ++i) {
          if (dict.contains(A.get(i))) {
            dict.remove(A.get(i));
          }
        }
        assertTrue(dict.isEmpty());
      }
    }
  }
}
