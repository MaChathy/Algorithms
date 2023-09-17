package main.day9.string;

import main.utils.array.ArrayUtils;

/**
 * 不包含重复字符的最长子字符串
 * @author fisher
 * @version 1.0
 */
public class MaxSubString {

    /**
     * 输入一个字符串,求该字符串中不包含重复字符的最长子字符串<br><br>
     * @param s <code>String</code>-字符串s1
     * @return <int>int</int>
     * @see ArrayUtils -用到<code>hasGreatThan1(int[] array)</code>方法
     */
    public int lengthOfLongestSubString(String s){
        int[] counts = new int[256];
        int result = 1;
        int left = 0;
        for (int right = 0;right < s.length();right++){
            counts[s.charAt(right)]++;
            while(ArrayUtils.hasGreatThan1(counts)){
                counts[s.charAt(left++)]--;
            }
            result = Math.max(result,right - left + 1);
        }
        return result;
    }

}
