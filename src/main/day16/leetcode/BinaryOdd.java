package main.day16.leetcode;

/**
 * 二进制奇数
 * @author fisher
 * @version 1.0
 */
public class BinaryOdd {

    /**
     * 按某种方式 重新排列 字符串中的位，使得到的二进制数字是可以由该组合生成的 最大二进制奇数 。<br><br>
     * 时间复杂度：O(n)<br>
     * 空间复杂度：O(n)<br>
     * @param s <code>String</code> -至少包含一个“1”的二进制字符串
     * @return <code>String</code> -二进制奇数字符串
     */
    public String maximumOddBinaryNumber(String s){
        StringBuilder res = new StringBuilder();
        res.append(1);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1'){
                count++;
            }
        }
        for (int i = 0;i < s.length() - count;i++){
            res.append(0);
        }
        for (int i = 0;i < count - 1;i++){
            res.append(1);
        }
        return res.reverse().toString();
    }

}
