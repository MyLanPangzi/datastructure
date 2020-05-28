package com.hiscat.ds.list;

/**
 * @author hiscat
 */
public class DoubleLinkedList {
    private Node head = new Node(0, "");
    private Node tail;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Node first() {
        return head.next;
    }

    public Node last() {
        return tail;
    }

    public boolean addOrdered(Node node) {
        if (isEmpty()) {
            head.next = node;
            node.pre = head;
            size++;
            tail = node;
            return true;
        }

        if (node.no > tail.no) {
            size++;
            tail.next = node;
            node.pre = tail;
            tail = node;
            return true;
        }

        Node next = head.next;
        while (next != null && next.no < node.no) {
            next = next.next;
        }
        if (next == null || next.no == node.no) {
            return false;
        }
        next.pre.next = node;
        node.pre = next.pre;
        next.pre = node;
        node.next = next;
        size++;
        return true;
    }

    public boolean add(Node node) {
        if (node == null) {
            return false;
        }
        if (isEmpty()) {
            head.next = node;
            node.pre = head;
            tail = node;
            size++;
            return true;
        }
        tail.next = node;
        node.pre = tail;
        tail = node;
        size++;
        return true;
    }

    public boolean remove(int no) {
        if (isEmpty()) {
            return false;
        }
        Node next = head.next;
        boolean find = false;
        while (next != null) {
            if (next.no == no) {
                find = true;
                break;
            }
            next = next.next;
        }
        if (!find) {
            return false;
        }

        next.pre.next = next.next;
        if (next.next != null) {
            next.next.pre = next.pre;
        }
        size--;
        return true;
    }

    public boolean remove(Node node) {
        return remove(node.no);
    }

    public boolean update(Node node) {
        Node next = head.next;
        boolean find = false;
        while (next != null) {
            if (next.no == node.no) {
                find = true;
                break;
            }
            next = next.next;
        }
        if (!find) {
            return false;
        }
        next.name = node.name;
        return true;
    }


    public void show() {
        Node next = head.next;
        while (next != null) {
            System.out.println(next);
            next = next.next;
        }
    }

    public static class Node {
        private int no;
        private String name;
        private Node pre;
        private Node next;

        public Node(Integer no, String name) {
            this.no = no;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
