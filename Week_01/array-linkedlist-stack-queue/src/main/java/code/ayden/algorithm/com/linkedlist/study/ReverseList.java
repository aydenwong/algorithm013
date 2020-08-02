package code.ayden.algorithm.com.linkedlist.study;

/**
 * @description: 反转链表
 * @author: aydenwang
 * @create: 2020-07-29 08:35
 * @version: 1.0.0
 **/
public class ReverseList {

    /**
     * 通过循环的方式，反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 节点本来没有引用上一个节点，需要一个节点保存前一个节点
        ListNode prev = null;
        ListNode curr = head;
        //下一个节点不为空
        while (curr != null) {
            // 更改引用前，保存当前节点的下一个节点
            ListNode tempListNode = curr.next;
            //更改引用指向前一个节点
            curr.next = prev;
            //当前节点成为下一次循环的前一个节点
            prev = curr;
            //当前节点的下一个节点，成为下次循环的当前节点
            curr = tempListNode;
        }
        // 如果当前节点为空，返回当前节点的前一个节点，也就是原来的链尾，现在的链头
        return prev;
    }


    /**
     * reverseList: head=1
     *     reverseList: head=2
     * 	      reverseList: head=3
     * 		    reverseList:head=4
     * 			    reverseList:head=5
     * 					终止返回
     * 				cur = 5
     * 				4.next.next->4，即5->4
     * 			cur=5
     * 			3.next.next->3，即4->3
     * 		cur = 5
     * 		2.next.next->2，即3->2
     * 	cur = 5
     * 	1.next.next->1，即2->1
     * @param head
     * @return
     */
    public ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


}
