package com.hiscat.ds.list;

import com.hiscat.ds.list.DoubleLinkedList.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    @Test
    void add() {
        DoubleLinkedList list = new DoubleLinkedList();
        assertTrue(list.add(new Node(1, "1")));
        assertTrue(list.add(new Node(2, "2")));
    }

    @Test
    void remove() {
        DoubleLinkedList list = new DoubleLinkedList();
        assertTrue(list.add(new Node(1, "1")));
        assertTrue(list.add(new Node(2, "2")));
        assertTrue(list.remove(1));
        assertTrue(list.remove(new Node(2, "2")));
    }

    @Test
    void update() {
        DoubleLinkedList list = new DoubleLinkedList();
        assertTrue(list.add(new Node(1, "1")));
        assertTrue(list.add(new Node(2, "2")));
        assertTrue(list.update(new Node(2, "3")));
    }


    @Test
    void show() {
        DoubleLinkedList list = new DoubleLinkedList();
        assertTrue(list.add(new Node(1, "1")));
        assertTrue(list.add(new Node(2, "2")));
        list.show();
    }

    @Test
    void isEmpty() {
        DoubleLinkedList list = new DoubleLinkedList();
        assertTrue(list.isEmpty());
    }

    @Test
    void size() {
        DoubleLinkedList list = new DoubleLinkedList();
        assertTrue(list.add(new Node(1, "1")));
        assertTrue(list.add(new Node(2, "2")));
        assertEquals(2, list.size());
    }

    @Test
    void addOrdered() {
        DoubleLinkedList list = new DoubleLinkedList();
        Node one = new Node(1, "1");
        assertTrue(list.addOrdered(one));
        Node four = new Node(4, "4");
        assertTrue(list.addOrdered(four));
        assertTrue(list.addOrdered(new Node(3, "3")));
        assertTrue(list.addOrdered(new Node(2, "2")));
        assertEquals(one, list.first());
        assertEquals(four, list.last());
        list.show();

    }
}