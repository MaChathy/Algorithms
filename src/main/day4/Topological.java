package main.day4;

import java.util.ArrayList;

/**
 * 拓扑排序
 * @author fisher
 * @version 1.0.1 2023/9/7 - 19:13
 */
public class Topological {

    static class Graph{

        ArrayList<Integer> val;
        ArrayList<ArrayList<Integer>> relateTable;

        public Graph(){
            val = new ArrayList<>();
            relateTable = new ArrayList<>();
        }


        /**
         * 输入：<br/>
         * &nbsp;&nbsp;5 4<br/>
         * &nbsp;&nbsp;1 2<br/>
         * &nbsp;&nbsp;2 3<br/>
         * &nbsp;&nbsp;3 4<br/>
         * &nbsp;&nbsp;4 5<br/>
         * 输出：<br/>
         * &nbsp;&nbsp;1 2 3 4 5<br/><br/>
         *
         * 元素：5 4 1 2 3<br/>
         * 邻接表：<br/>
         * &nbsp;&nbsp;0 1 2 3 4<br/>
         * 0 0 1 0 0 0<br/>
         * 1 1 0 0 0 1<br/>
         * 3 0 0 1 0 0<br/>
         * 4 0 0 0 1 0<br/>
         *
         * @param data1 int
         * @param data2 int
         */
        public void addElem(int data1,int data2){

        }



    }

    public static void solve(){

    }

    public static void main(String[] args) {
        solve();
    }
}
