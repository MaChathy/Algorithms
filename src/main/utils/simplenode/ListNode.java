package main.utils.simplenode;

/**
 * 简单单向链表类
 * @author fisher
 * @version 1.0.1 2023/9/7 - 18:58
 */
public class ListNode {
    public int val;
    public ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 获取第n个位置的链表节点数据
     * @param listNode <code>ListNode</code>-单向链表
     * @param n <code>int</code>-第n个链表节点的位置
     * @return <code>int</code>-若第n个位置的链表接存在，返回其节点数据；否则返回-1
     */
    public static int selectNumberN(ListNode listNode, int n){

        ListNode head = new ListNode(-1);
        head.next = listNode;

        if (head.next == null){
            return -1;
        }

        while(n > 0 && head.next != null){
            head = head.next;
            n--;
        }
        return head.next == null ? -1 : head.val;
    }

    /**
     * 在index位置后插入新节点
     * @param listNode <code>ListNode</code>-要执行插入节点的单向链表类
     * @param index <code>int</code>-要执行插入节点
     * @param value <code>int</code>-执行插入节点的数据
     * @return <code>boolean</code>-若插入成功，返回true;否则返回false
     */
    public static boolean insertIntoIndex(ListNode listNode,int index,int value){
        ListNode head = listNode;
        while(head.next != null ){
            head = head.next;
            if (index == 0){
                ListNode node = new ListNode(value);
                node.next = head.next.next;
                head.next = node;
            }
            index--;
        }
        return true;
    }


}
