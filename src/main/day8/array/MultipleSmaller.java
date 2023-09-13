package main.day8.array;

/**
 * 乘积小于target的子数组
 * @author fisher
 * @version 1.0
 */
public class MultipleSmaller {

    /**
     *
     * 输入一个由正数组成的数组和一个正整数target，数组中有多少个数字乘积小于target的连续子数组
     *
     * 时间复杂度：O(n)<br>
     * @param nums <code>int[]</code> nums 整型数组
     * @param target <code>int</code> 目标值
     * @return <code>int</code> 子数组的个数
     */
    public static int numSubarrayProductLessThank(int[] nums, int target){
        int result = 0;
        int left = 0;
        int temp = 1;
        for (int right = 0;right < nums.length;right++){
            temp *= nums[right];
            while(left <= right && temp >= target){
                temp /= nums[left++];
            }
            result += right >= left ? right - left + 1 : 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {10,5,2,6};
        System.out.println(numSubarrayProductLessThank(nums, 100));
    }

}
