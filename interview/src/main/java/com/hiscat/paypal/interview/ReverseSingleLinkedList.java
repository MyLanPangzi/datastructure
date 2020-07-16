package com.hiscat.paypal.interview;

/**
 * @author hiscat
 */
public class ReverseSingleLinkedList {

    public static ListNode reverse(ListNode node) {
        if (node.next == null) {
            return node;
        }
        if (node.next.next == null) {
            node.next.next = node;
            ListNode t = node.next;
            t.next = null;
            return t;

        }
        ListNode pre = node;
        ListNode cur = node.next;
        while (cur.next != null) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        cur.next = pre;
        node.next = null;
        return cur;
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
