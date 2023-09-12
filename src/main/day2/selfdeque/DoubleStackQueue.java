package main.day2.selfdeque;

/**
 * 双栈队列
 *
 * @author fisher
 * @version 1.0.1 2023/9/6 - 15:03
 */
public class DoubleStackQueue {

    LinkStack stack1;
    LinkStack stack2;

    public DoubleStackQueue(){
        stack1 = new LinkStack();
        stack2 = new LinkStack();
    }

    /**
     * 入队
     * @param data 节点数据
     */
    public void push(Object data) {
        stack1.push(data);
    }

    /**
     * 出对
     * @return 队首元素数据
     */
    public Object pop() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * 取队首元素
     * @return 队首元素数据
     */
    public Object front() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? null : stack2.peek();
    }

}
