package com.hiscat.paypal.interview;

import com.hiscat.paypal.interview.MergeSortedList.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedListTest {

    /**
     * Merge two sorted lists
     * Example:
     * Input:      1 ->  2 ->  4,   1  ->  3  ->  4
     * Output:     1 ->  1  ->  2  ->  3  ->  4  ->  4
     */
    @Test
    void testMerge() {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(4);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);
        assertSame(n2, MergeSortedList.merge(n1, n2));

        n2.print();
        assertEquals(1, n2.val);
        assertEquals(1, n2.next.val);
        assertEquals(2, n2.next.next.val);
        assertEquals(3, n2.next.next.next.val);
        assertEquals(4, n2.next.next.next.next.val);
        assertEquals(4, n2.next.next.next.next.next.val);

    }
}