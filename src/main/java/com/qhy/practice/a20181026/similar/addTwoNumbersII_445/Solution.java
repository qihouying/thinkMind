package com.qhy.practice.a20181026.similar.addTwoNumbersII_445;

import com.qhy.practice.a20181026.similar.addTwoNumbers_2.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dream on 2018/10/28.
 *
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes ThreeSum and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

   You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     Follow up:
        What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

     Example:

         Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
         Output: 7 -> 8 -> 0 -> 7
 */
public class Solution {
    public ListNode addTowNumbersII(ListNode l1, ListNode l2) {
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        ListNode p1 = l1, p2 = l2;
        ListNode head = null;
        int carry = 0;
        int i = 1, j = 1;
        while (p1 != null) {
            map1.put(i++, p1.val);
            p1 = p1.next;
        }
        while (p2 != null) {
            map2.put(j++, p2.val);
            p2 = p2.next;
        }
        i--;
        j--;

        while (i > 0 || j > 0 || carry > 0) {
            int a = i > 0 ? map1.get(i) : 0;
            int b = j > 0 ? map2.get(j) : 0;
            int sum = a + b + carry;
            int res = sum % 10;

            ListNode node = new ListNode(res);
            node.next = head;
            head = node;

            carry = sum / 10;
            i--;
            j--;
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

        Solution solution = new Solution();
        ListNode listNode = solution.addTowNumbersII(listNode1, listNode2);
        ListNode p = listNode;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}