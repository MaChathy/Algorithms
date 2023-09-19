package main.day12.listnode;

import main.day10.string.PalindromeString;
import main.utils.simplenode.ListNode;
import main.utils.simplenode.ListNodeUtil;

/**
 * 两个链表的第一个重合节点<br>
 * @author fisher
 * @version 1.0
 */
public class IntersectionNode {

    /**
     * 输入两个单向链表，找出它们的第一个重合节点<br><br>
     *
     * 时间复杂度：O(m+n)，m,n分别为链表headA和headB的长度<br>
     * 空间复杂度：O(1)<br>
     * @param headA <code>ListNode</code>-单链表
     * @param headB <code>ListNode</code>-单链表
     * @return <code>ListNode</code>-headA和headB的第一个重合节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        int countA = countList(headA);
        int countB = countList(headB);
        int delta = Math.abs(countA - countB);
        ListNode longer = countA > countB ? headA : headB;
        ListNode shorter = countA > countB ? headB : headA;
        ListNode node1 = longer;
        for (int i = 0; i < delta; i++) {
            node1 = longer.next;
        }
        ListNode node2 = shorter;
        while(node1 != node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    /**
     * 获取单链表的节点个数<br>
     * @param head <code>ListNode</code>-单链表
     * @return <code>int</code>-若单链表不为空腹，返回单链表的节点个数;否者返回0.
     */
    private int countList(ListNode head){
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
