package main.day12.listnode;

import main.utils.simplenode.ListNode;
import main.utils.simplenode.ListNodeUtil;

/**
 * 链表中的数字相加
 * @author fisher
 * @version 1.0
 */
public class SumNodeNumbers {

    /**
     * 给定两个非负整数单链表，实现这两个整数的相加并把它们的和仍用单链表表示<br>
     * 链表中的每个节点表示整数十进制的一位，并且头节点对应整数的最高位，尾节点对应整数的各位<br><br>
     * @param head1 <code>ListNode</code>-非负整数单链表
     * @param head2 <code>ListNode</code>-非负整数单链表
     * @return <code>ListNode</code>-
     */
    public ListNode addTwoNumbers(ListNode head1,ListNode head2){
        head1 = ListNodeUtil.reverseNode(head1);
        head2 = ListNodeUtil.reverseNode(head2);
        ListNode node = addReverseNode(head1, head2);

        return ListNodeUtil.reverseNode(node);
    }

    /**
     * 链表反转相加
     * @param head1 <code>ListNode</code>
     * @param head2 <code>ListNode</code>
     * @return <code>ListNode</code>
     */
    private ListNode addReverseNode(ListNode head1,ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode sumNode = dummy;
        int carry = 0;
        while(head1 != null || head2 != null){
            int val1 = head1 == null ? 0 : head1.val;
            int val2 = head2 == null ? 0 : head2.val;
            int sum = val1 + val2 + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum -10 : sum;
            head1 = head1 == null ? null : head1.next;
            head2 = head2 == null ? null : head2.next;
            sumNode.next = new ListNode(sum);
            sumNode = sumNode.next;
        }
        if (carry > 0){
            sumNode.next = new ListNode(carry);
        }
        return dummy.next;
    }

/*
    private ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }
*/
}
