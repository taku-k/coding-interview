package leetcode;

public class CanPlaceFlowers {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    for (int i = 0; i < flowerbed.length;) {
      if (flowerbed[i] == 1) {
        i += 2;
      } else {
        if (i + 1 < flowerbed.length) {
          if (flowerbed[i+1] == 0) {
            flowerbed[i] = 1;
            --n;
            i += 2;
          } else {
            i += 3;
          }
        } else if (i == flowerbed.length - 1) {
          --n;
          ++i;
        }
      }
    }
    return n <= 0;
  }
}
