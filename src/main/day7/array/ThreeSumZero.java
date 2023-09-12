package main.day7.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 数组中和位0的三个数字
 * @author fisher
 * @version 1.0
 */
public class ThreeSumZero {

    /**
     * 输入一组数组，找出数组中所有和为0的三个数字的三元组<br>
     * 返回值中不得包含重复的三元组<br><br>
     * 固定nums数组中的一个数据，通过设置双指针找出其他两个与固定数据相加为0的数据<br>
     * 时间复杂度：O(n^2)<br>
     * 空间复杂度：O(1)
     * @param nums <code>int[]</code>
     * @return <code>List<code><</code>List<code><</code>Integer<code>></code><code>></code></code>
     */
    public List<List<Integer>> threeSum(int [] nums){
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums.length > 3) {
            //将nums数组从小到大排序
            Arrays.sort(nums);
            int i = 0;
            //遍历nums数组中前length-2个数据
            while(i < nums.length -2){
                //
                twoSum(nums,i,result);
                int temp = nums[i];
                //为避免重复，nums[i]跳过重复的数字
                while(i < nums.length && nums[i] == temp){
                    ++i;
                }
            }
        }
        return result;
    }

    /**
     * 固定nums数组中下标为i的数据，找出和为0的三元组，将三元组添加到result结果集中<br>
     * @param nums <code>int[]</code> nums 数组
     * @param i <code>int</code> nums 数组下标
     * @param result code>List<code><</code>List<code><</code>Integer<code>></code><code>></code></code> result 结果集
     */
    private void twoSum(int[] nums,int i,List<List<Integer>> result){
        //设置指向第i个数据的前指针
        int j = i + 1;
        //设置只想指向最后一个的后指针
        int k = nums.length-1;
        //当前指针在后指针的前面时进入循环
        while (j < k){
            //若三个数据相加之和等于0
            if (nums[i] + nums[j] + nums[k] ==0){
                //将三元组添加进结果集中
                result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                //临时储存第j-1个数据
                int temp = nums[j];
                //为避免重复，nums[i]跳过重复的数字;当temp等于第j-1个数据且j < k时进入循环
                while(nums[j] == temp && j < k){
                    ++j;
                }
            }//若三个数据相加小于0
            else if(nums[i] +nums[j] + nums[k] < 0){
                //前指针加1，即右移
                ++j;
            }else{
                //否则，后指针减1，即左移
                --k;
            }
        }
    }
}
