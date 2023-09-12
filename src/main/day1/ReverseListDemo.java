package main.day1;

import java.util.Stack;
import main.utils.simplenode.ListNode;


public class ReverseListDemo {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 给定一个单链表的头结点pHead，长度为n，反转该链表后，返回新链表的表头。
     * 要求：空间复杂度 O(1) ，时间复杂度 O(n)
     * O(n) 。
     * 
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode ReverseList(ListNode head) {
        // write code here
        // 初始化以ListNode类型为节点的栈
        Stack<ListNode> stack = new Stack<>();
        // 将链表中的节点依次入栈
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        ListNode node = stack.pop();
        ListNode res = node;
        // 出栈，组成新链表
        while (!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        node.next = null;
        return res;
    }

    /**
     * 方法2
     * 
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode ReverseList1(ListNode head) {
        // 新链表
        ListNode res = null;
        while (head != null) {
            // 保存访问节点的下一个节点
            ListNode temp = head.next;
            // 每次访问的原链表节点都会成为新链表的头结点
            head.next = res;
            // 更新链表
            res = head;
            // 重新赋值
            head = temp;
        }

        return res;
    }

    public static ListNode initListNode() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = null;
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void solutions() {
        ListNode head = initListNode();
        ListNode pre = ReverseList1(head);
        printList(pre);
    }

}
