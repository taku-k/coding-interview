package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TinyURL {
  private Map<String, String> shortToLong = new HashMap<>();
  private Map<String, String> longToShort = new HashMap<>();
  private static String asciiLetterDigit =
      "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  private static Random random = new Random();

  public String encode(String longURL) {
    while (!longToShort.containsKey(longURL)) {
      char[] shortChar = new char[6];
      for (int i = 0; i < 6; ++i) {
        shortChar[i] = asciiLetterDigit.charAt(random.nextInt(asciiLetterDigit.length()));
      }
      String shortURL = "http://tinyurl.com/" + String.valueOf(shortChar);
      if (!shortToLong.containsKey(shortURL)) {
        shortToLong.put(shortURL, longURL);
        longToShort.put(longURL, shortURL);
      }
    }
    return longToShort.get(longURL);
  }

  public String decode(String shortURL) {
    return shortToLong.getOrDefault(shortURL, "");
  }
}
