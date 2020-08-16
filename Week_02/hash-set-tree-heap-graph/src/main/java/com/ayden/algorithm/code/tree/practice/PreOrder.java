package com.ayden.algorithm.code.tree.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 二叉树前序遍历
 * @author: aydenwang
 * @create: 2020-08-09 09:16
 * @version: 1.0.0
 **/
public class PreOrder {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * Recursive 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        prePrint(root, list);
        return list;
    }

    public void prePrint(Node node, List<Integer> list) {
        list.add(node.val);
        for (int i = 0; i < node.children.size(); i++) {
            prePrint(node.children.get(i), list);
        }
    }

    /**
     * iteratively 迭代
     * 使用入栈和出栈的操作，模拟了递归
     * 时间复杂度：O（n），所有的元素都是入栈和出栈一次
     * 空间复杂度：O（M），m是元素个数，最坏的情况下，树只有两层，这样需要一个M-1大小的栈
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<Node> stack = new LinkedList<>();

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            list.add(node.val);
            Collections.reverse(node.children);
            for (Node child : node.children) {
                stack.add(child);
            }
        }

        return list;
    }


}
