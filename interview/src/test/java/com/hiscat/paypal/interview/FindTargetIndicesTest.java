package com.hiscat.paypal.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTargetIndicesTest {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * Example:
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */
    @Test
    void findIndices() {
        assertArrayEquals(new int[]{0, 1}, FindTargetIndices.findIndices(new int[]{2, 7, 11, 15}, 9));
    }
}