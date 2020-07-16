package com.hiscat.paypal.interview;

import java.util.AbstractMap;
import java.util.Arrays;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author hiscat
 */
public class FindMajorityElement {
    public static int findMajorityElement(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .collect(groupingBy(i -> i, counting()))
                .entrySet()
                .stream()
                .max(comparingByValue())
                .orElseGet(() -> new AbstractMap.SimpleEntry<>(Integer.MAX_VALUE, Long.MIN_VALUE))
                .getKey();
    }
}
