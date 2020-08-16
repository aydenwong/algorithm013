package com.ayden.algorithm.code.linkedlist.practice1;

import com.ayden.algorithm.code.linkedlist.study.ListNode;

import javax.net.ssl.SNIHostName;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 判断是否环形链表
 * @author: aydenwang
 * @create: 2020-08-12 20:45
 * @version: 1.0.0
 **/
public class HasCycle {

    /**
     * 思路：
     * 使用hash表存储遍历过的节点，如果有相同的节点，表示有环
     * 时间复杂度：
     * 最坏：O(n)
     * 最好：O(1)
     * 但是不能均摊，所以时间复杂度：O(n)
     * 空间复杂度：
     * O(n)
     * @param head
     * @return
     */
    public boolean hasCycleHash(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }


    /**
     * 思路：
     * 一个快指针走两步，一个慢指针走一步。如果链表存在换环，快慢指针总会相遇。
     * 时间复杂度：
     * 如果不存在环，时间复杂度为O(n/2)=O(n)
     * 如果存在环，时间复杂度O(n+k)，也是O(n)
     * 空间复杂度：
     * O(1)
     * @param head
     * @return
     */
    public boolean hasCycleFast(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (slow == null || fast == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


}
