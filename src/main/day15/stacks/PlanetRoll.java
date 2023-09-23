package main.day15.stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * 小行星碰撞<br>
 * @author fisher
 * @version 1.0
 */
public class PlanetRoll {

    /**
     * 输入一个表示小行星的数组，<br>
     * 数组中每个数字的绝对值表示小行星的大小,数字的正负号表示小行星的飞行方向，正号表示向右飞行，负号表示向左飞行。<br>
     * 若两个小行星相撞体积小的小行星会消失，体积大的不受影响。<br>
     * 若相撞的两个小行星体积相等，则都会消失<br>
     * 飞行方向相同的小行星永远不会相撞<br>
     * 求最终剩下的小行星<br><br>
     * ex: 4,5,-6,4,8,-5
     *
     * @param asteroids <code>int[]</code> 小行星数组
     * @return <code>int[]</code> -最终剩下的小行星
     */
    public static int[] asteroidCollision(int[] asteroids){
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids){
            //当栈不为空且栈顶数据大于0且小于负的当前数据时，出栈
            while (!stack.empty() && stack.peek() > 0 && stack.peek() < -asteroid){
                stack.pop();
            }
            //若栈不为空且当前数据小于0且栈顶元素等于负的当前元素时，出栈
            if (!stack.empty() && asteroid < 0 && stack.peek() == -asteroid){
                stack.pop();
            }//若栈为空或当前数据大于0或栈顶元素小于0时，入栈
            else if(asteroid > 0 || stack.empty() || stack.peek() < 0){
                stack.push(asteroid);
            }
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }

    public static int[] solve(int[] asteroids){
        for (int i = 0; i < asteroids.length; i++) {
            int prev = i-1;
            while (prev >= 0 && asteroids[i] < 0 && asteroids[prev] > 0){
                if (-asteroids[i] == asteroids[prev]){
                    asteroids[i] = asteroids[prev] = 0;
                }else if(-asteroids[i] > asteroids[prev]){
                    asteroids[prev] = 0;
                }else{
                    asteroids[i] = 0;
                }
                prev--;
            }
        }
        return Arrays.stream(asteroids).filter(elem -> elem != 0).map(i -> i).toArray();
    }

    public static void main(String[] args) {
    }
}
