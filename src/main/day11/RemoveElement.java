package main.day11;

import main.utils.simplenode.ListNode;
import main.utils.simplenode.ListNodeUtil;

import javax.jnlp.ClipboardService;

/**
 * 删除倒数第k个节点<br>
 * 要求一次遍历链表<br>
 * @author fisher
 * @version 1.0
 */
public class RemoveElement {

    /**
     * 删除倒数第k个节点<br>
     * 要求只遍历一次链表<br><br>
     * 双指针解决：<br>
     * &nbsp;&nbsp;1)设置两个指针p1,p2都指向链表的第一个节点<br>
     * &nbsp;&nbsp;2)遍历链表，先将p1指针移动k-1步，p2指针不动<br>
     * &nbsp;&nbsp;3)此时p1指针指向第k个节点，p2指针指向第一个节点，同时右移p1，p2指针<br>
     * &nbsp;&nbsp;4)当p1指针指向最后一个节点时，p2指针指向倒数第k个节点，此时删除p2指向的节点即可<br>
     *
     * 时间复杂度：O(n)<br>
     * 空间复杂度：O(n)<br>
     *
     * @param head <code>ListNode</code>-单链表
     * @param n <code>int</code>-倒数第n个节点
     * @return <code>ListNode</code>-删除删除倒数第k个节点的单链表
     */
    public ListNode removeNthFromEnd(ListNode head,int n){

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode front = dummy;
        ListNode back = dummy;
        for (int i = 0; i < n; i++) {
            front = front.next;
        }
        while(front.next != null){
            front = front.next;
            back = back.next;
        }
        //此时back指向第k个节点,删除第k个节点
        back.next = back.next.next;

        return dummy.next;
    }

}
