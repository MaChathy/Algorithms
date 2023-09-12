package main.day2.selfdeque;

/**
 * 数组队列
 * @author fisher
 * @version 1.0.1 2023/9/6 - 18:44
 */
public class ArrayQueue {

    /**
     * 队列需要维护的数组
     */
    private int[] arr;

    /**
     * 队首
     */
    private int front = 0;

    /**
     * 队尾
     */
    private int rear = 0;

    public ArrayQueue(int size){
        arr = new int[size];
    }

    /**
     * 入队
     * @param data 入队数据
     */
    public void push(int data){
        if(rear-front == arr.length){
            int [] newArr = new int[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i % arr.length];
                arr = newArr;
            }
        }
        arr[rear % arr.length] = data;
        rear++;
    }

    /**
     * 出对
     * @return int 队首元素
     */
    public int pop(){
        if(rear == front){
            return -1;
        }
        int data = arr[front % arr.length];
        front++;
        return data;
    }

    /**
     * 取队首元素
     * @return 队首元素
     */
    public int front(){
        return this.rear == this.front ? -1 : arr[front];
    }
}
