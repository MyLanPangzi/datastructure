package com.hiscat.ds;

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

    public HeroNode tail() {
        return tail;
    }

    public HeroNode head() {
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
