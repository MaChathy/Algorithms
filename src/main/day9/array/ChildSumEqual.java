package main.day9.array;

/**
 * 左右两边子数组的和相等
 * @author fisher
 * @version 1.0
 */
public class ChildSumEqual {

    /**
     * 输入一个整数数组，若一个数字左边的子数组的数字之和等于右边子数组的数字之和，则返回该数字的下标.<br>
     * 若存在多个这养的数字则返回最左边的数字;若不存在这样的数字则返回-1。<br><br>
     *
     * 时间复杂度：O(n)<br>
     *
     * @param nums <code>int[]</code>-整形数组
     * @return <code>int[]</code>-数组中满足要求的数字的下标
     */
    public static int pivotIndex(int[] nums){

        int sumLeft = 0;
        //存放数组中所有数据之和
        int total = 0;
        //数组所有数据之和
        for (int num : nums){
            total += num;
        }
        //从第二个数据遍历数组
        for (int mid = 1;mid < nums.length;mid++){
            //计算前mid个数据之和
            sumLeft += nums[mid-1];
            //若总数据之和减去下标为mid的数据等于前mid个数据之和
            if((total - nums[mid]) == sumLeft * 2 ){
                //返回结果
                return mid;
            }
        }
        //遍历数组为找到符合条件的数据下标，返回-1
        return -1;
    }

}
