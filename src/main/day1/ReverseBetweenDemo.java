package main.day1;

import main.utils.simplenode.ListNode;

public class ReverseBetweenDemo {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转
     * 要求:时间复杂度O(1), 空间复杂度O(n)
     * 
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        ListNode res = new ListNode(-1);
        res.next = head;
        // 前序节点
        ListNode preNode = res;
        // 当前节点
        ListNode curNode = head;
        // 找出m节点
        for (int i = 1; i < m; i++) {
            preNode = curNode;
            curNode = curNode.next;
        }
        // 翻转第m到n个节点
        for (int i = m; i < n; i++) {
            ListNode temp = curNode.next;
            curNode.next = temp.next;
            temp.next = preNode.next;
            preNode.next = temp;
        }
        return res.next;
    }

}
