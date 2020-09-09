package com.util;


//创建树的节点结构
public class TreeNode {
    int val;
    private TreeNode left;
    private TreeNode right;
    TreeNode(int x) { val = x; }
    public TreeNode getLeft() {
        return left;
    }
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    public TreeNode getRight() {
        return right;
    }
    public void setRight(TreeNode right) {
        this.right = right;
    }
}
