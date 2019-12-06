package com.qhy.insist.math;

/**
 * @Author houyingqi
 * @Date 2019-09-25 16:19
 * @Description [Medium]  Topics: [LinkedList] [Math]
 *
 * You are given two non-empty linked lists representing two non-negative integers. The
 * digits are stored in reverse order and each of their nodes contain a single digit. Add the
 * two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number
 * 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 **/
public class AddTwoNumbers_2 {
    public ListNode method(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode pre = new ListNode();
        ListNode root = pre;
        while(null != l1 || null != l2 || 0 != carry) {
            int sum = ((null == l1) ? 0 : l1.num) + ((null == l2) ? 0: l2.num) + carry;
            ListNode node = new ListNode();
            node.num = sum % 10;
            pre.next = node;
            pre = node;
            carry = sum / 10;
            l1 = (null == l1) ? l1 : l1.next;
            l2 = (null == l2) ? l2 :l2.next;
        }
        return root.next;
    }

    class ListNode {
        int num;
        ListNode next;
    }

    public static void main(String[] args) {
        AddTwoNumbers_2 addTwoNum = new AddTwoNumbers_2();
        AddTwoNumbers_2.ListNode l1 = addTwoNum.new ListNode();
        l1.num = 3;
        AddTwoNumbers_2.ListNode p = l1;
        AddTwoNumbers_2.ListNode t1 = addTwoNum.new ListNode();
        t1.num = 4;
        p.next = t1;
        p = t1;
        AddTwoNumbers_2.ListNode t2 = addTwoNum.new ListNode();
        t2.num = 2;
        p.next = t2;
        p = t2;

        AddTwoNumbers_2.ListNode l2 = addTwoNum.new ListNode();
        l2.num = 4;
        AddTwoNumbers_2.ListNode q = l2;
        AddTwoNumbers_2.ListNode s = addTwoNum.new ListNode();
        s.num = 6;
        q.next = s;
        q = s;
        AddTwoNumbers_2.ListNode s2 = addTwoNum.new ListNode();
        s2.num = 5;
        q.next = s2;
        q = s2;

        System.out.print(l1.num);
        System.out.print(l1.next.num);
        System.out.print(l1.next.next.num);
        System.out.println();

        System.out.print(l2.num);
        System.out.print(l2.next.num);
        System.out.print(l2.next.next.num);
        System.out.println();


        System.out.print(addTwoNum.method(l1, l2).num);
        System.out.print(addTwoNum.method(l1, l2).next.num);
        System.out.print(addTwoNum.method(l1, l2).next.next.num);
    }
}
