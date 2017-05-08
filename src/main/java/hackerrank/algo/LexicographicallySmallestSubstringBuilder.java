package hackerrank.algo;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.List;
import java.util.PriorityQueue;

public class LexicographicallySmallestSubstringBuilder {
  public static String build(List<String> substrings) {
    PriorityQueue<StringCharacterIterator> heap =
        new PriorityQueue<>(((o1, o2) -> Character.compare(o1.current(), o2.current())));
    StringBuilder sb = new StringBuilder();
    for (String s : substrings) {
      heap.add(new StringCharacterIterator(s));
    }
    while (!heap.isEmpty()) {
      StringCharacterIterator iter = heap.poll();
      sb.append(iter.current());
      if (iter.next() != CharacterIterator.DONE) {
        heap.add(iter);
      }
    }
    return sb.toString();
  }

  private static class SubstringEntity implements Comparable<SubstringEntity> {
    public String s;
    public int index;

    SubstringEntity(String s) {
      this.s = s;
      this.index = 0;
    }

    @Override
    public int compareTo(SubstringEntity o) {
      return Character.compare(s.charAt(index), o.s.charAt(o.index));
    }
  }

  public static String build2(List<String> substrings) {
    PriorityQueue<SubstringEntity> heap = new PriorityQueue<>();
    StringBuilder sb = new StringBuilder();
    for (String s : substrings) {
      heap.add(new SubstringEntity(s));
    }
    while (!heap.isEmpty()) {
      SubstringEntity entity = heap.poll();
      sb.append(entity.s.charAt(entity.index));
      if (entity.index + 1 < entity.s.length()) {
        entity.index += 1;
        heap.add(entity);
      }
    }
    return sb.toString();
  }
}
