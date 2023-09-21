package main.day14.hash;

import main.utils.simplenode.doublenode.TwoWayListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最近最少使用缓存<br><br>
 * 设计实现一个最近最少使用(Least Recently Used, LRU)缓存，<br>
 * 要求下面两个操作的时间复杂度都是O(1):<br>
 * 1.get(key):若缓存中存在key，则返回它的值；否则返回-1；<br>
 * 2.put(key,value):若缓存中之前包含键key，则将它的值设为value；否则添加键key及对应的值value<br>
 *
 * 在添加一个键的值时，若缓存容量已经满了，则在添加新建之前删除最近最少使用的键<br>
 *
 * @author fisher
 * @version 1.0
 */
public class LRUCache {

    /**
     * 头节点
     */
    private final TwoWayListNode head;

    /**
     * 尾节点
     */
    private final TwoWayListNode tail;

    /**
     * 键key对键所在的双向链表中的节点的映射
     */
    private final Map<Integer,TwoWayListNode> map;

    /**
     * 缓存容量
     */
    private final int capacity;

    public LRUCache(int capacity){
        this.map = new HashMap<>();

        this.head = new TwoWayListNode(-1,-1);
        this.tail = new TwoWayListNode(-1,-1);
        head.next = tail;
        tail.prev = head;

        this.capacity = capacity;
    }

    /**
     * 若缓存中存在key，则返回它的值；否则返回-1<br>
     * @param key <code>int</code> 键
     * @return <code>int</code> -若存在，返回其值；否则返回-1；
     */
    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }
        TwoWayListNode node = map.get(key);
        //将node节点移动到双链表尾部
        moveToTail(node, node.value);
        return node.value;
    }

    /**
     * 若缓存中之前包含键key，则将它的值设为value；否则添加键key及对应的值value<br>
     * 在添加一个键的值时，若缓存容量已经满了，则在添加新建之前删除最近最少使用的键<br>
     * @param key <code>int</code> 键
     * @param value <code>int</code> 值
     */
    public void put(int key,int value){
        if (map.containsKey(key)){
            moveToTail(map.get(key),value);
        }else{
            if (map.size() == capacity){
                TwoWayListNode toBeDeleted = head.next;
                //删除节点
                deleteNode(toBeDeleted);
                //删除map中的映射
                map.remove(toBeDeleted.key);
            }

            TwoWayListNode node = new TwoWayListNode(key,value);
            //向双向链表尾部添加新节点
            insertToTail(node);
            //向map中添加映射
            map.put(key,node);
        }


    }

    /**
     * 将节点赋值并移向链表尾部
     * @param node <code>TwoWayListNode</code> 双向链表节点
     * @param newValue <code>int</code> 节点的值
     */
    private void moveToTail(TwoWayListNode node,int newValue){
        //断开节点链接
        deleteNode(node);
        //修改节点值
        node.value = newValue;
        //节点插入链表尾部
        insertToTail(node);

    }

    /**
     * 删除指定节点 <br>
     * @param node <code>TwoWayListNode</code> 双链表中要删除的节点
     */
    private void deleteNode(TwoWayListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 将节点插入双链表尾部<br>
     * @param node <code>TwoWayListNode</code> 双链表节点
     */
    private void insertToTail(TwoWayListNode node){
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
}