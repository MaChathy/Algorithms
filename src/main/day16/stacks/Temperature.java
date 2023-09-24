package main.day16.stacks;

import java.util.Stack;

/**
 * 每日温度<br>
 * @author fisher
 * @version 1.0
 */
public class Temperature {

    /**
     * 输入一个数组，它的每个数字表示是某天的温度。<br>
     * 请计算每天需要等几天才会出现更高的温度,若后面没有更高的温度，对应输出是0.<br>
     * ex:<br>
     * 输入：[35,31,33,36,34]<br>
     * 输出：[3,1,1,0,0]<br><br>
     *
     * @param temperatures <code>int[]</code>
     * @return <code>int[]</code>
     */
    public int[] dailyTemperatures(int[] temperatures){
        //存放数组下标
        Stack<Integer> temperatureStack = new Stack<>();
        int[] days = new int[temperatures.length];

        for (int i = 0;i < temperatures.length;i++){
            //当栈不为空且栈顶存放的数组下标对应的数据小于当前数据时，出栈
            while (!temperatureStack.empty() && temperatures[i] > temperatures[temperatureStack.peek()]){
                int prev = temperatureStack.pop();
                days[prev] = i - prev;
            }
            temperatureStack.push(i);
        }
        return days;
    }
}
