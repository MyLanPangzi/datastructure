package com.hiscat.paypal.interview;

/**
 * @author hiscat
 */
public class DeduplicateSortedLinkedList {

    public static void deduplicate(ListNode node) {
        //记住当前节点，一直往下跑，如果下个节点与当前节点值相等，则跳过
        while (node != null) {
            ListNode next = node.next;
            while (next != null && next.val == node.val) {
                next = next.next;
            }
            node.next = next;
            node = next;
        }
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        void print() {
            ListNode tmp = this;
            do {
                System.out.println(tmp.val);
                tmp = tmp.next;
            } while (tmp != null);
        }

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
