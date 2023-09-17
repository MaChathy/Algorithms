package main.day10.string;

/**
 * 最多删除一个字符得到回文
 * @author fishre
 * @version 1.0
 */
public class ValidPalindrome {

    /**
     * 给定一个字符串，判断从字符串中删除一个字符能不能得到一个字符<br><br>
     * 时间复杂度：O(n)<br>
     * 空间复杂度：O(1)<br>
     *
     * @param s <code>String</code>-字符串s
     * @return <code>boolean</code>-若能，返回true;否则，返回false;
     */
    public boolean validPalindrome(String s){
        int pre = 0;
        int post = s.length() - 1;
        for (;pre < s.length() >> 1;pre++,post--){
            if (s.charAt(pre) != s.charAt(post))
                break;
        }
        return pre == s.length() / 2
                || isPalindrome(s,pre,post - 1)
                || isPalindrome(s,pre + 1,post);
    }

    private static boolean isPalindrome(String s,int start,int end){
        while(start < end){
            if (s.charAt(start) != s.charAt(end))
                break;
            start++;
            end--;
        }
        return start >= end;
    }
}
