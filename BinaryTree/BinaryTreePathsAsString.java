package BinaryTree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int data) {
        this.data = data;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreePathsAsString {

    private static void dfsHelper(TreeNode root, String path, List<String> result) {
        if (root == null) return;

        // take the first path
        path += root.data;

        // check if it is a left node
        if (root.left == null && root.right == null) {
            result.add(path);
        } else {
            path += "->";
            dfsHelper(root.left, path, result);
            dfsHelper(root.right, path, result);
        }
    }

    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        dfsHelper(root, "", result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);


        List<String> paths = binaryTreePaths(root);
        System.out.println(paths);
    }
}
