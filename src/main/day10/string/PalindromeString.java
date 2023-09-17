package main.day10.string;

/**
 * 回文字符串
 * @author fisher
 * @version 1.0
 */
public class PalindromeString {

    /**
     * 输入一个字符串s，判断字符串是否是回文字符串<br><br>
     * 假设只需要考虑字母和数字字符<br>
     * 时间复杂度：O(n)<br>
     * 空间复杂度：O(1)<br>
     *
     * @param s <code>String</code>-字符串s
     * @return <code>boolean</code>若是回文字符串，返回true；否则返回false
     */
    public static boolean isPalindrome(String s){
        int pre = 0;
        int post = s.length()-1;
        while(pre < post){
            char preChar = s.charAt(pre);
            char postChar = s.charAt(post);
            if (!Character.isLetterOrDigit(preChar)){
                pre++;
            } else if (!Character.isLetterOrDigit(postChar)){
                post--;
            }else{
                if (Character.toLowerCase(postChar) != Character.toLowerCase(preChar)){
                    return false;
                }
                pre++;
                post--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("1Did1"));
        System.out.println(isPalindrome("Race a car"));
    }

}
