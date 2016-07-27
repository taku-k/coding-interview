package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by taku on 7/16/16.
 */
public class LRUCacheTest {
    @Test
    public void test() {
        LRUCache lru = new LRUCache(2);
        lru.set(1, 1);
        lru.set(2, 2);
        lru.set(3, 3);
        assertEquals(-1, lru.get(1));
        assertEquals(2, lru.get(2));
        lru.set(4, 4);
        assertEquals(-1, lru.get(3));
    }

}