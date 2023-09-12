package main.day2;

import java.util.Stack;

/**
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，
 * 判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，
 * 但"(]"和"([)]"不合法。
 * 
 * @author fisher
 * @version 1.0
 */
public class ValidOrder {
    /**
     *
     * 
     * @param s string字符串,"({})"
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        // write code here
        if (s.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 期待遇到右小括号
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                // 期待遇到右中括号
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                // 期待遇到右大括号
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
