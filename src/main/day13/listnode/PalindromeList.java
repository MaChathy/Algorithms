package main.day13.listnode;

import main.utils.simplenode.ListNode;
import main.utils.simplenode.ListNodeUtil;

import java.util.List;

/**
 * 回文链表<br>
 * @author fisher
 * @version 1.1
 */
public class PalindromeList {

    /**
     * 给定一个单链表，判断链表是否是回文链表<br><br>
     * 关键：<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;将链表分成前后两段<br><br>
     * @param head <code>ListNode</code> 单链表
     * @return <code>boolean</code> -若是回文链表，返回true；否则，返回false
     * @see ListNodeUtil <code>ListNodeUtil.singleListNodeEquals()</code>
     */
    public boolean validPalindromeList(ListNode head){
        List<ListNode> listNodeList = ListNodeUtil.splitListNode(head);
        /*
        上一行代码等价于如下代码：
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null){
            fast = slow.next.next;
            slow = slow.next;
        }

        ListNode temp = slow.next;
        //fast.next.next == null
        if (fast.next != null){
            temp = slow.next.next;
        }
        slow.next = null;
        */
        return ListNodeUtil.singleListNodeEquals(
                listNodeList.get(0),
                ListNodeUtil.reverseNode(listNodeList.get(1))
        );
    }
}
