package code.ayden.algorithm.com.tree.study;

import java.util.*;

/**
 * @description: 多叉树的层序遍历
 * @author: aydenwang
 * @create: 2020-08-09 19:32
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

    /**
     * 使用队列，广度优先遍历树
     * 时间复杂度：O(n)O(n)。nn 指的是节点的数量。
     * 空间复杂度：O(n)O(n)，我们的列表包含所有节点。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curr = queue.poll();
                curLevel.add(curr.val);
                for (Node c : curr.children) {
                    queue.offer(c);
                }
            }
            ret.add(curLevel);
        }

        return ret;
    }


}
