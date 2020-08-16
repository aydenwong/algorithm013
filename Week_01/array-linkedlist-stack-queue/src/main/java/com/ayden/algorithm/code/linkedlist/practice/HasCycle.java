package com.ayden.algorithm.code.linkedlist.practice;

import com.ayden.algorithm.code.linkedlist.study.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 环形链表
 * @author: aydenwang
 * @create: 2020-08-05 21:52
 * @version: 1.0.0
 **/
public class HasCycle {

    public boolean hasCycleHash(ListNode head) {
        Set<ListNode> set = new HashSet();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycleFast(ListNode head) {
        //判断头结点及头结点后一个节点是否为空
        if (head == null && head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            //判断快节点，因为快节点会先到达尾部。有可能是到达尾结点，或者直接到达空节点。
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
