package code.ayden.algorithm.com.tree.practice;

import code.ayden.algorithm.com.tree.study.PreOrder;

import java.util.*;

/**
 * @description: 多叉树的层序遍历
 * @author: aydenwang
 * @create: 2020-08-09 19:41
 * @version: 1.0.0
 **/
public class LevelOrder {

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


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> nodeQueue = new ArrayDeque<>();

        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                Node poll = nodeQueue.poll();
                list.add(poll.val);
                for (Node child : poll.children) {
                    nodeQueue.offer(child);
                }
            }
            result.add(list);
        }
        return result;
    }

}
