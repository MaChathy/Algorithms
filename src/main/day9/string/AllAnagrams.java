package main.day9.string;

import main.utils.array.ArrayUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 字符串中所有的变位词
 * @author fisher
 * @version 1.0
 */
public class AllAnagrams {

    /**
     * 输入字符串s1和s2，找出s2的所有变位词在s1中的起始下标<br><br>
     * @param s1 <code>String</code>-字符串s1，只包含英文小写字母
     * @param s2 <code>String</code>-字符串s2，只包含英文小写字母
     * @return <code>List<code><</code>Integer></code>-s2的所有变位词在s1中的起始下标组成的列表
     */
    public List<Integer> findAnagrams(String s1,String s2){
        List<Integer> result = new LinkedList<>();
        if (s1.length() < s2.length()){
            return result;
        }
        int[] counts = new int[26];
        int index = 0;
        for (;index < s2.length();index++){
            counts[s2.charAt(index) - 'a']++;
            counts[s1.charAt(index) - 'a']--;
        }
        if (ArrayUtils.isAllZero(counts)){
            result.add(0);
        }
        for (;index < s1.length();index++){
            counts[s1.charAt(index) - 'a']--;
            counts[s1.charAt(index - s2.length()) - 'a']++;
            if (ArrayUtils.isAllZero(counts)){
                result.add(index - s2.length() + 1);
            }
        }
        return result;
    }

}
