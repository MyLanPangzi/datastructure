package com.hiscat.ds.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListStackTest {

    @Test
    void isEmpty() {
        assertTrue(new LinkedListStack().isEmpty());
    }

    @Test
    void push() {
        LinkedListStack stack = new LinkedListStack();
        assertTrue(stack.push(1));
    }

    @Test
    void peek() {
        LinkedListStack stack = new LinkedListStack();
        assertTrue(stack.push(1));
        assertEquals(1, stack.peek());
    }

    @Test
    void pop() {
        LinkedListStack stack = new LinkedListStack();
        assertTrue(stack.push(1));
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void size() {
        LinkedListStack stack = new LinkedListStack();
        assertTrue(stack.push(1));
        assertEquals(1, stack.size());
    }
}