package main.day3;

import main.utils.simplenode.ListNode;

/**
 * #合并两个排序的链表<br/>
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。<br/>
 * 要求：<br>
 * 空间复杂度O(1)，时间复杂度O(n),n为pHead1的长度<br>
 * @author fisher
 * @version 1.0.1 2023/9/6 - 21:05
 */
public class CombineLinkedList {
    /**
     * 如输入{1,3,5},{2,4,6}时，合并后的链表为{1,2,3,4,5,6}，所以对应的输出为{1,2,3,4,5,6}，
     * @param pHead1 排序好的链表
     * @param pHead2 排序好的链表
     * @return ListNode 合并后的链表
     */
    public ListNode Merge (ListNode pHead1, ListNode pHead2) {
        // write code here
        ListNode resHead = new ListNode(0);
        ListNode node = resHead;
        while (pHead1 != null && pHead2 != null){
            if(pHead1.val <= pHead2.val){
                node.next = pHead1;
                pHead1 = pHead1.next;
            }else{
                node.next = pHead2;
                pHead2 = pHead2.next;
            }
            node = node.next;
        }
        node.next = pHead1 == null ? null : pHead2;

        return resHead.next;
    }
}
