package main.day14.hash;

import java.util.List;

/**
 * 最小时间差
 * @author fishre
 * @version 1.0
 */
public class MinTimeDifference {

    /**
     * 给定一组范围在00:00~23:59之间的时间，求任意两个时间之间的最小时间差<br>
     * @param timePoints <code>String</code> 形如“00:00”的表示时间的字符串
     * @return <code>int</code> -最小时间差
     */
    public int findMinDifference(List<String> timePoints){
        if (timePoints.size() > 1440){
            return 0;
        }
        //数组下标对应00:00~23:29的每分钟的时间，例如:下标0对应00:00,下标1对应00:01 ..。
        //数组值对应时间点是否出现（0表示出现，n表示未出现n次）
        int[] timeMap = new int[1440];

        for (String timePoint : timePoints) {
            String[] split = timePoint.split(":");
            int minute = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            if (timeMap[minute] != 0) {
                return 0;
            }
            timeMap[minute] = 1;
        }

        int minDiff = timeMap.length - 1;
        int prev = -1;
        int first = timeMap.length - 1;
        int last = -1;
        for (int i = 0; i < timeMap.length; i++) {
            if (timeMap[i] != 0){
                if (prev > 0){
                    minDiff = Math.min(i - prev,minDiff);
                }
                prev = i;
                first = Math.min(i,first);
                last = Math.max(i,last);
            }
        }
        minDiff = Math.min(first + timeMap.length - last , minDiff);
        return minDiff;
    }

}
