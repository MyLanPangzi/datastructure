package com.hiscat.ds.stack;

/**
 * @author hiscat
 */
public class LinkedListStack {
    private int size;
    private Node top;


    public boolean isEmpty() {
        return size == 0;
    }

    public boolean push(int i) {
        Node node = new Node(i);
        node.next = top;
        top = node;
        size++;
        return true;
    }


    public int peek() {
        checkEmpty();
        return top.element;
    }

    public int pop() {
        checkEmpty();
        int element = top.element;
        top = top.next;
        size--;
        return element;
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
    }

    public int size() {
        return size;
    }


    public static class Node {
        private int element;
        private Node next;

        public Node(int element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    '}';
        }
    }
}
