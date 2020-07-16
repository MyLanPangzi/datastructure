package com.hiscat.paypal.interview;

import com.hiscat.paypal.interview.ReverseSingleLinkedList.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseSingleLinkedListTest {

    /**
     * 第10题：
     * Reverse a singly linked list
     * Example:
     * Input : 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1
     */
    @Test
    void reverse() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode reverse = ReverseSingleLinkedList.reverse(node);
        assertEquals(5, reverse.val);
        assertEquals(4, reverse.next.val);
        assertEquals(3, reverse.next.next.val);
        assertEquals(2, reverse.next.next.next.val);
        assertEquals(1, reverse.next.next.next.next.val);
    }
}