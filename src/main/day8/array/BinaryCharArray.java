package main.day8.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 0和1个数相同的子数组
 * @author fisher
 * @version 1.0
 */
public class BinaryCharArray {

    /**
     * 输入一个只包含0和1的数组，求出0和1的个数相同的最长连续子数字的长度<br><br>
     *
     * 将数组中的0全部替换成-1，则与"求和为target的子数组"类似<br>
     * 设置一个辅助映射，hashMap，键为前i+1个数字之和，值为i(数组下标)<br>
     *
     * 时间复杂度：O(n)<br>
     * 空间复杂度：O(n)<br>
     * @param nums <code>int[]</code>-只包含0和1的一维数组
     * @return <code>int</code>-最长连续子数字的长度
     * @see SumChildArray
     */
    public static int findMaxLength(int[] nums){
        //保存数组中若干数字的累加之和
        //Key:i+1个数据的累加和
        //value:i,数组nums的下标
        Map<Integer,Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0,-1);
        int sum = 0;
        int maxLength = 0;
        for (int i = 0;i < nums.length;i++){
            sum += nums[i] == 0 ? -1 : 1;
            if (sumToIndex.containsKey(sum)){
                maxLength = Math.max(maxLength,i - sumToIndex.get(sum));
            }else{
                sumToIndex.put(sum,i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,1};
        System.out.println(findMaxLength(nums));
    }


}
