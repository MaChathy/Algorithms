package main.utils.simplenode.doublenode;

/**
 * 存储键值对的双向链表<br>
 * @author fisher
 * @version 1.0
 */
public class TwoWayListNode {

    /**
     * 键key
     */
    public int key;
    /**
     * 值value
     */
    public int value;
    /**
     * 下一个节点
     */
    public TwoWayListNode next;
    /**
     * 前一个节点
     */
    public TwoWayListNode prev;

    public TwoWayListNode(int key,int value){
        this.key = key;
        this.value = value;
    }

}
