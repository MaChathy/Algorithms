package main.day3;

/**
 * 链表实现
 * @author fisher
 * @version 1.0.1 2023/9/6 - 19:40
 */
public class LinkedNode {

    int data;

    /**
     * 下一节点
     */
    LinkedNode next;

    /**
     * 初始化头节点
     */
    public LinkedNode(int data){
        this.data = data;
        this.next = null;
    }

    /**
     * 加入链表，插入在第一个值为x的结点之前。<br/>
     * 若链表中不存在值为x的结点，则插入在链表末尾。<br/>
     * 保证x,y为int型整数。<br/>
     * @param oldData x 节点值为x
     * @param newData y 节点值为y
     */
    public void insert(int oldData,int newData){
        LinkedNode newNode = new LinkedNode(newData);
        //标记手否找到x节点
        int sign = 0;
        LinkedNode node = this;
        while(node.next != null){
            if(node.next.data == oldData){
                newNode.next = node.next;
                node.next = newNode;
                sign = 1;
                break;
            }
            node = node.next;
        }
        if(sign == 0){
            node.next = newNode;
        }
    }


    /**
     * 删除链表中第一个值为x的结点。<br/>
     * 若不存在值为x的结点，则不删除<br/>
     * @param data x 节点值为x<br/>
     */
    public void delete(int data){
        LinkedNode node = this;
        while ( node.next != null ){
            if (node.next.data == data) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
    }

    /**
     * 链表是否为空
     * @return boolean
     */
    public boolean isEmpty(){
        return this.next == null;
    }

}
