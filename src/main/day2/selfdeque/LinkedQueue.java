package main.day2.selfdeque;


/**
 * 链队<br>
 * 链表实现队列
 * @author fisher
 * @version 1.0.1 2023/9/6 - 15:24
 */
public class LinkedQueue {

    //TODO:设置两个节点
    /**
     * 对首指针，指向队头节点
     */
    LNode front;

    /**
     * 队尾指针，指向队尾节点
     */
    LNode rear;

    /**
     * 记录队列长度
     */
    int size ;

    public LinkedQueue(){
        this.front = this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 入队
     * @param data 入队元素
     * @return 是否入队成功
     */
    public boolean push(Object data){
        if(size == 0){
            front = new LNode(null,data);
            rear = front;
            size++;
            return true;
        }
        LNode s = new LNode(null,data);
        rear.next = s;
        rear = s;
        size++;
        return true;
    }

    /**
     * 出队,删除队列元素
     * @return 队首元素
     */
    public Object pop() {
        if(this.isEmpty()){
            return null;
        }
        Object data = front.data;
        front = front.next;
        size--;
        return data;
    }

    /**
     * 取队首元素
     * @return 队首元素
     */
    public Object front(){
        return front.data == null ? null : front.data;
    }

}
