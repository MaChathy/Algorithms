package main.day3;

/**
 * 循环队列
 * 实现一个循环队列，该循环队列可利用的空间大小等于n个int型变量的大小
 *
 * n个int型变量的大小。
 * @author fisher
 * @version 1.0.1 2023/9/6 - 19:06
 */
public class CircularQueue {

    /**
     * 循环队列维护的数组
     */
    private int[] arr;

    /**
     * 循环队列的队首指针
     */
    private int front ;

    /**
     * 循环队列的队尾指针
     */
    private int rear ;

    private int size ;

    public CircularQueue(int size){
        this.size = size;
        arr = new int [this.size];
        front = rear = 0;
    }

    /**
     * 从队尾入队
     * @param data 入队元素
     */
    public void push(int data){
        if( (rear+1)%this.size == front){
            System.out.println("full");
        }else{
            arr[rear] = data;
            //队尾下标加一
            rear = (rear+1)%size;
        }
    }

    /**
     * 从队首出队
     * @return int 若队列不为空返回队首元素，否则返回-1
     */
    public int pop(){
        if (rear == front){
            System.out.println("empty ");
            return -1;
        }else{
            int data = arr[front];
            //队首下标加一
            front = (front+1)%size;
            return data;
        }
    }

    /**
     * 取队首元素
     * @return 若队列不为空返回队首元素，否则返回-1
     */
    public int front(){
        if (rear == front){
            System.out.println("empty");
            return -1;
        }else{
            return arr[front];
        }
    }

}
