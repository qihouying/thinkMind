package com.qhy.insist.three;

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
    //Method1:使用栈
    public ListNode method(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
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
            ListNode temp = new ListNode(sum % 10);
            carry = sum / 10;
            temp.next = result.next;
            result.next = temp;
            stack1.pop();
            stack2.pop();
        }
        while (!stack1.isEmpty()) {
            int sum = stack1.peek() + carry;
            ListNode temp = new ListNode(sum % 10);
            carry = sum / 10;
            temp.next = result.next;
            result.next = temp;
            stack1.pop();
        }
        while (!stack2.isEmpty()) {
            int sum = stack2.peek() + carry;
            ListNode temp = new ListNode(sum % 10);
            carry = sum / 10;
            temp.next = result.next;
            result.next = temp;
            stack2.pop();
        }
        return result.next;
    }

    /**
     * Method2:递归
     * 递归其实也是用栈来保存每一个状态，那么也就可以实现从后往前取数字，我们首先统计出两个链表长度，然后根据长度来调用递归函数，
     * 需要传一个参数差值，递归函数参数中的l1链表长度长于l2，在递归函数中，我们建立一个节点res，如果差值不为0，节点值为l1的值，如果为0，
     * 那么就是l1和l2的和，然后在根据差值分别调用递归函数求出节点post，然后要处理进位，如果post的值大于9，那么对10取余，且res的值自增1，
     * 然后把pos连到res后面，返回res，最后回到原函数中，我们仍要处理进位情况
     */
    public ListNode method2(ListNode l1, ListNode l2) {
            int n1 = getLength(l1), n2 = getLength(l2);
            //生成一个头结点
            ListNode head = new ListNode(1);
            head.next = (n1 > n2) ? helper(l1, l2, n1 - n2) : helper(l2, l1, n2 - n1);
            if (head.next.num > 9) {
                head.next.num %= 10;
                return head;
            }
            return head.next;
        }
        int getLength(ListNode head) {
            int cnt = 0;
            while (null != head) {
                ++cnt;
                head = head.next;
            }
            return cnt;
        }
        ListNode helper(ListNode l1, ListNode l2, int diff) {
            if (null == l1) return null;
            ListNode res = (diff == 0) ? new ListNode(l1.num + l2.num) : new ListNode(l1.num);
            ListNode post = (diff == 0) ? helper(l1.next, l2.next, 0) : helper(l1.next, l2, diff - 1);
            if (null != post && post.num > 9) {
                post.num %= 10;
                ++res.num;
            }
            res.next = post;
            return res;
        }

    /**
     * Method3:
     * 这种方法借鉴了Plus One Linked List中的解法三，在处理加1问题时，我们需要找出右起第一个不等于9的位置，然后此位置值自增1，
     * 之后的全部赋为0。这里我们同样要先算出两个链表的长度，我们把其中较长的放在l1，然后我们算出两个链表长度差diff。如果diff大于0，
     * 我们用l1的值新建节点，并连在cur节点后(cur节点初始化时指向dummy节点)。并且如果l1的值不等于9，那么right节点也指向这个新建的节点，
     * 然后cur和l1都分别后移一位，diff自减1。当diff为0后，我们循环遍历，将此时l1和l2的值加起来放入变量val中，如果val大于9，那么val对10取余，
     * right节点自增1，将right后面节点全赋值为0。在cur节点后新建节点，节点值为更新后的val，如果val的值不等于9，那么right节点也指向这个新建的节点，
     * 然后cur，l1和l2都分别后移一位。最后我们看dummy节点值若为1，返回dummy节点，如果是0，则返回dummy的下一个节点
      * @param l1
     * @param l2
     * @return
     */
    public ListNode method3(ListNode l1, ListNode l2) {

    }



    class ListNode {
        int num;
        ListNode next;

        public ListNode(int num) {
            this.num = num;
        }
    }




    public static void main(String[] args) {
        AddTwoNumbersII_445 addTwoNum = new AddTwoNumbersII_445();
        AddTwoNumbersII_445.ListNode l1 = addTwoNum.new ListNode(7);
        AddTwoNumbersII_445.ListNode p = l1;
        AddTwoNumbersII_445.ListNode t1 = addTwoNum.new ListNode(2);
        p.next = t1;
        p = t1;
        AddTwoNumbersII_445.ListNode t2 = addTwoNum.new ListNode(4);
        p.next = t2;
        p = t2;
        AddTwoNumbersII_445.ListNode t3 = addTwoNum.new ListNode(3);
        p.next = t3;
        p = t3;

        AddTwoNumbersII_445.ListNode l2 = addTwoNum.new ListNode(5);
        AddTwoNumbersII_445.ListNode q = l2;
        AddTwoNumbersII_445.ListNode s = addTwoNum.new ListNode(6);
        q.next = s;
        q = s;
        AddTwoNumbersII_445.ListNode s2 = addTwoNum.new ListNode(4);
        q.next = s2;
        q = s2;

        ListNode l3 = addTwoNum.method(l1, l2);
        while (null != l3) {
            System.out.print(l3.num);
            l3 = l3.next;
        }

        System.out.println();

        ListNode l4 = addTwoNum.method2(l1, l2);
        while (null != l4) {
            System.out.print(l4.num);
            l4 = l4.next;
        }
    }
}
