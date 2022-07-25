package com.company;

public class leetcode226 {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {

        if ( root == null)
            return null;
        if (root.left == null)
            return new TreeNode(root.val, invertTree(root.right), null);
        if (root.right == null)
            return new TreeNode(root.val, null,invertTree(root.left));

        return new TreeNode(root.val,  invertTree(root.right),  invertTree(root.left));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
