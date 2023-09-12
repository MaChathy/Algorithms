package main.day2;

import java.util.Scanner;

/**
 * 实现一个栈。
 * 操作：
 * push x：将加x 入栈，保证 x 为 int 型整数。
 * pop：输出栈顶，并让栈顶出栈
 * top：输出栈顶，栈顶不出栈
 * 
 * @author fisher
 * @version 1.0
 */
public class SelfStack {

    int[] data; // 栈中数据
    int size; // 栈中元素个数
    int maxSize; // 栈的最大容量
    int top = 0; // 栈顶指针

    // construct
    public SelfStack(int maxSize) {
        this.maxSize = maxSize;
        this.data = new int[maxSize];
    }

    /**
     * 入栈操作
     * 
     * @param val int value 入栈元素
     */
    public void push(int val) {
        // 若栈中元素个数等于最大容量输出“error”
        if (this.size == this.maxSize) {
            System.out.println("error");
        } // 否则执行入栈操作
        else {
            // 将val存入data数组，并将栈顶指针加一
            data[top++] = val;
            // 栈中元素个数加一
            this.size++;
        }
    }

    /**
     * 出栈操作
     * 
     */
    public void pop() {
        // 若栈为空，输出“error”
        if (this.size == 0) {
            System.out.println("error");
        } else {
            int topVal = this.data[--top];
            System.out.println(topVal);
            size--;
        }
    }

    /**
     * 查看栈顶元素
     * 
     */
    public void top() {
        if (this.size == 0) {
            System.out.println("error");
        } else {
            System.out.println(this.data[top - 1]);
        }
    }
}
