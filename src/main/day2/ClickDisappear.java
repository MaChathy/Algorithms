package main.day2;

import java.util.Scanner;

/**
 * 点击消除
 * 每次“点击”，可以把字符串中相邻两个相同字母消除，
 * 例如，字符串"abbc"点击后可以生成"ac"。
 * 但相同而不相邻、不相同的相邻字母都是不可以被消除的。
 * 求字符串的最终形态
 * 
 * @author fisher
 * @version 1.0
 */
public class ClickDisappear {

    /**
     * 输入：一个字符串，仅由小写字母组成。（字符串长度不大于300000）
     * 输出：一个字符串，为“点击消除”后的最终形态。若最终的字符串为空串，则输出0。
     * 例如，
     * 输入：abbc、acbbc
     * 输出：ac、 a
     */
    public static void clickFunction(String str) {
        // Scan电梯调度算法
        StringBuilder sb = new StringBuilder(str.length());
        int index = -1;
        for (int i = 0; i < str.length(); i++) {
            if (index == -1 || sb.charAt(index) != str.charAt(i)) {
                sb.append(str.charAt(i));
                index++;
            } else {
                sb.deleteCharAt(index--);
            }
        }
        System.out.println((sb.length() != 0) ? sb.toString() : 0);
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String str = read.nextLine();
        clickFunction(str);
        read.close();
    }
}
