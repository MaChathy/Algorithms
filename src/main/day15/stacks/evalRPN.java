package main.day15.stacks;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Stack;

/**
 * 后缀表达式
 * @author fisher
 * @version 1.0
 */
public class evalRPN {

    /**
     * 输入一个用字符串数组表示的后缀表达式，输出该后缀表达式的结果<br>
     * @param tokens <code>String[]</code> 逆波兰表达式字符串
     * @return <code>int</code> -逆波兰表达式的值
     */
    public int getEvalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens){
            switch (s){
                case "*" :
                case "-" :
                case "+" :
                case "/" :
                    //出栈计算
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(calculate(num1,num2,s));
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    private int calculate(int num1,int num2,String token){
        switch (token){
            case "+" : return num1 + num2;
            case "-" : return num1 - num2;
            case "*" : return num1 * num2;
            case "/" : return num1 / num2;
            default: return 0;
        }
    }

}
