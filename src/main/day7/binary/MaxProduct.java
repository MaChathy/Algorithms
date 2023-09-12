package main.day7.binary;

/**
 * 单词长度的最大乘积<br>
 * @author fisher
 * @version 1.0
 */
public class MaxProduct {
    /**
     * 输入一个字符串数组words，<br>
     * 计算不包含相同字符的两个字符串words[i]和words[j]的长度乘积的最大值.<br>
     * 若所有的字符串都包含至少一个相同的字符，返回0<br>
     * @param words <code>String[]</code>
     * @return <code>int</code> 最大乘积
     */
    public int maxProduction(String[] words){
        return solve03(words);
    }

    /**
     * 用哈希表记录字符串中出现的字符<br>
     * 时间复杂度：O(nk + n^2)<br>
     * @param words <code>String[]</code> 字符串数组
     * @return <code>int</code> 最大乘积
     */
    public int solve02(String[] words){
        //二位数组记录字符串数组中每个字符串字母a~z是否出现
        boolean[][] flag = new boolean[words.length][26];
        //初始化每个字符串对应的哈希表,平均每个字符串长度为k，时间复杂度为：O(nK)
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()){
                flag[i][c - 'a'] = true;
            }
        }
        int result = 0;
        //判断n^2对字符串，时间复杂度为O(n^2)
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1;j < words.length;j++){
                int k = 0;
                for (;k < 26;k++){
                    if (flag[i][k] && flag[j][k]){
                        break;
                    }
                }
                if (k == 26){
                    int temp = words[i].length() * words[j].length();
                    result = Math.max(temp,result);
                }
            }
        }
        return result;
    }

    /**
     * 用整数的二进制数位记录字符串中出现的字符<br>
     * 一个数与它自身相与的结果为0。<br>
     * 时间复杂度：O(nk + n^2)
     * @param words <code>String[]</code> 字符串数组
     * @return <code>int</code> 最大乘积
     */
    public int solve03(String[] words){

        int[] flags = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()){
                //将D(c - 'a')位置1
                flags[i] |= 1 << (c - 'a');
            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1;j < words.length;j++){
                if ((flags[i] & flags[j]) == 0){
                    int temp = words[i].length() *words[j].length();
                    result = Math.max(temp,result);
                }
            }
        }

        return result;
    }

    /**
     * 暴力算法: <br>
     * &nbsp;&nbsp;不重复遍历字符串数组的两个元素的组合，若字符串数组长度为 n ，则有n*(n-1)/2种组合;<br>
     * &nbsp;&nbsp;判断每组是否包含相同的字符，调用<code>isContain()</code>函数，若不包含则计算长度乘积;<br>
     * &nbsp;&nbsp;返回最大的乘积<br>
     * 时间复杂度：O(n^2)
     * @param words <code>String[]</code> 字符串数组
     * @return <code>int</code> 最大乘积
     */
    public int solve01(String[] words){
        int result = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1;j < words.length;j++){
                int temp = 0;
                if (!isContain(words[i],words[j])) {
                    temp = words[i].length() * words[j].length();
                }
                result = Math.max(temp,result);
            }
        }
        return result;
    }

    /**
     * 判断两个字符串是否含有相同的字符<br>
     * 若含有相同的字符返回true，否则返回false<br>
     * 时间复杂度：O(pq),(str1 长度为p，str2长度为q)<br>
     * @param str1 <code>String</code>
     * @param str2 <code>String</code>
     * @return <code>boolean</code> 若含有相同的字符，返回true;否则返回false
     */
    public boolean isContain(String str1,String str2){
        int n = 0;
        while(n < str1.length() || n < str2.length()){
            if (n <= str1.length() - 1 ? str2.contains(str1.charAt(n++)+""):str1.contains(str2.charAt(n++)+"")) {
                return true;
            }
        }
        return false;
    }

}
