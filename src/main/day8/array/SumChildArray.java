package main.day8.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 和为target的子数组
 * @author fisher
 * @version 1.0
 */
public class SumChildArray {

    /**
     * 输入一个整数target和一个数组，求和为target的连续子数组的个数。<br><br>
     *
     * 当扫描到第i个数字并求得前i个数字之和是x时，需要知道在i之前有多少个j使得前j个数字之和等于target-x<br>
     * 对于每个i，不但要保存前i个数字之和，还要保存每个和出现的次数。<br>
     * 时间复杂度：O(n)<br>
     * 空间复杂度：O(n)<br>
     * @param nums <code>int[]</code> 整数数组
     * @param target <code>int</code> 目标值
     * @return <code>int</code> 连续子数组的个数
     */
    public int subarrayArray(int[] nums,int target){
        //哈希表的键为前i个数字之和，值为每个数出现的次数
        Map<Integer,Integer> sumToCount = new HashMap<>();
        sumToCount.put(0,1);
        int sum = 0;
        int result = 0;
        for (int num : nums){
            sum += num;
            result += sumToCount.getOrDefault(sum-target,0);
            sumToCount.put(sum,sumToCount.getOrDefault(sum,0)+1);
        }
        return result;
    }

}
