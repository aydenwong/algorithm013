package com.ayden.algorithm.code.tree.study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 二叉树的前序遍历
 * @author: aydenwang
 * @create: 2020-08-09 15:08
 * @version: 1.0.0
 **/
public class preorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                output.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return output;
    }

    public List<Integer> preorderTraversalMorris(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode pre = cur.left;
                while ((pre.right != null) && (pre.right != cur)) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    output.add(cur.val);
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    cur = cur.right;
                }
            } else {
                output.add(cur.val);
                cur = cur.right;
            }
        }
        return output;
    }
}
