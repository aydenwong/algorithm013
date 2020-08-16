package com.ayden.algorithm.code.linkedlist.practice;

import com.ayden.algorithm.code.linkedlist.study.ListNode;

/**
 * @description: 反转链表
 * 1->2->3->4->5->NULL
 * 5->4->3->2->1->NULL
 * @author: aydenwang
 * @create: 2020-08-05 19:16
 * @version: 1.0.0
 **/
public class ReverseList {

    /**
     * 常规for循环方法反转链表
     * 时间复杂度，O(n)，n是链表长度
     * 大O表示法，表示的是数据规模与程序执行时间的增长趋势
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        //链表一旦开始反转,当前节点指向的下一个节点,下一个节点需要反转指向的当前节点，的关联关系都断掉了。
        //所以需要一个节点，保存当前节点的前一个节点，需要另外一个节点，指向当前节点的下一个需要遍历的节点

        ListNode prev = null;
        //ListNode cur = head;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    /**
     * 递归的方式反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseRecursion(ListNode head) {
        // 核心思路，递归的方式最主要是从最后一个节点，层层往前推，因为从最后一个节点起，每个节点的操作都是一样的。
        // 1->2->3->4->5->NULL
        // 获取到最后一个节点后，因为不是双向列表，如何向前遍历成为了问题
        // 递归的思想借助了层层嵌套的栈调用关系，在最里层的方法返回之后，倒数第二层的方法，处理的节点是4，依次类推，可以在每个调用栈，拿到当前应该处理的节点信息

        if (head == null || head.next == null) {
            //什么时候终结递归
            //head.next == null，递归调用栈到5的时候就行了，因为5的指针由4操作
            //head == null,反向调用栈处理到1的时候，1.next =null，所以为null时结束递归

            //return head，解决了从最后一个节点反向递归时，结束的最后一个节点实际是链条表尾，然而程序要求返回的是链表头
            //所以层层通过递归 返回到最外层的调用栈。
            return head;
        }

        ListNode listNode = reverseRecursion(head.next);

        // 节点的下一个节点的next指针，指向当前节点.
        // 4->5
        // 4->5->4
        // 4->null
        // 5->4->null
        head.next.next = head;

        //这一步是最后一个节点1的next，需要指向null
        head.next = null;

        return listNode;
    }

}
