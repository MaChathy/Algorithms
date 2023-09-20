package main.day13.listnode;

import main.utils.simplenode.ListNode;
import main.utils.simplenode.ListNodeUtil;

/**
 * 回文链表<br>
 * @author fisher
 * @version 1.0
 */
public class PalindromeList {

    /**
     * 给定一个单链表，判断链表是否是回文链表<br>
     * 关键：<br>
     * 将链表分成前后两段
     * @param head <code>ListNode</code>-
     * @return <code>boolean</code>-若是回文链表，返回true；否则，返回false
     */
    public boolean validPalindromeList(ListNode head){
        ListNode back = head;
        ListNode front = back.next;
        while (front != null){
            front = front.next.next;
            back = back.next;
        }

        ListNode temp = back.next;
        back.next = null;

        ListNode reverseBackNode = ListNodeUtil.reverseNode(back);

        while(head != null && reverseBackNode != null){
            if (head.val != back.val){
                return false;
            }
            head = head.next;
            reverseBackNode = reverseBackNode.next;
        }

        return false;
    }

}
