package com.hiscat.ds.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SelectSortTest {

    @Test
    void sort() {
        int[] arr = {3, 2, 4, 1, 5};
        SelectSort.sort(arr);
        assertArrayEquals(arr, new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(arr));
    }
}