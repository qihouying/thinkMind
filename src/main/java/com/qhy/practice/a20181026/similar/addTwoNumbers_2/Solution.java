package com.qhy.practice.a20181026.similar.addTwoNumbers_2;

/**
 * Created by dream on 2018/10/28.
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

   You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     Example:

         Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
         Output: 7 -> 0 -> 8
         Explanation: 342 + 465 = 807.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1=l1, p2 = l2;
        ListNode head = new ListNode(0);
        ListNode q = head;
        int carry = 0;
        while (null != p1 || null != p2 || carry > 0) {
            int sum = ((null == p1) ? 0: p1.val)+ ((null == p2) ? 0: p2.val) + carry;
            ListNode temp = new ListNode(sum%10);
            q.next = temp;
            q = temp;
            if (null != p1) {
                p1 = p1.next;
            }
            if (null != p2) {
                p2 = p2.next;
            }

            carry = sum / 10;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(8);


        ListNode listNode2 = new ListNode(0);

        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers(listNode1, listNode2);
        ListNode p = listNode;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
