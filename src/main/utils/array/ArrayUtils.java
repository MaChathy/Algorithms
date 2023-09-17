package main.utils.array;

/**
 * 数组工具类
 * @author fisher
 * @version 1.0
 */
public class ArrayUtils {

    /**
     * 判断数组是否全为0
     * @param array <code>int[]</code>-整形数组
     * @return <code>boolean</code>-若全为0，返回true，否则返回false
     */
    public static boolean isAllZero(int[] array){
        for (int n : array){
            if (n != 0){
                return false;
            }
        }
        return true;
    }
    /**
     * 判断数组中是否有数据大于1
     * @param array <code>int[]</code>-整形数组
     * @return <code>boolean</code>-若有数据大于1，返回true，否则返回false
     */
    public static boolean hasGreatThan1(int[] array){
        for (int n : array){
            if (n > 1){
                return true;
            }
        }
        return false;
    }


}
