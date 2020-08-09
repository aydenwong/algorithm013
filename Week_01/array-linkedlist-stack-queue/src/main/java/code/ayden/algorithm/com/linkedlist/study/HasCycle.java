package code.ayden.algorithm.com.linkedlist.study;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 环形链表问题
 * @author: aydenwang
 * @create: 2020-08-05 21:50
 * @version: 1.0.0
 **/
public class HasCycle {

    public boolean hasCycleHash(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycleFast(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
