package main.day13.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的变位词
 * @author fisher
 * @version 1.0
 */
public class AnagramWords {

    /**
     * 给定两个字符串，判断它们是否为一组变位词<br>
     * @param str1 <code>String</code>
     * @param str2 <code>String</code>
     * @return <code>boolean</code> -若是，返回true;否则返回true
     */
    public boolean isAnagram(String str1,String str2){
        //若str1和str2的长度不同，返回false;
        if (str1.length() != str2.length()){
            return false;
        }
        int[] counts = new int[26];
        for (char ch : str1.toCharArray()){
            counts[ch - 'a'] += 1;
        }
        for (char ch : str2.toCharArray()){
            //若str2中的字符未在str1中出现，返回false;
            if (counts[ch - 'a'] == 0){
                return false;
            }
            counts[ch - 'a']--;
        }
        return true;
    }

    public boolean isNotAnagram(String str1,String str2){
        if (str1.length() != str2.length()){
            return true;
        }
        Map<Character,Integer> charMaps = new HashMap<>();
        for (char ch : str1.toCharArray()){
            charMaps.put(ch,charMaps.getOrDefault(ch,0) + 1);
        }
        for (char ch : str2.toCharArray()){
            if (charMaps.getOrDefault(ch,0) == 0){
                return true;
            }
            charMaps.put(ch, charMaps.get(ch) - 1);
        }

        return false;
    }
}
