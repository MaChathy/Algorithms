package main.day10.string;

import java.util.HashMap;

/**
 * 包含所有字符的最短字符串
 * @author fisher
 * @version 1.0
 */
public class MinContainString {

    /**
     * 输入两个字符串s和t，请找出字符串s中包含字符串t的所有字符的最短子字符串。<br><br>
     * 时间复杂度：O(n)<br>
     * 空间复杂度：O(1)<br>
     * @param s <code>String</code>-字符串s
     * @param t <code>String</code>-字符串t
     * @return <code>String</code>-若存在，则返回最短子字符串；否则返回空字符串""
     */
    public String minWindow(String s,String t){

        HashMap<Character,Integer> charToCount = new HashMap<>();

        for (char ch : t.toCharArray()){
            charToCount.put(ch,charToCount.getOrDefault(ch,0) + 1);
        }

        int count = charToCount.size();

        int start = 0;
        int end = 0;
        int minStart = 0;
        int minEnd = 0;
        int minLength = Integer.MAX_VALUE;
        while (end < s.length() || (count == 0 && end == s.length())){
            if (count > 0){
                char endChar = s.charAt(end);
                if (charToCount.containsKey(endChar)){
                    charToCount.put(endChar,charToCount.get(endChar) - 1);
                    if (charToCount.get(endChar) == 0){
                        count--;
                    }
                }
                end++;
            }else {
                if (end -start < minLength){
                    minLength = end - start;
                    minStart = start;
                    minEnd = end;
                }
                char startChar = s.charAt(start);
                if (charToCount.containsKey(startChar)){
                    charToCount.put(startChar,charToCount.get(startChar) + 1);
                    if (charToCount.get(startChar) == 1){
                        count++;
                    }
                }
                start++;
            }
        }
        return minLength < Integer.MAX_VALUE ? s.substring(minStart,minEnd) : "";
    }

}
