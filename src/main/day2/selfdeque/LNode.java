package main.day2.selfdeque;

/**
 * 节点类
 * @author fisher
 * @version 1.0.1 2023/9/6 - 14:59
 */
public class LNode {
    Object data;
    LNode next;

    public LNode(){ }

    public LNode(Object data){
        this.data = data;
    }

    public LNode(LNode next,Object data){
        this.data = data;
        this.next = next;
    }

    public LNode getNext() {
        return next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(LNode next) {
        this.next = next;
    }
}
