package com.qhy.insist.Third;

import java.util.Stack;

/**
 * @Author houyingqi
 * @Date 2019-09-25 16:21
 * @Description [Medium]
 *
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first
 * and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example:
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 **/
public class AddTwoNumbersII_445 {
    public ListNode method(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        result.next = null;
        int carry = 0;
        if (null == l1)
            return l2;
        if (null == l2)
            return l1;
        ListNode q1 = l1, q2 = l2;
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        while (null != q1) {
            stack1.push(q1.num);
            q1 = q1.next;
        }
        while (null != q2) {
            stack2.push(q2.num);
            q2 = q2.next;
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = stack1.peek() + stack2.peek() + carry;
            ListNode temp = new ListNode();
            temp.num = sum % 10;
            carry = sum / 10;
            temp.next = result.next;
            result.next = temp;
            stack1.pop();
            stack2.pop();
        }
        while (!stack1.isEmpty()) {
            int sum = stack1.peek() + carry;
            ListNode temp = new ListNode();
            temp.num = sum % 10;
            carry = sum / 10;
            temp.next = result.next;
            result.next = temp;
            stack1.pop();
        }
        while (!stack2.isEmpty()) {
            int sum = stack2.peek() + carry;
            ListNode temp = new ListNode();
            temp.num = sum % 10;
            carry = sum / 10;
            temp.next = result.next;
            result.next = temp;
            stack2.pop();
        }
        return result.next;
    }


    class ListNode {
        int num;
        ListNode next;
    }

    public static void main(String[] args) {
        AddTwoNumbersII_445 addTwoNum = new AddTwoNumbersII_445();
        AddTwoNumbersII_445.ListNode l1 = addTwoNum.new ListNode();
        l1.num = 7;
        AddTwoNumbersII_445.ListNode p = l1;
        AddTwoNumbersII_445.ListNode t1 = addTwoNum.new ListNode();
        t1.num = 2;
        p.next = t1;
        p = t1;
        AddTwoNumbersII_445.ListNode t2 = addTwoNum.new ListNode();
        t2.num = 4;
        p.next = t2;
        p = t2;
        AddTwoNumbersII_445.ListNode t3 = addTwoNum.new ListNode();
        t3.num = 3;
        p.next = t3;
        p = t3;

        AddTwoNumbersII_445.ListNode l2 = addTwoNum.new ListNode();
        l2.num = 5;
        AddTwoNumbersII_445.ListNode q = l2;
        AddTwoNumbersII_445.ListNode s = addTwoNum.new ListNode();
        s.num = 6;
        q.next = s;
        q = s;
        AddTwoNumbersII_445.ListNode s2 = addTwoNum.new ListNode();
        s2.num = 4;
        q.next = s2;
        q = s2;

        ListNode l3 = addTwoNum.method(l1, l2);
        while (null != l3) {
            System.out.println(l3.num);
            l3 = l3.next;
        }
    }
}
