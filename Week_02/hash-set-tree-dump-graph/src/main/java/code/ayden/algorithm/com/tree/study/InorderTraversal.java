package code.ayden.algorithm.com.tree.study;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 二叉树的中序遍历
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
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            output.add(cur.val);
            cur = cur.right;
        }
        return output;
    }

    public List<Integer> inorderTraversalMorris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }

    /**
     * 莫里斯中序遍历，不改变树结构
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalMorris2(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode pre = cur.left;
                while ((pre.right != null) && (pre.right != cur)) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    output.add(cur.val);
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
