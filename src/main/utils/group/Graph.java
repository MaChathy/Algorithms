package main.utils.group;

import java.util.ArrayList;
import java.util.List;

/**
 * 加权图
 * @author fisher
 * @version 1.0.1 2023/9/7 - 20:35
 */
public class Graph {

    /**
     * 邻接表的节点
     */
    static class Node{
        // 数据
        int value;
        // 权值
        // int weight;
        Node(int value/*, int weight*/) {
            this.value = value;
            //this.weight = weight;
        }
    };

    /**
     * 邻接表
     */
    List<List<Node>> adjacencyList ;

    /**
     * construction
     * @param edges 边类
     */
    public Graph(List<Edge> edges) {
        //初始化邻接表
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < edges.size(); i++) {
            adjacencyList.add(i, new ArrayList<>());
        }
        //添加边到图中
        for (Edge edge : edges) {
            //在邻接列表中从 src 到 dest 分配新节点
            adjacencyList.get(edge.src).add(new Node(edge.dest/*,edge.weight*/));
        }

    }
}
