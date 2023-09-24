package main.day16.stacks;

import java.util.Stack;

/**
 * 直方图的最大矩形面积<br>
 * @author fisher
 * @version 1.0
 */
public class MaxArea {

    /**
     * 输入一个由非负数组成的数组，数组中的数字是直方图中柱子的高.<br>
     * 求直方图中最大矩形的面积<br>
     * @param heights <code>int[]</code> 表示直方图柱子的高的数组
     * @return <code>int</code> -直方图的最大面积
     */
    public int largestRectangleArea(int[] heights){
        return solve1(heights);
    }

    /**
     * 计算直方图中每个矩形的面积取最大<br><br>
     * 时间复杂度：O(n^2)<br>
     * 空间复杂度：O(1)<br><br>
     * @param heights <code>int[]</code> 表示直方图柱子的高的数组
     * @return <code>int</code> -直方图的最大面积
     */
    public int solve1(int[] heights){
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            //直方图中矩形的高
            int min = heights[i];
            for (int j = i;j < heights.length;j++){
                min = Math.min(min,heights[j]);
                int area = min * (j - i + 1);
                maxArea = Math.max(area,maxArea);
            }
        }
        return maxArea;
    }

    /**
     * 分治法<br>
     * @param heights <code>int[]</code> 表示直方图柱子的高的数组
     * @return <code>int</code> -直方图的最大面积
     */
    public int solve2(int[] heights){
        return helper(heights,0,heights.length);
    }

    /**
     * 时间复杂度：O(NlogN)<br>
     * 空间复杂度：O(logN)<br>
     * @param heights <code>int[]</code> 表示直方图柱子的高的数组
     * @param start <code>int</code> 开始下标
     * @param end <code>int</code> 结束下标
     * @return <code>int</code> -直方图的最大面积
     */
    private int helper(int[] heights,int start,int end){
        if (start == end){
            return 0;
        }
        if (start + 1 == end){
            return heights[start];
        }
        int minIndex = start;
        for (int i = start + 1; i < end; i++) {
            if (heights[i] < heights[minIndex]){
                minIndex = i;
            }
        }
        int area = (end - start) * heights[minIndex];
        int left = helper(heights,start,minIndex);
        int right = helper(heights,minIndex + 1,end);
        area = Math.max(area,left);
        return Math.max(area,right);
    }

    /**
     * 单调栈法<br>
     * <br>
     * 时间复杂度：O(n)<br>
     * 空间复杂度：O(n)<br><br>
     *
     * @param heights <code>int[]</code> 表示直方图柱子的高的数组
     * @return <code>int</code> -直方图的最大面积
     */
    public int solve3(int[] heights){
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (indexStack.peek() != -1 && heights[i] <= heights[indexStack.peek()]){
                int pop = indexStack.pop();
                int area = heights[pop] * (i - indexStack.peek() - 1);
                maxArea = Math.max(area,maxArea);
            }
            indexStack.push(i);
        }

        while (indexStack.peek() != -1){
            int height = heights[indexStack.pop()] ;
            int width = heights.length - indexStack.peek() - 1;
            maxArea = Math.max(maxArea,height * width);
        }

        return maxArea;
    }

}

class Main{
    public static void main(String[] args) {
        MaxArea area = new MaxArea();
        int [] heights = new int[]{3,2,5,4,6,1,4,2};
        System.out.println(area.solve1(heights));
    }
}