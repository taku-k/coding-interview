package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidSquare {
  private class Vector {
    int x;
    int y;
    Vector(Coord p1, Coord p2) {
      x = p1.x - p2.x;
      y = p1.y - p2.y;
    }

    boolean isOrthogonal(Vector other) {
      return (this.x*other.x + this.y*other.y) == 0;
    }

    double len() {
      return Math.sqrt(x*x + y*y);
    }
  }

  class Coord {
    int x;
    int y;
    Coord(int[] p) {
      this.x = p[0];
      this.y = p[1];
    }
  }

  List<List<Coord>> permutation(List<Coord> orig) {
    List<List<Coord>> result = new ArrayList<>();
    helper(orig, 0, result);
    return result;
  }

  void helper(List<Coord> l, int offset, List<List<Coord>> result) {
    if (offset == l.size()) {
      result.add(new ArrayList<>(l));
    }

    for (int i = offset; i < l.size(); ++i) {
      Collections.swap(l, i, offset);
      helper(l, i + 1, result);
      Collections.swap(l, i, offset);
    }
  }

  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    List<Coord> orig = new ArrayList<>();
    orig.add(new Coord(p1));
    orig.add(new Coord(p2));
    orig.add(new Coord(p3));
    orig.add(new Coord(p4));
    List<List<Coord>> perm = permutation(orig);
    for (List<Coord> cd : perm) {
      Vector p12 = new Vector(cd.get(0), cd.get(1));
      Vector p23 = new Vector(cd.get(1), cd.get(2));
      Vector p34 = new Vector(cd.get(2), cd.get(3));
      Vector p41 = new Vector(cd.get(3), cd.get(0));
      if (p12.isOrthogonal(p41) && p12.isOrthogonal(p23) && p23.isOrthogonal(p34) &&
          p34.isOrthogonal(p41) && Double.compare(p12.len(), p34.len()) == 0 &&
          Double.compare(p41.len(), p23.len()) == 0 && Double.compare(p12.len(), p41.len()) == 0 &&
          Double.compare(p12.len(), 0.0) != 0 && Double.compare(p23.len(), 0.0) != 0 &&
          Double.compare(p34.len(), 0.0) != 0 && Double.compare(p41.len(), 0.0) != 0) return true;
    }
    return false;
  }
}
