package main.day4;

import main.utils.simplenode.ListNode;

/**
 * 删除链表的节点<br/>
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。<br/>
 * 返回删除后的链表的头节点.<br/>
 * @author fisher
 * @version 1.0.1 2023/9/7 - 18:54
 */
public class DeleteNode {

    /**
     * 输入：{2,5,1,9},5<br>
     * 输出：{2,1,9}<br>
     *
     *
     * @param head ListNode类
     * @param val int整型
     * @return ListNode类
     */
    public ListNode deleteNode (ListNode head, int val) {
        // write code here
        ListNode node = head;
        while (node.next != null){
            if(node.val == val){
                node = node.next;
                return node;
            }
            else if (node.next.val == val){
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return head;
    }

}

