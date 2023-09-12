package main.day2;

import java.util.Stack;

/**
 * 输入两个整数序列，
 * 第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。
 * pushV 的所有数字均不相同
 * 
 * @author fishre
 * @version 1.0
 */
public class StackOrder {
    /**
     * 
     * @param pushV int整型一维数组
     * @param popV  int整型一维数组
     * @return bool布尔型
     */
    public static boolean IsPopOrder(int[] pushV, int[] popV) {
        // write code here
        // 辅助栈
        Stack<Integer> stack = new Stack<>();
        // 变量入栈的下标
        int index = 0;
        // 遍历出栈的数组
        for (int i = 0; i < pushV.length; i++) {
            // 入辅助栈：辅助栈为空或栈顶不等于出栈数组
            while (index < pushV.length && (stack.isEmpty() || stack.peek() != popV[i])) {
                stack.push(pushV[index++]);
            }
            // 栈顶等于出栈数组
            if (stack.peek() == popV[i]) {
                stack.pop();
            } // 不匹配序列
            else {
                return false;
            }
        }
        return true;
    }
}
