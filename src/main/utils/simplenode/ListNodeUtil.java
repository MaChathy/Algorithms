package main.utils.simplenode;

import main.day10.string.PalindromeString;

/**
 * 链表工具类
 * @author fisher
 * @version 1.0
 */
public class ListNodeUtil {

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

}
