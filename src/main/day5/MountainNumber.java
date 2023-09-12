package main.day5;

/**
 * 寻找峰值
 * @author fisher
 * @version 1.0.1 2023/9/8 - 20:43
 */
public class MountainNumber {
    /**
     * 给定一个长度为n的数组nums，请你找到峰值并返回其索引。<br>
     * 数组可能包含多个峰值，在这种情况下，返回任何一个所在位置即可。<br><br>
     * 说明：<br>
     * &nbsp;&nbsp;峰值元素是指其值严格大于左右相邻值的元素。严格大于即不能有等于<br>
     * &nbsp;&nbsp;对于所有有效的 i 都有 nums[i] != nums[i + 1]<br><br>
     *
     * 1≤nums.length≤2×100000<br>
     * 输入：[2,4,1,2,7,8,4]<br>
     * 输出：1<br><br>
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int findPeakElement (int[] nums) {
        // write code here
        int i = 1;
        if (nums.length == 1 || nums[0] > nums[1])
            return 0;
        else if (nums.length == 2){
            return 1;
        }else{
            for (i = 1; i < nums.length-1; i++) {
                if(nums[i-1] < nums[i] && nums[i] > nums[i+1]){
                    return i;
                }
            }
        }

        return i == nums.length-1 ? nums.length-1 : i;
        /*
        int left = 0;
        int right = nums.length - 1;
        //二分法
        while(left < right){
            int mid = (left + right) / 2;
            //右边是往下，不一定有坡峰
            if(nums[mid] > nums[mid + 1])
                right = mid;
            //右边是往上，一定能找到波峰
            else
                left = mid + 1;
        }
        //其中一个波峰
        return right;
         */
    }
}
