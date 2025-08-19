package DFS;

import java.util.ArrayList;
import java.util.List;

// Definition for a Node.
class Node {
    public int data;
    public List<Node> neighbors;

    public Node() {
        data = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int data) {
        this.data = data;
        neighbors = new ArrayList<Node>();
    }

    public Node(int data, ArrayList<Node> _neighbors) {
        this.data = data;
        neighbors = _neighbors;
    }
}

public class CloneGraphDFS {

    private Node[] visited = new Node[101]; // in Leetcode problem mentioned- number of node in graph [0,100]

    public Node cloneGraph(Node node) {
        if (node == null) return node;

        // if clone is already exists
        if (visited[node.data] != null) return visited[node.data];

        // create a clone
        Node cloneNode = new Node(node.data);
        visited[node.data] = cloneNode;

        // recursively call
        for (Node neigh : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neigh));
        }

        return cloneNode;
    }
}
