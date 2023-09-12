package main.day6.binary;

import java.util.Arrays;

/**
 * 前n个数字二进制形式中1的个数<br><br>
 *
 * @author fisher
 * @version 1.0
 */
public class CountBinary {

    /**
     * 输入一个非负数n，计算0到n之间每个数字的二进制形式中1的个数，并输出一个数组。<br><br>
     * 时间复杂度：O(n)
     * @param num <code>int</code>
     * @return <code>int[]</code> 0~num的每个整数的二进制形式中1的个数组成的数组
     */
    public static int[] countBits(int num){
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i & (i - 1)] + 1;
            //result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(4)));
    }

}
