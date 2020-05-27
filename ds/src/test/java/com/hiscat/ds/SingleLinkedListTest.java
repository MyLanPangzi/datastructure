package com.hiscat.ds;

import com.hiscat.ds.SingleLinkedList.HeroNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {
    @Test
    void testAdd() {
        SingleLinkedList list = new SingleLinkedList();
        assertTrue(list.add(new HeroNode(2, "卢俊义", "玉麒麟")));
        HeroNode head = new HeroNode(1, "宋江", "及时雨");
        HeroNode tail = new HeroNode(3, "林冲", "豹子头");
        assertTrue(list.add(tail));
        assertTrue(list.add(head));
        assertEquals(head, list.head());
        assertEquals(tail, list.tail());
    }

    @Test
    void testIsEmpty() {
        SingleLinkedList list = new SingleLinkedList();
        assertTrue(list.isEmpty());
    }

    @Test
    void testSize() {
        SingleLinkedList list = new SingleLinkedList();
        assertTrue(list.add(new HeroNode(1, "宋江", "及时雨")));
        assertEquals(1, list.size());

    }

    @Test
    void testShow() {
        SingleLinkedList list = new SingleLinkedList();
        assertTrue(list.add(new HeroNode(1, "宋江", "及时雨")));
        assertTrue(list.add(new HeroNode(3, "吴用", "智多星")));
        assertTrue(list.add(new HeroNode(4, "公孙胜", "入云龙")));
        assertTrue(list.add(new HeroNode(2, "卢俊义", "玉麒麟")));
        list.show();
        System.out.println();
        System.out.println(list.head());
        System.out.println(list.tail());
    }

    @Test
    void testInsertSameNo() {
        SingleLinkedList list = new SingleLinkedList();
        assertTrue(list.add(new HeroNode(1, "宋江", "及时雨")));
        assertFalse(list.add(new HeroNode(1, "宋江", "及时雨")));
    }

    @Test
    void testUpdate() {
        SingleLinkedList list = new SingleLinkedList();
        assertTrue(list.add(new HeroNode(1, "豹子头", "林冲")));
        assertTrue(list.update(new HeroNode(1, "宋江", "及时雨")));
        assertFalse(list.update(new HeroNode(2, "宋江", "及时雨")));
    }

    @Test
    void testDelete() {
        SingleLinkedList list = new SingleLinkedList();

        assertTrue(list.add(new HeroNode(1, "宋江", "及时雨")));
        assertTrue(list.delete(new HeroNode(1, "宋江", "及时雨")));
        assertTrue(list.add(new HeroNode(1, "宋江", "及时雨")));
        assertTrue(list.delete(1));
        assertFalse(list.delete(new HeroNode(5, "吴用", "智多星")));
        assertFalse(list.delete(5));

    }
}