package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 克隆图
 *
 * @author lintingmin
 * @date 2020-11-21
 */
public class LeetCode133 {
    public static void main(String[] args) {

    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    /**
     * copys[i]表示第i个节点的copy
     */
    private Node[] copys = new Node[100 + 1];

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node copy = new Node(node.val);
        dfs(node, copy);
        return copy;
    }

    private void dfs(Node origin, Node copy) {
        if (copys[origin.val] != null) {
            return ;
        }
        copys[origin.val] = copy;

        List<Node> neighbors = origin.neighbors;
        if (neighbors == null || neighbors.size() == 0) {
            copy.neighbors = new ArrayList<>(0);
            return ;
        }
        copy.neighbors = new ArrayList<>(neighbors.size());
        for (Node neighbor: neighbors) {
            if (copys[neighbor.val] != null) {
                copy.neighbors.add(copys[neighbor.val]);
                continue;
            }
            Node neighborCopy = new Node(neighbor.val);
            copy.neighbors.add(neighborCopy);
            dfs(neighbor, neighborCopy);
        }
    }
}
