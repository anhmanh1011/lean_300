package com.company;

public class LeetCode53 {
    public static void main(String[] args) {

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int right = Math.max(p.val, q.val);
        int left = Math.min(p.val, q.val);

        if (root.val > right) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < left)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
