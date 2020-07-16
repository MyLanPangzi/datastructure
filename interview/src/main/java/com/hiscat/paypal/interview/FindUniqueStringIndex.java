package com.hiscat.paypal.interview;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author hiscat
 */
public class FindUniqueStringIndex {
    public static int findIndex(String s) {
        return s
                .chars()
                .mapToObj(c -> (char) c)
                .collect(groupingBy(ch -> ch, counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> s.indexOf(e.getKey()))
                .min(Integer::compareTo)
                .orElse(-1);

    }
}
