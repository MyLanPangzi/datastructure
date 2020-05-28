package com.hiscat.ds.list;

/**
 * @author hiscat
 */
public class CircleSingleList {

    private Boy first;
    private int size;

    @org.jetbrains.annotations.Nullable
    @org.jetbrains.annotations.Contract(pure = true)
    public static CircleSingleList make(int size) {
        if (size < 2) {
            return null;
        }
        CircleSingleList result = new CircleSingleList();
        Boy cur = null;
        for (int i = 1; i <= size; i++) {
            Boy boy = new Boy(i);
            if (result.first == null) {
                result.first = boy;
                boy.next = boy;
                cur = boy;
            } else {
                //noinspection ConstantConditions
                cur.next = boy;
                boy.next = result.first;
                cur = boy;
            }
        }
        result.size = size;
        return result;
    }

    public void play(int startNo, int count) {
        if (isEmpty() || startNo > size || count < 1) {
            return;
        }

        Boy cur = resetLocation(startNo);
        System.out.println(cur);
        System.out.println();
        while (true) {
            //跑到出队的前一个位置
            for (int i = 0; i < count - 2; i++) {
                cur = cur.next;
            }
            System.out.println(cur.next);
            //如果剩一个了，终止
            if (cur.next == cur) {
                break;
            }
            //出队前一个的下一个等于，出队的下一个，
            cur.next = cur.next.next;
            //继续数数
            cur = cur.next;
        }
    }

    private Boy resetLocation(int startNo) {
        Boy cur = first;
        for (int i = 0; i < startNo - 1; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void show() {
        if (isEmpty()) {
            return;
        }

        Boy cur = first;
        do {
            System.out.println(cur);
            cur = cur.next;
        } while (cur != first);
    }

    public static class Boy {
        private int no;
        private Boy next;

        @Override
        public String toString() {
            return "Boy{" +
                    "no=" + no +
                    '}';
        }

        public Boy(int no) {
            this.no = no;
        }
    }
}
