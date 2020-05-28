package com.hiscat.ds.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    @Test
    void isFull() {
        assertFalse(new ArrayStack(1).isFull());
    }

    @Test
    void isEmpty() {
        assertTrue(new ArrayStack(1).isEmpty());
    }

    @Test
    void push() {
        ArrayStack stack = new ArrayStack(10);
        assertTrue(stack.push(1));
    }

    @Test
    void peek() {
        ArrayStack stack = new ArrayStack(10);
        assertTrue(stack.push(1));
        assertEquals(1, stack.peek());
        assertThrows(RuntimeException.class, () -> new ArrayStack(1).peek());
    }

    @Test
    void pop() {
        ArrayStack stack = new ArrayStack(10);
        assertTrue(stack.push(1));
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void size() {
        ArrayStack stack = new ArrayStack(10);
        assertTrue(stack.push(1));
        assertEquals(1, stack.size());
    }
}