package com.hiscat.paypal.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindUniqueStringIndexTest {

    /**
     * First Unique Character in a String
     * Given a string, find the first non-repeating character in it and return it’s index. If it doesn’t exist,
     * Return -1.
     * Examples:
     * S = “leetcode”
     * Return 0.
     * <p>
     * S = “loveleetcode”
     * Return 2.
     */
    @Test
    void findIndex() {
        assertEquals(0, FindUniqueStringIndex.findIndex("leetcode"));
        assertEquals(2, FindUniqueStringIndex.findIndex("loveleetcode"));
        assertEquals(-1, FindUniqueStringIndex.findIndex("aaaa"));
    }
}