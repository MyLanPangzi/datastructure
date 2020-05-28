package com.hiscat.ds.queue;

/**
 * @author hiscat
 */
public class ArrayQueue {
    private int head;
    private int tail;
    private int maxSize;
    private int[] elements;
    private int size;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        elements = new int[maxSize];
        head = tail = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return tail == maxSize - 1;
    }

    public boolean put(int i) {
        if (isFull()) {
            return false;
        }
        elements[++tail] = i;
        size++;
        return true;
    }

    public int take() {
        if (isEmpty()) {
            throw new NullPointerException("queue is empty!");
        }
        size--;
        return elements[++head];
    }

    public int peek() {
        return elements[head + 1];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("queue is empty!");
            return;
        }
        for (int index = 0; index < elements.length; index++) {
            System.out.printf("arr[%d]=%d", index, elements[index]);
        }
    }

    public int size() {
        return this.size;
    }
}
