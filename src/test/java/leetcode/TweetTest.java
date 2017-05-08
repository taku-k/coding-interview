package leetcode;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

/** Created by taku on 7/11/16. */
public class TweetTest {
  @Test
  public void test1() {
    Twitter obj = new Twitter();
    obj.postTweet(0, 0);
    obj.postTweet(0, 1);
    obj.postTweet(0, 2);
    obj.follow(1, 0);
    List<Integer> feeds = obj.getNewsFeed(1);
    assertArrayEquals(feeds.toArray(), new Integer[] {2, 1, 0});
  }

  @Test
  public void test2() {
    Twitter twitter = new Twitter();
    twitter.postTweet(1, 5);
    assertArrayEquals(twitter.getNewsFeed(1).toArray(), new Integer[] {5});
    twitter.follow(1, 2);
    twitter.postTweet(2, 6);
    assertArrayEquals(twitter.getNewsFeed(1).toArray(), new Integer[] {6, 5});
    twitter.unfollow(1, 2);
    assertArrayEquals(twitter.getNewsFeed(1).toArray(), new Integer[] {5});
  }
}
