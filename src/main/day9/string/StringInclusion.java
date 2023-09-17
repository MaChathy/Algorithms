package main.day9.string;

import main.utils.array.ArrayUtils;

import java.util.Arrays;

/**
 * 字符串中的变位词<br>
 * @author fisher
 * @version 1.0
 */
public class StringInclusion {

    /**
     * 输入字符串s1和字符串s2，判断字符串s2是否包含s1的变位词。<br><br>
     * 时间复杂度：O(m+n) m，n为字符串s1，s2的长度<br>
     * 空间复杂度：O(1)<br>
     * @param s1 <code>String</code>-字符串s1，只包含英文小写字母
     * @param s2 <code>String</code>-字符串s2，只包含英文小写字母
     * @return <code>boolean</code>-若s2包含s1的变位词，true;否则为false
     * @see ArrayUtils -用到<code>isAllZero(int[] array)</code>方法
     */
    public boolean checkInclusion(String s1,String s2){
        if (s2.length() < s1.length()){
            return false;
        }
        //用以为数组模拟26个小写英文字母与其出现次数的映射
        //0~25下标分别对应a~z小写英文字母，数据值对应出现次数
        int[] counts = new int[26];
        //判断s2中字符串s1的长度是否包含s1的变位词
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        if (ArrayUtils.isAllZero(counts)){
            return true;
        }
        for (int i = s1.length();i < s2.length();i++){
            counts[s2.charAt(i) - 'a']--;
            counts[s2.charAt(i - s1.length()) - 'a']++;
            if (ArrayUtils.isAllZero(counts)){
                return true;
            }
        }

        return false;
    }

}
