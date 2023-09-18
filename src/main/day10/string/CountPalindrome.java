package main.day10.string;

import main.utils.string.Strings;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;

/**
 * 回文字符串的个数
 * @author fisher
 * @version 1.0
 */
public class CountPalindrome {

    /**
     * 给定一个字符串，求出该字符串中有多少个回文连续子字符串<br><br>
     *
     * 时间复杂度：O(n)<br>
     * 空间复杂度：O(1)<br>
     * @param s <code>String</code>-字符串s
     * @return <code>int</code>-连续回文子字符串的个数
     */
    public int countSubstring(String s){
        if (s == null || s.length() == 0){
            return 0;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindrome(s,i,i);
            count += countPalindrome(s,i,i+1);
        }
        return count;
    }

    /**
     *
     * @param s <code>String</code>-字符串s
     * @param start <code>int</code>-子字符串开始下标
     * @param end <code>int</code>-子字符串结束下标
     * @return <code>int</code>-回文子字符串的个数
     */
    private int countPalindrome(String s,int start,int end) {
        int count = 0;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            count++;
            end++;
            start--;
        }
        return count;
    }
}
