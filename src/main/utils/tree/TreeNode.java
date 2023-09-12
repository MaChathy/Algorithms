package main.utils.tree;

/**
 * 二叉树节点
 * @author fisher
 * @version 1.0.1 2023/9/8 - 18:12
 */
public class TreeNode {

    /**
     * data
     */
    public int val = 0;

    /**
     * 左子节点
     */
    public TreeNode left = null;
    /**
     * 右子节点
     */
    public TreeNode right = null;

    /**
     * construction
     * @param val data
     */
    public TreeNode(int val) {
        this.val = val;
    }
}
