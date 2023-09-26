package main.day15.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 制造合金<br>
 * @author fishre
 * @version 1.0
 */
public class MachineMaxNum {

    /**
     * 假设你是一家合金制造公司的老板，你的公司使用多种金属来制造合金。<br>
     * 现在共有 n 种不同类型的金属可以使用，并且你可以使用 k 台机器来制造合金。<br>
     * 每台机器都需要特定数量的每种金属来创建合金。<br>
     * 对于第 i 台机器而言，创建合金需要 composition[i][j] 份 j 类型金属。<br>
     * 最初，你拥有 stock[i] 份 i 类型金属，而每购入一份 i 类型金属需要花费 cost[i] 的金钱。<br>
     * 给你整数 n、k、budget，下标从 1 开始的二维数组 composition，两个下标从 1 开始的数组 stock 和 cost，<br>
     * 请你在预算不超过 budget 金钱的前提下，最大化 公司制造合金的数量。<br><br>
     *
     * @param n <code>int</code> n种不同类型的金属
     * @param k <code>int</code> k台机器
     * @param budget <code>int</code> 预算
     * @param composition <code>List<code><</code>List<code><</code>Integer>></code> 每台机器所需要的金属类型数量
     * @param stock <code>List<code><</code>Integer></code> 每类金属的数量
     * @param cost <code>List<code><</code>Integer></code> 每类金属一份的花费
     * @return <code>int</code -> -可制造最多的金属数量
     */
    public int maxNumberOfAlloys(int n, int k, int budget,
                                 List<List<Integer>> composition,List<Integer> stock,List<Integer> cost){
        int max = 0;
        for (int i = 1; i < k; i++) {
            int amount = 0;
            int oneCost = 0;
            while (budget >= oneCost){
                oneCost = 0;
                amount++;
                for (int j = 1; j < composition.get(i).size(); j++) {
                    if (stock.get(j) < composition.get(i).get(j)){
                        oneCost += (composition.get(i).get(j) - stock.get(j)) * cost.get(j);
                        stock.set(j,0);
                        continue;
                    }
                    stock.set(j,stock.get(j) - composition.get(i).get(j));
                }
            }
            max = Math.max(max,amount);

        }
        return max;
    }

}
