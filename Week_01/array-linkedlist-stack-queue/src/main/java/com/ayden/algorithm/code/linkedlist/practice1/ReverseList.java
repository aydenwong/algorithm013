package com.ayden.algorithm.code.linkedlist.practice1;

import com.ayden.algorithm.code.linkedlist.study.ListNode;

/**
 * @description: 反转链表
 * @author: aydenwang
 * @create: 2020-08-12 21:12
 * @version: 1.0.0
 **/
public class ReverseList {

    /**
     * 思路：
     * 循环反转：1->2->3->4->5->null  =>  5->4->3->2->1->null
     * 时间复杂度：O(n)
     * 空间复杂度:O(n)
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode temp;
        while (head != null) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

    /**
     * 思路：
     * 1->2->3->4->5->null  =>  5->4->3->2->1->null
     * 操作是当前节点的下一个节点，指向当前节点，递归到节点5，然后一层层出栈到：4，3，2，1
     *
     *
     * @param head
     * @return
     */
    public ListNode reverseListRecursion(ListNode head) {
        // terminator
        if (head == null || head.next == null) {
            //递归到节点5就行了，节点5刚好也是反转后的头结点。
            //一层层的把节点5 return出去
            return head;
        }

        // drill down
        ListNode listNode = reverseListRecursion(head.next);

        // process current logic
        head.next.next = head;
        head.next = null;

        return listNode;
    }

}
