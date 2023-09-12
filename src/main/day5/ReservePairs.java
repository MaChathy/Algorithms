package main.day5;

/**
 * 数组中的逆序对(分治法，归并)<br>
 * @author fisher
 * @version 1.0.1 2023/9/8 - 21:07
 */
public class ReservePairs {

    public int mod =1000000007;

    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。<br>
     * 输入一个数组,求出这个数组中的逆序对的总数P。<br>
     * 并将P对1000000007取模的结果输出。<br>
     * 即输出P mod 1000000007<br><br>
     *
     * 题目保证输入的数组中没有的相同的数字<br><br>
     *
     * 输入：[1,2,3,4,5,6,7,0]<br>
     * 输出：7<br><br>
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int InversePairs (int[] nums) {
        // write code here
        int length = nums.length;
        int[] res = new int[length];
        return mergeSort(0,length-1,nums,res);
    }

    public int mergeSort(int left,int right,int[] data,int[] temp){

        //停止划分
        if(left >= right){
            return 0;
        }

        int mid = (left + right) / 2;

        //左右划分合并
        int res = mergeSort(left,mid,data,temp) + mergeSort(mid+1,right,data,temp);

        //防止溢出
        res %= mod;
        int i = left;
        int j = mid + 1;
        if (right + 1 - left >= 0)
            System.arraycopy(data, left, temp, left, right + 1 - left);
        for (int k = left; k <= right; k++){
            if(i == mid + 1){
                data[k] = temp[j++];
            } else if (j == right + 1 || temp[i] <= temp[j]){
                data[k] = temp[i++];
            } else{//左边比右边大，答案增加
                data[k] = temp[j++];
                res += mid - i + 1;
            }
        }
        return res % mod;
    }
}
