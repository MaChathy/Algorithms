package main.day13.listnode;


import main.utils.simplenode.ListNode;
import main.utils.simplenode.ListNodeUtil;

import java.util.List;
import java.util.SplittableRandom;

/**
 * 重组单链表<br>
 * @author fisher
 * @version 1.0
 */
public class NodeCombination {

    /**
     * 给定一个单链表head：<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;1 -> 2 ->3 ->4 -> ... -> n -> null<br>
     * 将head以：<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;1 -> n -> 2 -> n-1 -> 3 -> n-3 -> ... -> null的形式重组。<br><br>
     * 关键：<br>
     * 将链表从中间分成前后两段链表<br>
     * 反转后半段节点<br>
     * 将前半段与反转后的后半段节点相结合<br><br>
     * @param head <code>ListNode</code>-单链表head
     * @return <code>ListNode</code>-重组后的单链表
     */
    public ListNode getTwoListCombination(ListNode head){
        ListNode back = head;
        ListNode front = back.next;
        while(front != null){
            front = front.next.next;
            back = back.next;
        }//此时back指向head的后半段节点
        ListNode temp = back.next;
        back.next = null;
        return combineNodes(new ListNode(-1),head,ListNodeUtil.reverseNode(temp));
    }

    /**
     * 将两个单链表结合,ex:<br><br>
     * <example>
     * &nbsp;&nbsp;&nbsp;&nbsp;node1 : n1 -> n2 -> n3 -> ... -> null<br><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;node2 : N1 -> N2 -> N3 -> ... -> null<br><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;合并后 ： n1 -> N2 -> n2 -> N2 -> n3 -> N3 -> ... -> null
     * </example>
     * @param dummy <code>ListNode</code>-哨兵节点dummy
     * @param node1 <code>ListNode</code>-单链表node1
     * @param node2 <code>ListNode</code>-单链表node2
     * @return <code>ListNode</code>-哨兵节点之后的节点<code>dummy.next</code>
     */
    private ListNode combineNodes(ListNode dummy,ListNode node1,ListNode node2){
        ListNode prev = dummy;
        while (node1 != null && node2 != null){
            ListNode nextNode1 = node1.next;

            prev.next = node1;
            node1.next = node2;
            prev = node2;

            node1 = nextNode1;
            node2 = node2.next;
        }

        if (node1 != null){
            prev.next = node1;
        }
        return dummy.next;
    }

}
