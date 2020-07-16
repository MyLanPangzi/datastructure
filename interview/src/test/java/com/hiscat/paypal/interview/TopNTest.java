package com.hiscat.paypal.interview;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class TopNTest {

    //        输入整数数组 arr，找出其中最小的k个数，输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4
    //示例1： 输入： arr=[3,2,1], k=2
    //        输出: [1,2] 或者[2,1]
    //示例2： 输入： arr=[0,1,2,1], k=1
    //       输出：[0]
    //限制：
    //0 <= k  <=  arr.length <= 10000
    //0 <= arr[i] <= 10000
    @Test
    void topN() {
        assertArrayEquals(new int[]{1, 2}, TopN.topN(new int[]{1, 2, 3}, 2));
        assertArrayEquals(new int[]{0}, TopN.topN(new int[]{0, 1, 2, 1}, 1));
        assertThrows(IllegalArgumentException.class, () -> TopN.topN(new int[]{0, 1, 2, 1}, 10));
        assertThrows(IllegalArgumentException.class, () -> TopN.topN(IntStream.rangeClosed(1, 10001).toArray(), 10));
    }
}