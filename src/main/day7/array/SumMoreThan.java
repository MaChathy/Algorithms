package main.day7.array;

/**
 * 和大于等于target的最短子数组
 * @author fishre
 * @version 1.0
 */
public class SumMoreThan {

    /**
     * 输入一个由正数组成的数组和一个正整数target，求数组中和大于或等于target的连续子数组的最短长度<br>
     * 若不存在这样的子数组，返回0;<br><br>
     *
     * 时间复杂度：O(n)<br>
     *
     * 初始化两个都指向第一个数据的指针p1,p2（两个指针移动方向相同）;<br>
     * 若两个指针之间的子数组的和或乘积大于目标值，则向右移动p1指针并删除子数组最左边的数据<br>
     * 若两个指针之间的子数组的和或乘积小于目标值，则向右移动p2指针并在子数组的右边添加下一个数据<br>
     * @param target <code>int</code> target
     * @param nums <code>int[]</code> nums 数组
     * @return <code>int</code> 最短子数组的长度
     */
    public static int minSubArrayLen(int target,int[] nums){

        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0;right < nums.length;right++){
            //计算下表从left到right的子数组中的数据之和
            sum += nums[right];
            //当left在right的左边并且子数组之和大于目标值时进入循环
            while(left <= right && sum >= target){
                result = Math.min(result,right - left + 1);
                //右移left指针，删除子数组最左边的数据
                sum -= nums[left++];
            }
        }

        //返回结果
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,4,3};
        System.out.println(minSubArrayLen(7,nums));
    }

}
