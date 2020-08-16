package com.ayden.algorithm.code.tree.practice;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.*;

/**
 * @description: 二叉树的中序遍历
 * <p>
 * 中序遍历是说：对于树中的任意节点来说，先打印它的左子树，然后再打印它本身，最后打印它的右子树
 * @author: aydenwang
 * @create: 2020-08-09 10:42
 * @version: 1.0.0
 **/
public class InorderTraversal {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归法
     * <p>
     * 时间复杂度：O(n)O(n)。递归函数 T(n) = T(n)=2⋅T(n/2)+1。
     * 空间复杂度：最坏情况下需要空间O(n)，平均情况为O(logn)。
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    /**
     * 遍历入栈法
     * 时间复杂度：O(n)。
     * 空间复杂度：O(n)。
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalStack(TreeNode root) {
        // 中序遍历：对于树中的任意节点来说，先打印它的左子树，然后再打印它本身，最后打印它的右子树

        // 思路：用栈来模拟递归
        // 用栈保存元素的遍历顺序，栈顶元素是当前遍历到的节
        // 先遍历根节点的左子树的左边，入栈后，遍历出栈
        // 出栈的元素，如果有右节点，先遍历右节点的左子树，再遍历右子树

        LinkedList<TreeNode> stack = new LinkedList();
        List<Integer> res = new ArrayList<>();

        TreeNode curr = root;

        //注意，条件是或
        while (curr != null || !stack.isEmpty()) {
            //嵌套的while条件，因为每个右孩子也需要从左孩子遍历起到底
            //外层循环右遍历，内层循环左遍历，遇到右孩子，开始左遍历
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pollLast();
            res.add(node.val);
            curr = node.right;
        }
        return res;
    }

    /**
     * 莫里斯遍历法
     * 思路是通过转换，把树变成线性的，可以达到O(1)的空间复杂度
     * 时间复杂度：时间复杂度：O(n)O(n)。 想要证明时间复杂度是O(n)O(n)，最大的问题是找到每个节点的前驱节点的时间复杂度。乍一想，找到每个节点的前驱节点的时间复杂度应该是 O(n\log n)O(nlogn)，因为找到一个节点的前驱节点和树的高度有关。
     * 但事实上，找到所有节点的前驱节点只需要O(n)O(n) 时间。一棵 nn 个节点的二叉树只有 n-1n−1 条边，每条边只可能使用2次，一次是定位节点，一次是找前驱节点。
     * 故复杂度为 O(n)O(n)
     * 空间复杂度：0（1）
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalMorris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;

        TreeNode pre;

        /**
         * Step 1: 将当前节点current初始化为根节点
         * Step 2: While current不为空，
         * 若current没有左子节点
         *     a. 将current添加到输出
         *     b. 进入右子树，亦即, current = current.right
         * 否则
         *     a. 在current的左子树中，令current成为最右侧节点的右子节点
         *     b. 进入左子树，亦即，current = current.left
         */

        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                pre.right = curr;

                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }

        return res;
    }

}
