package main.day2;

import java.util.Stack;

/**
 * 给定一个逆波兰表达式，求表达式的值。
 * 
 * @author fisher
 * @version 1.0
 */
public class EvalRPN {
    /**
     * 输入：["2","1","+","4","*"]
     * 返回值：12
     * 
     * @param tokens string字符串一维数组
     * @return int整型
     */
    public int evalRPN(String[] tokens) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        for (String elem : tokens) {
            if (!elem.equals("+") && !elem.equals("-") && !elem.equals("*") && !elem.equals("/")) {
                stack.push(Integer.parseInt(elem));
            } else if (stack.size() >= 2) {
                int e2 = stack.pop();
                int e1 = stack.pop();
                switch (elem) {
                    case "+":
                        stack.push(e1 + e2);
                        break;
                    case "-":
                        stack.push(e1 - e2);
                        break;
                    case "*":
                        stack.push(e1 * e2);
                        break;
                    default:
                        stack.push(e1 / e2);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
