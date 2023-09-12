package main.day7.array;

import java.util.Arrays;

/**
 * 排序数组中的两个数字之和
 * @author fisher
 * @version 1.0
 */
public class SortArraySum {

    /**
     * 输入一个递增排序的数组和一个值target，在数组中找出两个和位target的数字并返回他们的下标<br>
     * (数组中只存在一对符合条件的数字，同一个数字不能使用两次)<br>
     *
     * 使用方向相反的双指针<br>
     * 时间复杂度：O(n)<br>
     * 空间复杂度：O(1)
     * @param numbers <code>int[]</code> numbers
     * @param target <code>int</code> target
     * @return <code>int[]</code> 符合条件的下标
     */
    public int[] towSum(int[] numbers,int target){
        //设置指向第一个数据的指针
        int pre = 0;
        //设置指向最后一个数据的指针
        int post = numbers.length - 1;
        // 当前后指针相加之和不等于target时进入循环
        while((numbers[pre] + numbers[post]) != target){
            // 若前后指针相加之和小于target，前指针后移一位，否则后指针前移一位
            if (numbers[pre] + numbers[post] < target) {
                // 前指针加1
                pre++;
            }else {
                // 后指针减1
                post--;
            }
        }
        return new int[]{pre,post};
    }

}
