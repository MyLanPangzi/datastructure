package com.hiscat.paypal.interview;

import java.util.Arrays;

/**
 * @author hiscat
 */
public class TopN {
    public static int[] topN(int[] arr, int n) {
        if (n > arr.length || arr.length > 10000) {
            throw new IllegalArgumentException("n should not > arr.length or arr.length should not > 10000");
        }
        return Arrays
                .stream(arr)
                .sorted()
                .limit(n)
                .toArray();
    }

}
