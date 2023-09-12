package main.day2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 请写一个整数计算器，支持加减乘三种运算和括号。
 * 例如：
 * 输入"1+2"
 * 返回值3
 * 
 * @author fisher
 * @version 1.0
 */
public class SolveComputer {

    /**
     * 输入："(2*(3-4))*5"
     * 返回值：-10
     * 
     * @param str String
     * @return int 结果
     */
    public static int solve(String str) {
        // 2,*,3,4,-,5,*
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('-', 1);
        map.put('+', 1);
        map.put('*', 2);
        str = str.replace(" ", "");
        char[] chs = str.toCharArray();
        int length = str.length();
        Deque<Integer> numStack = new ArrayDeque<Integer>();
        numStack.push(0);
        Deque<Character> opsStack = new ArrayDeque<Character>();
        for (int i = 0; i < length; i++) {
            char ch = chs[i];
            if (ch == '(') {
                opsStack.addLast(ch);
            } else if (ch == ')') {
                while (!opsStack.isEmpty()) {
                    if (opsStack.peekLast() != '(') {
                        calc(numStack, opsStack);
                    } else {
                        opsStack.pollLast();
                        break;
                    }
                }
            } else {
                if (isNumber(ch)) {
                    int last = 0;
                    int j = i;
                    while (j < length && isNumber(chs[j])) {
                        last = last * 10 + (chs[j++] - '0');
                    }
                    numStack.addLast(last);
                    i = j - 1;
                } else {
                    if (i > 0 && (chs[i - 1] == '(' || chs[i - 1] == '+' || chs[i - 1] == '-')) {
                        numStack.addLast(0);
                    }
                    // 有一个新操作要入栈时，先把栈内可以算的都算了
                    // 只有满足「栈内运算符」比「当前运算符」优先级高/同等，才进行运算
                    while (!opsStack.isEmpty() && opsStack.peekLast() != '(') {
                        char prev = opsStack.peekLast();
                        if (map.get(prev) >= map.get(ch)) {
                            calc(numStack, opsStack);
                        } else {
                            break;
                        }
                    }
                    opsStack.addLast(ch);
                }
            }
        }
        return 0;
    }

    public static void calc(Deque<Integer> numStack, Deque<Character> optStack) {
        if (numStack.isEmpty() || numStack.size() < 2) {
            return;
        }
        if (optStack.isEmpty()) {
            return;
        }
        int b = numStack.pollLast(), a = numStack.pollLast();
        char opt = optStack.pollLast();
        int res = 0;
        if (opt == '+')
            res = a + b;
        else if (opt == '-')
            res = a - b;
        else if (opt == '*')
            res = a * b;
        numStack.addLast(res);
    }

    public static boolean isNumber(char c) {
        return Character.isDigit(c);
    }

    public static void main(String[] args) {
        int solve = solve("1+2");
        System.out.println(solve);
    }

}
