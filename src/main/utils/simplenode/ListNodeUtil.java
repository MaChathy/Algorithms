package main.utils.simplenode;

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
     * &nbsp;&nbsp;&nbsp;&nbsp;<code>1 -> 2 -> -> 3 -> 4 -> 5 -> 6 -> null</code><br><br>
     * @return <code>ListNode</code>-有6个节点的单链表
     */
    public static ListNode initializeSimpleNode(){
        ListNode head = new ListNode(1);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int value = 1;
        for (int i = 0;i < 5;i++){
            dummy = dummy.next;
            dummy.next = new ListNode(++value);
        }
        return head;
    }
}
