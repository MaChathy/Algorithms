package main.day2.selfdeque;

/**
 * 链栈
 * @author fisher
 * @version 1.0.1 2023/9/6 - 15:03
 */
public class LinkStack {
    /**
     * 头结点
     */
    private LNode head;

    public LinkStack(){
        head = new LNode();
        head.next = null;
        head.data = null;
    }

    /**
     * 栈是否为空
     * @return boolean
     */
    public boolean isEmpty(){
        return head.next == null;
    }

    /**
     * 入栈
     * @param data Object 元素
     */
    public void push(Object data) {
        //创建新节点储存数据
        LNode node = new LNode(data);
        //头插法将新节点连接
        node.next = head.next;
        head.next = node;
    }

    /**
     * 出栈
     * @return Object 栈顶元素数据
     */
    public Object pop() {
        if (this.isEmpty())
            return null;
        //取栈顶元素
        LNode top = head.next;
        //将栈顶元素出栈
        head.next = top.next;
        return top.data;
    }

    /**
     * 取栈顶元素
     * @return Object 栈顶元素
     */
    public Object peek() {
        if (this.isEmpty()) return null;
        LNode top = head.next;
        return top.data;
    }
}
