package com.hiscat.ds.list;

import java.util.LinkedList;

/**
 * @author hiscat
 */
public class SingleLinkedList {

    private final HeroNode head;
    private HeroNode tail;
    private int size;

    public SingleLinkedList() {
        head = new HeroNode(0, "", "");
    }

    public boolean add(HeroNode heroNode) {
        if (heroNode == null) {
            return false;
        }
        if (isEmpty()) {
            head.next = heroNode;
            tail = heroNode;
            size++;
            return true;
        }
        if (heroNode.no == tail.no) {
            System.out.println("已存在序号为" + tail.no + "的英雄");
            return false;
        }
        if (heroNode.no > tail.no) {
            size++;
            tail.next = heroNode;
            tail = heroNode;
            return true;
        }

        HeroNode tmp = head;
        while (tmp.next != null && tmp.next.no < heroNode.no) {
            tmp = tmp.next;
        }
        if (heroNode.no == tmp.no) {
            System.out.println("已存在序号为" + tmp.no + "的英雄");
            return false;
        }
        heroNode.next = tmp.next;
        tmp.next = heroNode;
        size++;
        return true;
    }

    public boolean update(HeroNode heroNode) {
        if (heroNode == null) {
            return false;
        }
        HeroNode tmp = head.next;
        while (tmp != null && tmp.no != heroNode.no) {
            tmp = tmp.next;
        }
        if (tmp == null) {
            System.out.printf("no：%d不存在", heroNode.no);
            return false;
        }
        tmp.name = heroNode.name;
        tmp.nickName = heroNode.nickName;
        return true;
    }

    public boolean delete(int no) {
        if (isEmpty()) {
            return false;
        }
        HeroNode tmp = this.head;
        boolean find = false;
        while (true) {
            if (tmp.next == null) {
                break;
            }
            if (tmp.next.no == no) {
                find = true;
                break;
            }
            tmp = tmp.next;
        }
        if (find) {
            if (tmp.next == tail) {
                tail = null;
            }
            tmp.next = tmp.next.next;
            size--;
        }
        return find;
    }


    public boolean delete(HeroNode heroNode) {
        if (heroNode == null) {
            return false;
        }
        return this.delete(heroNode.no);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public HeroNode last() {
        return tail;
    }

    public HeroNode first() {
        return head.next;
    }

    public int size() {
        return size;
    }

    public void show() {
        HeroNode tmp = head.next;
        while (tmp != null) {
            System.out.println(tmp);
            tmp = tmp.next;
        }
    }

    public HeroNode lastIndex(int index) {
        if (isEmpty()) {
            return null;
        }
        HeroNode tmp = head.next;
        int i = 0;
        while (i < index && tmp != null) {
            i++;
            tmp = tmp.next;
        }
        if (i != index) {
            return null;
        }

        return findLastIndexNode(tmp);
    }

    private HeroNode findLastIndexNode(HeroNode tmp) {
        HeroNode tmp2 = head.next;
        while (tmp != null) {
            tmp = tmp.next;
            tmp2 = tmp2.next;
        }
        return tmp2;
    }

    public void reverse() {
        if (isEmpty() || size == 1) {
            return;
        }
        //from second
        HeroNode next, cur = head.next.next;
        head.next.next = null;
        tail = head.next;
        while (cur != null) {
            next = cur.next;

            cur.next = head.next;
            head.next = cur;

            cur = next;
        }

    }

    public void reversePrint() {
        if (isEmpty()) {
            return;
        }
        print(head.next);
    }

    private void print(HeroNode next) {
        if (next.next != null) {
            print(next.next);
        }
        System.out.println(next);
    }

    public void reversePrint2() {
        if (isEmpty()) {
            return;
        }
        LinkedList<HeroNode> stack = new LinkedList<>();
        HeroNode next = head.next;
        while (next != null) {
            stack.add(next);
            next = next.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.removeLast());
        }
    }

    public HeroNode middle() {
        if (isEmpty()) {
            return null;
        }
        if (size == 1) {
            return first();
        }

        HeroNode middle = head.next;
        HeroNode next2 = head.next;
        while (middle != null && next2.next != null && next2.next.next != null) {
            middle = middle.next;
            next2 = next2.next.next;
        }
        return middle;
    }

    public SingleLinkedList merge(SingleLinkedList list2) {
        SingleLinkedList result = new SingleLinkedList();

        HeroNode next1 = this.head.next;
        HeroNode next2 = list2.head.next;
        while (next1 != null && next2 != null) {
            if (next1.no < next2.no) {
                result.add(next1);
                next1 = next1.next;
            } else {
                result.add(next2);
                next2 = next2.next;
            }
        }
        while (next1 != null) {
            result.add(next1);
            next1 = next1.next;
        }
        while (next2 != null) {
            result.add(next2);
            next2 = next2.next;
        }

        //list1，list2, head
        //cur1=list1.first cur2=list2.first
        //cur1>cur2
        // true head.next=cur2  cur2=cur2.next
        // false head.next=cur1 cur1=cur1.next
        // cur1 != nul && cur2 !=null
        // cur1 != null append head
        // cur2 != null append head
        return result;
    }


    public static class HeroNode {
        private int no;
        private String name;
        private String nickName;
        private HeroNode next;

        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }

}
