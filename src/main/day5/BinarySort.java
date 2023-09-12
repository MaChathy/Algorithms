package main.day5;

import java.util.Arrays;

/**
 * 二分查找
 * @author fisher
 * @version 1.0.1 2023/9/8 - 19:45
 */
public class BinarySort {

    /**
     *
     *
     *
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search (int[] nums, int target) {
        // write code here
        Arrays.sort(nums);

        int high = nums.length-1;
        int low = 0;
        int mid = (high+low)/2;

        while(target != nums[mid]){
            if (low > high){
                return -1;
            }
            if (target < nums[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
            mid = (high+low)/2;
        }

        return mid;
    }

}
