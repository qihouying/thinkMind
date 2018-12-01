package com.qhy.practice.a20181026.similar.addTwoNumbersII_445;

import com.qhy.practice.a20181026.similar.addTwoNumbers_2.*;

import java.util.Stack;

/**
 * Created by dream on 2018/10/28.
 *
 * use stack
 */
public class Solution2 {
    public ListNode addTowNumbersII(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        ListNode p1 = l1, p2 = l2;
        ListNode head = null;
        int carry = 0;
        while (p1 != null) {
            stack1.push(p1.val);
            p1 = p1.next;
        }
        while (p2 != null) {
            stack2.push(p2.val);
            p2 = p2.next;
        }

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int a = !stack1.isEmpty() ? stack1.pop() : 0;
            int b = !stack2.isEmpty() ? stack2.pop() : 0;
            int sum = a + b + carry;
            int res = sum % 10;

            ListNode node = new ListNode(res);
            node.next = head;
            head = node;

            carry = sum / 10;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(7);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);
        listNode1.next.next.next = new ListNode(3);


        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);

        Solution2 solution = new Solution2();
        ListNode listNode = solution.addTowNumbersII(listNode1, listNode2);
        ListNode p = listNode;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
