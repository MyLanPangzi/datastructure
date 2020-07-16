package com.hiscat.paypal.interview;

import com.hiscat.paypal.interview.DeduplicateSortedLinkedList.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeduplicateSortedLinkedListTest {

    /**
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     * Example 1:
     * Input: 1->1->2
     * Output: 1->2
     * Example 2:
     * Input: 1->1->2->3->3
     * Output: 1->2->3
     */
    @Test
    void deduplicate() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        DeduplicateSortedLinkedList.deduplicate(node);
        assertEquals(1, node.val);
        assertEquals(2, node.next.val);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(1);
        node2.next.next = new ListNode(2);
        node2.next.next.next = new ListNode(3);
        node2.next.next.next.next = new ListNode(3);
        DeduplicateSortedLinkedList.deduplicate(node2);
        assertEquals(1, node2.val);
        assertEquals(2, node2.next.val);
        assertEquals(3, node2.next.next.val);

    }
}