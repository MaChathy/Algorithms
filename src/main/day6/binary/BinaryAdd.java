package main.day6.binary;

/**
 * 输入两个表示二进制的字符串，计算他们的和，并以二进制字符串的形式输出。<br>
 * @author fisher
 * @version 1.0
 */
public class BinaryAdd {
    /**
     *
     * @param a <code>String</code> 二进制字符串a
     * @param b <code>String</code> 二进制字符串b
     * @return <code>String</code> a+b的二进制字符串
     */
    public String addBinary(String a,String b){
        int aLength = a.length() - 1;
        int bLength = b.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (aLength >= 0 || bLength >= 0){
            int digitA = aLength >= 0 ? a.charAt(aLength--) - '0' : 0;
            int digitB = bLength >= 0 ? b.charAt(bLength--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum -2 : sum;
            result.append(sum);
        }
        if (carry == 1){
            result.append(1);
        }
        return result.reverse().toString();
    }
}
