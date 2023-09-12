package main.day6.binary;

/**
 * 只出现一次的数字
 * @author fisher
 * @version 1.0 2023/9/11 20:33
 */
public class OnlyOneNum {

    /**
     * 输入一个整形数组，数组中只有一个数字出现了一次，其他数字都出现了三次，找出那个只出现一次的数字。<br><br>
     * 任何数字对它本身的异或都为0，XOR n,n ; n=0
     *
     * @param nums <code>int[]</code>
     * @return <code>int</code> 只出现一次的数字
     */
    public static int singleNumber(int[] nums){

        int[] bitSums = new int[32];
        for (int num : nums){
            for (int i = 0;i < 32;i++){

                //整数num的二进制形式中从左数起第i个数位
                bitSums[i] += (num >> (31 - i)) & 1;
            }
        }
        int result = 0;
        for (int i = 0;i < 32;i++){
            result = (result << 1) + bitSums[i] % 3;
        }
        return result;
    }
}
