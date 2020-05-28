package com.hiscat.ds.queue;

/**
 * @author hiscat
 */
public class CircleQueue {
    private int head;
    private int tail;
    private int maxSize;
    private int[] elements;
    private int size;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        elements = new int[maxSize];
        head = tail = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public boolean put(int i) {
        if (isFull()) {
            return false;
        }
        tail = (tail + 1) % maxSize;
        elements[tail] = i;
        size++;
        return true;
    }

    public int take() {
        if (isEmpty()) {
            throw new NullPointerException("queue is empty!");
        }
        size--;
        head = (head + 1) % maxSize;
        return elements[head];
    }

    public int peek() {
        return elements[(head + 1) % maxSize];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("queue is empty!");
            return;
        }
        for (int index = head; index < head + size; index++) {
            System.out.printf("arr[%d]=%d", index % maxSize, elements[index % maxSize]);
        }
    }

    public int size() {
        return this.size;
    }
}
