package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /** Clone Graph using Map **/
    private Map<Node, Node> visitedMap = new HashMap<>();

    public Node cloneGraphII(Node node) {
        if (node == null) return node;

        // check if existing..
        if (visitedMap.containsKey(node)) return visitedMap.get(node);

        // create a new clone
        Node cloneNode = new Node(node.data);
        visitedMap.put(node, cloneNode);

        // iterate over each node
        for (Node neigh : node.neighbors) {
            cloneNode.neighbors.add(cloneGraphII(neigh));
        }
        return cloneNode;
    }
}
