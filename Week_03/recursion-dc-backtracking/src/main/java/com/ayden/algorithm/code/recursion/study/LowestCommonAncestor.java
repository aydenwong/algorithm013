package com.ayden.algorithm.code.recursion.study;


import com.ayden.algorithm.code.common.TreeNode;

/**
 * @description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * @author: aydenwang
 * @create: 2020-08-16 20:26
 * @version: 1.0.0
 **/
public class LowestCommonAncestor {

    private TreeNode ans;

    public LowestCommonAncestor() {
        this.ans = null;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }


}
