package com.hiscat.ds.stack;

/**
 * @author hiscat
 */
public class ArrayStack {
    private int size;
    private int maxSize;
    private int[] elements;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        elements = new int[maxSize];
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean push(int i) {
        if (isFull()) {
            return false;
        }

        elements[size++] = i;
        return true;
    }


    public int peek() {
        checkEmpty();
        return elements[size - 1];
    }

    public int pop() {
        checkEmpty();
        return elements[--size];
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
    }

    public int size() {
        return size;
    }

}
