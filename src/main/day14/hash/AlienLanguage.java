package main.day14.hash;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

import java.util.Map;

/**
 * 外星语言是否排序<br>
 * @author fisher
 * @version 1.0
 */
public class AlienLanguage {

    /**
     * 给定一组单词和字母表顺序，请判断这些单词是否按照字母表的顺序排序<br><br>
     * 只包含小写英文字母<br>
     * @param words <code>String[]</code> 字符串数组
     * @param order <code>String</code> 字母表顺序
     * @return <code>boolean</code> 若符合排序条件，返回true;否则返回false
     */
    public boolean isAlienSorted(String[] words,String order){
        //数组下标对应order中的个小写英文字母，值对应是否出现（出现为1，否则为0）
        int[] hash = new int[order.length()];
        for (int i = 0; i < order.length(); i++) {
            hash[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0;i < words.length-1;i++){
            if (!isSorted(words[i],words[i+1],hash)){
                return false;
            }
        }
        return true;
    }

    /**
     * 判断两个字符串是否按照给定的hash顺序排序<br>
     * @param str1 <code>String</code> 字符串
     * @param str2 <code>String</code> 字符串
     * @param hash <code>int[]</code> hash表
     * @return <code>boolean</code> -若是，返回true;否则返回false
     */
    private boolean isSorted(String str1,String str2,int[] hash){
        int i = 0;
        for (; i < str1.length() && i < str2.length(); ++i) {
            if (hash[str1.charAt(i) - 'a'] > hash[str2.charAt(i) - 'a']){
                return false;
            }
            if (hash[str1.charAt(i) - 'a'] < hash[str2.charAt(i) - 'a']){
                return true;
            }
        }
        return i == str1.length();
    }

}
