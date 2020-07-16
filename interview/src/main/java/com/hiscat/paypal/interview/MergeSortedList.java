package com.hiscat.paypal.interview;

/**
 * @author hiscat
 */
public class MergeSortedList {

    public static ListNode merge(ListNode n1, ListNode n2) {
        ListNode head = n1.val < n2.val ? n1 : n2;
        ListNode max = n1.val < n2.val ? n2 : n1;
        ListNode pre = head;

        //第一步，找到返回得头节点，较小值作为头节点
        //第二步，找到较大值作为待插入链表
        //第三步，遍历待插入链表，
        //第四步，为待插入链表得节点找到合适得位置
        //  找到第一个大于待插入节点得节点位置，pre
        while (max != null) {
            ListNode tmp = max.next;
            while (pre.next != null && pre.next.val < max.val) {
                pre = pre.next;
            }
            max.next = pre.next;
            pre.next = max;
            max = tmp;
        }

        return head;
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
