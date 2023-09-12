package main.day2.selfdeque;

import java.util.Scanner;

/**
 * @author fisher
 * @version 1.0.1 2023/9/6 - 18:25
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    //static DoubleStackQueue queue = new DoubleStackQueue();
    //static LinkedQueue queue = new LinkedQueue();
    public static void solve01() {
        int n = sc.nextInt();
        ArrayQueue queue = new ArrayQueue(n);
        sc.nextLine();
        while (n-- > 0) {
            String[] arr = sc.nextLine().split(" ");
            if (arr[0].equals("push")) {
                queue.push(Integer.parseInt(arr[1]));
            } else if (arr[0].equals("pop")) {
                Integer pop = (Integer) queue.pop();
                if (pop == null || pop == -1) {
                    System.out.println("error");
                } else {
                    System.out.println(pop);
                }
            } else if (arr[0].equals("front")) {
                Integer top = (Integer) queue.front();
                if (top == null || top == -1) {
                    System.out.println("error");
                } else {
                    System.out.println(top);
                }
            }
        }

    }
    public static void main(String[] args) {
        solve01();
    }
}
