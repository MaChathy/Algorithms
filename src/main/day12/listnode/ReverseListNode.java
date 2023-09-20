package main.day12.listnode;

import main.utils.simplenode.ListNode;

/**
 * 反转链表
 * @author fisher
 * @version 1.0
 */
public class ReverseListNode {

    /**
     * 输入链表的头节点，反转该链表并输出反转后链表的头节点<br><br>
     * 关键：记录遍历链表时当前节点的下一个节点
     * 时间复杂度：O(n)<br>
     * 空间复杂度:O(1)<br>
     * @param head <code>ListNode</code>-单链表
     * @return <code>ListNode</code>-反转后链表的头节点
     */
    public static ListNode reverseList(ListNode head){
        //遍历链表时的前一个节点
        ListNode preNode = null;
        //遍历链表时的当前节点
        ListNode curNode = head;

        while (curNode != null){
            //当前节点的下一个节点
            ListNode nextNode = curNode.next;

            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }
}
