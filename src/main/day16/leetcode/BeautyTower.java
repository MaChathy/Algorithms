package main.day16.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 美丽塔<br>
 * @author fisher
 * @version 1.0
 */
public class BeautyTower {

    /**
     * 给一个长度为 n 下标从 0 开始的整数数组 maxHeights<br>
     * 任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。<br>
     *
     * 如果以下条件满足，我们称这些塔是 美丽 的：<br>
     * 1. 1 <= heights[i] <= maxHeights[i]，<br>
     * 2. heights 是一个 山状 数组。<br>
     * 如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山状 数组：<br>
     *
     * 1. 对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]<br>
     * 2. 对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]<br>
     * 请返回满足 美丽塔 要求的方案中，高度和的最大值 。<br><br>
     *
     * 时间复杂度：O(n^2)<br>
     * 空间复杂度：O(n)<br><br>
     *
     * @param maxHeights <code>List<code><</code>Integer></code> 整数数组
     * @return <code>Long</code> -高度和的最大值
     */
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int index = 0;
        long max = 0;

        while (index < maxHeights.size()) {
            max = Math.max(max, helper(index, maxHeights));
            index++;
        }

        return max;
    }

    /**
     * 计算以index为下标构建的美丽塔的高度和<br><br>
     *
     * 时间复杂度：O(n)<br>
     * 空间复杂度：O(n)<br><br>
     *
     * @param index <code>int</code> 数组下标
     * @param maxHeights <code>List<code><</code>Integer></code> 整数数组
     * @return <code>long</code> -高度和
     */
    private long helper(int index,List<Integer> maxHeights){
        long sum = 0;
        List<Integer> copy = new ArrayList<>(maxHeights);
        int prev = index;
        int post = index;
        int temp1 = 0;
        int temp2 = 0;

        while(prev > 0 || post < copy.size() - 1){
            temp1 = copy.get(prev == 0 ? prev : prev--) ;
            temp2 = copy.get(post == copy.size() -1 ? post : post++);
            if(copy.get(prev) > temp1){
                copy.set(prev,temp1);
            }

            if(post < copy.size() && copy.get(post) > temp2){
                copy.set(post,temp2);
            }
        }
        for (int num : copy){
            sum += num;
        }

        return sum;
    }
}
