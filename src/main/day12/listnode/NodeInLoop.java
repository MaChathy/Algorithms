package main.day12.listnode;

import main.utils.simplenode.ListNode;
import main.utils.simplenode.ListNodeUtil;
import org.w3c.dom.ls.LSInput;

/**
 * 链表中环的入口
 * @author fisher
 * @version 1.0
 */
public class NodeInLoop {

    /**
     * 若一个链表包含环，找出环的入口节点<br>
     * <br>
     * 通多设置双指针解决<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;先找出链表中在环中的节点<code>nodeInLoop;</code><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;设置p1指针指向<code>nodeInLoop</code>节点，p2指针指向链表第一个节点;<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;右移p1，p2指针，当p1，p2指针相遇时，指向的节点就是环的入口节点.<br>
     * <br>
     * @param head <code>ListNode</code>-单链表
     * @return <code>ListNode</code>-若找到，返回链表中环的入口节点;否则返回<code>null</code>
     */
    public ListNode detectCycle(ListNode head){
        ListNode nodeInLoop = getNodeInLoop(head);
        if (nodeInLoop == null){
            return null;
        }
        ListNode node = head;
        while(node != nodeInLoop){
            node = node.next;
            nodeInLoop = nodeInLoop.next;
        }
        return node;
    }


    /**
     * 找出链表中在环中的节点<br><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;快慢指针找出链表环中的节点：<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;设置快慢两个指针，快指针一次右移两步，慢指针一次右移一步<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;遍历链表两个指针相遇所指向的节点就在环中<br>
     * <br>
     * @param head <code>ListNode</code>-单链表
     * @return <code>ListNode</code>-若找到返回节点，否则返回<code>null</code>
     */
    private ListNode getNodeInLoop(ListNode head){
        //若链表长度小于等于1返回空
        if (head == null || head.next == null){
            return null;
        }

        ListNode slow = head.next;
        ListNode fast = slow.next;

        while (fast != null && slow != null) {
            if (fast == slow){
                return slow;
            }
            fast = fast.next;
            slow = slow.next;
            if (fast != null){
                fast = fast.next;
            }
        }

        return null;
    }

}
