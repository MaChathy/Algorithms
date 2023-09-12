package main.day5;

import main.utils.tree.TreeNode;

import java.util.Arrays;

/**
 * 从中序与后序遍历序列构造二叉树
 * @author fisher
 * @version 1.0.1 2023/9/8 - 19:05
 */
public class BuildBinaryTree {
    /**
     * 给定一个二叉树的中序与后序遍历结果，根据两个序列构造符合这两个序列的二叉树<br><br>
     * 输入：[2,1,4,3,5],[2,4,5,3,1]<br>
     * 输出：{1,2,3,#,#,4,5}<br><br>
     *
     * @param inorder int整型一维数组 中序遍历序列
     * @param postorder int整型一维数组 后序遍历序列
     * @return TreeNode类
     */
    public TreeNode buildTree (int[] inorder, int[] postorder) {
        // write code here
        int count = postorder.length;
        TreeNode root = new TreeNode(postorder[count-1]);
        for(int i = 0;i < count;i++){
            if(root.val == inorder[i]){
                root.left = buildTree(
                        Arrays.copyOfRange(inorder,0,i),
                        Arrays.copyOfRange(postorder,0,i));
                root.right = buildTree(
                        Arrays.copyOfRange(inorder,i+1,count),
                        Arrays.copyOfRange(postorder,i,count-1));
                return root;
            }
        }
        return root;
    }
}
