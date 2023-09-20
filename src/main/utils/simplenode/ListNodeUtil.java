package main.utils.simplenode;

import main.day10.string.PalindromeString;

import java.util.LinkedList;
import java.util.List;

/**
 * 链表工具类
 * @author fisher
 * @version 1.0
 */
public class ListNodeUtil {

    /*------------------------------------------static methods---------------------------------------------------*/

    /**
     * 以<br/>
     * &nbsp;&nbsp;&nbsp;&nbsp;<code>node1.val -> node2.val -> ... -> nodeN.val -> null</code><br>
     * 格式,遍历输出单链表的每个节点<br><br>
     * @param head <code>ListNode</code>-单链表
     */
    public static void forEachNode(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while(dummy.next != null){
            dummy = dummy.next;
            System.out.print(dummy.val+" -> ");
        }
        System.out.println("null");
    }

    /**
     * 初始化一个如下图所示的简单单链表：<br><br>
     * &nbsp;&nbsp;&nbsp;&nbsp;<code>1 -> 2 -> -> 3 -> 4 -> 5 -> 6 ->...-> n -> null</code><br><br>
     * @param n <code>int</code>单链表的长度
     * @return <code>ListNode</code>-有n个节点的单链表
     */
    public static ListNode initializeSimpleNode(int n){
        ListNode head = new ListNode(1);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int value = 1;
        for (int i = 0;i < n - 1;i++){
            dummy = dummy.next;
            dummy.next = new ListNode(++value);
        }
        return head;
    }


    /**
     * 输入链表的头节点，反转该链表并输出反转后链表的头节点<br><br>
     * 关键：记录遍历链表时当前节点的下一个节点
     * 时间复杂度：O(n)<br>
     * 空间复杂度:O(1)<br>
     * @param head <code>ListNode</code>-单链表
     * @return <code>ListNode</code>-反转后链表的头节点
     */
    public static ListNode reverseNode(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode nextNode = cur.next;

            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }

    /**
     * 判断两个单链表是否相等<br>
     * 想等条件：两个单链表每个节点的值链表都相等<br>
     * @param head1 <code>ListNode</code> -单链表
     * @param head2 <code>ListNode</code> -单链表
     * @return <code>boolean</code>-若相等返回true;否则返回false
     */
    public static boolean singleListNodeEquals(ListNode head1, ListNode head2){
        while(head1 != null && head2 != null){
            if (head1.val != head2.val){
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1 == null && head2 == null;
    }

    /**
     * 将单链表从中间节点分割，返回链表链<br><br>
     * ex:<br>
     * head : 1 -> 2 -> 3 -> 4 -> ... -> n -> null<br>
     * 若n为偶数，此时分割后的单链表长度相同，两个链表分别为：<br>
     * &nbsp;&nbsp;&nbsp; 1 -> 2 -> 3 -> ... -> n/2 -> null<br>
     * &nbsp;&nbsp;&nbsp; n/2+1 -> n/2+2 -> n/2+3 -> ... -> n -> null<br><br>
     * 若n为奇数，此时分割后的单链表长度相同不同，两个链表分别为：<br>
     * &nbsp;&nbsp;&nbsp; 1 -> 2 -> 3 -> ... -> n/2 -> null<br>
     * &nbsp;&nbsp;&nbsp; n/2+2 -> n/2+3 -> n/2+4 -> ... -> n -> null<br>
     * <br>
     *
     *
     * @param head <code>ListNode</code> 单链表
     * @return <code>List<code><</code>ListNode></code> -只有两个节点的链表链<br>
     * 将从head结点开始的链表作为返回结果链表链的第一个节点，另一个作为第二个节点<br>
     */
    public static List<ListNode> splitListNode(ListNode head){
        List<ListNode> listNodeList = new LinkedList<>();
        ListNode slow = head;
        ListNode fast = head.next;
        // TODO:找出链表中间节点的前一个节点
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        // TODO:若节点个数为奇数,则把temp跳过中间节点
        if (fast.next != null){
            temp = slow.next.next;
        }
        slow.next = null;
        // 此时head的尾节点为中间节点的前一个节点
        listNodeList.add(head);
        listNodeList.add(temp);
        return listNodeList;
    }

}
