package com.hiscat.ds;

import com.hiscat.ds.list.SingleLinkedList;
import com.hiscat.ds.list.SingleLinkedList.HeroNode;
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
        assertEquals(head, list.first());
        assertEquals(tail, list.last());
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
        System.out.println(list.first());
        System.out.println(list.last());
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

    @Test
    void testLastIndex() {
        SingleLinkedList list = new SingleLinkedList();
        HeroNode last4 = new HeroNode(1, "1", "1");
        HeroNode last3 = new HeroNode(2, "2", "2");
        HeroNode last2 = new HeroNode(3, "3", "3");
        HeroNode last1 = new HeroNode(4, "4", "4");
        list.add(last1);
        list.add(last2);
        list.add(last3);
        list.add(last4);
        assertEquals(last1, list.lastIndex(1));
        assertEquals(last2, list.lastIndex(2));
        assertEquals(last3, list.lastIndex(3));
        assertEquals(last4, list.lastIndex(4));
        assertEquals(list.last(), list.lastIndex(1));
    }

    @Test
    void testReverse() {
        SingleLinkedList list = new SingleLinkedList();
        HeroNode one = new HeroNode(1, "1", "1");
        HeroNode two = new HeroNode(2, "2", "2");
        HeroNode three = new HeroNode(3, "3", "3");
        list.add(three);
        list.add(two);
        list.add(one);
        list.reverse();
        list.show();
        assertEquals(three, list.first());
        assertEquals(one, list.last());
    }

    @Test
    void testReversePrint() {
        SingleLinkedList list = new SingleLinkedList();
        list.add(new HeroNode(1, "1", "1"));
        list.add(new HeroNode(2, "2", "2"));
        list.add(new HeroNode(3, "3", "3"));
        list.reversePrint();
        System.out.println();
        list.reversePrint2();
    }

    @Test
    void testMiddleElement() {
        SingleLinkedList list = new SingleLinkedList();
        list.add(new HeroNode(1, "1", "1"));
        HeroNode two = new HeroNode(2, "2", "2");
        list.add(two);
        HeroNode three = new HeroNode(3, "3", "3");
        list.add(three);
        assertEquals(two, list.middle());
        list.add(new HeroNode(4, "4", "4"));
        assertEquals(two, list.middle());
        list.add(new HeroNode(5, "5", "5"));
        assertEquals(three, list.middle());
    }

    @Test
    void testMerge() {
        SingleLinkedList list1 = new SingleLinkedList();
        HeroNode one = new HeroNode(1, "1", "1");
        list1.add(one);
        HeroNode three = new HeroNode(3, "3", "3");
        list1.add(three);
        list1.add(new HeroNode(5, "5", "5"));

        SingleLinkedList list2 = new SingleLinkedList();
        list2.add(new HeroNode(2, "2", "2"));
        list2.add(new HeroNode(4, "4", "4"));
        HeroNode six = new HeroNode(6, "6", "6");
        list2.add(six);

        SingleLinkedList merge = list1.merge(list2);
        assertEquals(one, merge.first());
        assertEquals(six, merge.last());
        assertEquals(three, merge.middle());
    }
}