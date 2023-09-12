package main.day5;

import main.utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一棵二叉树，分别按照二叉树先序，中序和后序打印所有的节点。
 * @author fisher
 * @version 1.0.1 2023/9/8 - 18:15
 */
public class BinaryTreeOrder {
    /**
     * 输入：{1,2,3} <br>
     * 返回值：[[1,2,3],[2,1,3],[2,3,1]]<br>
     *
     * <br>
     * 前序：中、左、右<br>
     * 中序：左、中、右<br>
     * 后序：左、右、中<br>
     *
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        // write code here
        List<Integer> preOrder = preOrder(root);
        List<Integer> inOrder = inOrder(root);
        List<Integer> postOrder = postOrder(root);
        int size = preOrder.size();
        int[][] res = new int[3][size];
        int index = 0;

        for(int j = 0; j < 3; j++){
            switch (j){
                case 0:
                    for (int elem : preOrder){
                        res[j][index++] = elem;
                    }
                    index=0;
                    break;
                case 1:
                    for (int elem : inOrder){
                        res[j][index++] = elem;
                    }
                    index=0;
                    break;
                case 2:
                    for (int elem : postOrder){
                        res[j][index++] = elem;
                    }
                    index=0;
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        integers.forEach(System.out::println);
    }

    /**
     * 先序遍历二叉树（中、左、右）
     * @param root TreeNode类 the root of binary tree
     * @return int整型一维数组
     */
    public List<Integer> preOrder(TreeNode root){

        List<Integer> preRes = new ArrayList<Integer>();

        if(root == null){
            return preRes;
        }
        preRes.add(root.val);
        preRes.addAll(preOrder(root.left));
        preRes.addAll(preOrder(root.right));

        return preRes;
    }

    /**
     * 中序遍历二叉树（左、中、右）
     * @param root TreeNode类 the root of binary tree
     * @return int整型一维数组
     */
    public List<Integer> inOrder(TreeNode root){
        List<Integer> inRes = new ArrayList<Integer>();

        if(root == null){
            return inRes;
        }
        inRes.addAll(inOrder(root.left));
        inRes.add(root.val);
        inRes.addAll(inOrder(root.right));

        return inRes;
    }

    /**
     * 后序遍历二叉树（左、右、中）
     * @param root TreeNode类 the root of binary tree
     * @return int整型一维数组
     */
    public List<Integer> postOrder(TreeNode root){
        List<Integer> postRes = new ArrayList<Integer>();

        if (root == null){
            return postRes;
        }
        postRes.addAll(postOrder(root.left));
        postRes.addAll(postOrder(root.right));
        postRes.add(root.val);
        return postRes;
    }
}
