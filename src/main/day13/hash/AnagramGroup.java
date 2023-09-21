package main.day13.hash;

import java.util.*;

/**
 * 变位词组<br>
 * @author fisher
 * @version 1.0
 */
public class AnagramGroup {

    /**
     * 变位词组
     * @param words <code>String[]</code> 字符串数组
     * @return <code>List<code><</code>String></code> -列表
     */
    public static List<List<String>> groupAnagrams(String[] words){
        int[] hash = {2,3,5,7,11,13,15,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
        Map<Long,List<String>> groupMap = new HashMap<>();
        for (String str : words){
            long wordHash = 1;
            for (char ch : str.toCharArray()){
                wordHash *= hash[ch - 'a'];
            }
            groupMap.putIfAbsent(wordHash,new LinkedList<String>());
            groupMap.get(wordHash).add(str);
        }
        return new LinkedList<>(groupMap.values());
    }

    public static List<List<String>> groupAnagram(String[] words){
        Map<String,List<String>> groupMap = new HashMap<>();
        for (String str : words){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String sorted = new String(chs);

            groupMap.putIfAbsent(sorted,new LinkedList<String>());
            groupMap.get(sorted).add(str);
        }
        return new LinkedList<>(groupMap.values());
    }
}
