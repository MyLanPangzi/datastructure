package com.hiscat.ds.sort;

/**
 * @author hiscat
 */
public class InsertSort {
    public static void sort(int[] arr) {
        for (int unorderedListIndex = 1; unorderedListIndex < arr.length; unorderedListIndex++) {
            //有序列表带插入下标
            int sortedListIndex = 0;
            while (sortedListIndex < unorderedListIndex && arr[sortedListIndex] < arr[unorderedListIndex]) {
                sortedListIndex++;
            }
            if (unorderedListIndex == sortedListIndex) {
                continue;
            }
            int tmp = arr[unorderedListIndex];
//            while (j < i) {
//                arr[j + 1] = j;
//                j++;
//            }
            System.arraycopy(arr, sortedListIndex, arr, sortedListIndex + 1, unorderedListIndex - sortedListIndex);
            arr[sortedListIndex] = tmp;
        }
    }
}
