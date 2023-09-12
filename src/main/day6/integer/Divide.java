package main.day6.integer;

/**
 * 输入两个int型整数，他们经行除法运算并返回商，要求不得使用乘“*”号、除号“/”以及求余号“%”。<br>
 * 当发生溢出时返回最大的正数值。（除数不为0）<br><br>
 *
 * 4种整数类型：<br>
 * byte(-128 ~ 127)<br>
 * short(-32768 ~ 32767)<br>
 * int(-pow(2,31) ~ pow(2,31))&nbsp;&nbsp;min:0x80000000&nbsp;&nbsp;max:<code>Integer.MAX_VALUE</code><br>
 * long(-pow(2,63) ~ pow(2,63))
 * @author fisher
 * @version 1.0
 */
public class Divide {

    public int divide(int dividend,int divisor){
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int negative = 2;
        if (dividend > 0){
            negative--;
            dividend = -dividend;
        }
        if (divisor > 0){
            negative--;
            divisor = -divisor;
        }
        int result = divideCore(dividend,divisor);
        return negative == 1 ? -result : result;
    }

    /**
     * 被除数大于除数的 2^result 倍<br>
     * 使用减法实现两个负数的除法<br><br>s
     * 时间复杂度:O(logN)<br>
     * 空间复杂度：O(1)<br>
     * @param dividend <code>int</code> 被除数
     * @param divisor <code>int</code> 除数
     * @return <code>int</code> result 被除数-除数*2^n (result>0)
     */
    private int divideCore(int dividend,int divisor){
        int result = 0;

        //当被除数小于等于除数时进入循环
        while(dividend <= divisor){
            int value = divisor;
            //商
            int quotient = 1;
            //当除数没有溢出且被除数小于除数的2倍时进入循环
            while(value >= Integer.MIN_VALUE && dividend <= value + value){
                //商*2
                quotient += quotient;
                value += value;
            }
            result += quotient;
            dividend -= value;
        }

        return result;
    }
}
