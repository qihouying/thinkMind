package com.qhy.practice_01.AddTwoNumbers;

/**
 * Created by dream on 2018/9/13.
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;

        while(null != p || null != q || 0 != carry) {
            int x = (null != p) ? p.val : 0;
            int y = (null != q) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (null != p)
                p = p.next;
            if (null != q)
                q = q.next;
        }
        if (carry > 0)
            curr.next = new ListNode(carry);
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(2);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(5);

        ListNode result = Solution.addTwoNumbers(l1, l2);
        while (null != result) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
