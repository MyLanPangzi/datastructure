package com.hiscat.sf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hiscat
 */
public class FindSequence {
    public static boolean hasTwoSequence(int[] arr) {
        List<List<Integer>> sequences = new ArrayList<>(2);
        List<Integer> list = new ArrayList<>();
        sequences.add(list);
        for (int value : arr) {
            if (!list.contains(value)) {
                list.add(value);
            } else {
                list = new ArrayList<>();
                list.add(value);
                sequences.add(list);
            }
            if (sequences.size() > 2) {
                return false;
            }
        }
        return true;
//        return Arrays.stream(arr)
//                .boxed()
//                .collect(groupingBy(i -> i, counting()))
//                .entrySet()
//                .stream()
//                .noneMatch(e -> e.getValue() == 3);
    }
}
