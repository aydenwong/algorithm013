package com.ayden.algorithm.code.tree.study;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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


    public List<Integer> preOrder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;
    }


}
