package main.day5;

/**
 * 二维数组中的查找
 * @author fisher
 * @version 1.0.1 2023/9/8 - 20:25
 */
public class DoubleArrays {
    /**
     * 在一个二维数组array中（每个一维数组的长度相同），<br>
     * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。<br>
     * 完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数<br><br>
     *
     * 输入：7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]<br>
     * 输出：true<br><br>
     *
     *
     * @param target int整型
     * @param array int整型二维数组
     * @return bool布尔型
     */
    public boolean Find (int target, int[][] array) {
        // write code here
        int high ,low;
        for(int[] nums : array){
            high = array[0].length - 1;
            low = 0;
            while (high >= low){
                int mid = (high + low)/2;
                if(nums[mid] == target){
                    return true;
                }else if (nums[mid] > target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
        }
        return false;
        /*
        if(array.length == 0)
            return false;
        int n = array.length;
        if(array[0].length == 0)
            return false;
        int m = array[0].length;
        //从最左下角的元素开始往左或往上
        for(int i = n - 1, j = 0; i >= 0 && j < m; ){
            //元素较大，往上走
            if(array[i][j] > target)
                i--;
            //元素较小，往右走
            else if(array[i][j] < target)
                j++;
            else
                return true;
        }
        return false;
         */
    }
}
