package DFS;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class AllPathFromRootToLeaves {

    private static void dfsHelper(TreeNode root, String path, List<String> result) {
        if (root == null) return;

        path += root.data;

        if (root.left == null && root.right == null) {
            result.add(path);
        } else {
            path += "->";
            dfsHelper(root.left, path, result);
            dfsHelper(root.right, path, result);
        }

    }

    private static List<String> findAllPath(TreeNode root) {
        if (root == null) return new ArrayList<>();

        String path = "";
        List<String> resultList = new ArrayList<>();

        dfsHelper(root, path, resultList);

        return resultList;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> result = findAllPath(root);

        System.out.println(result);
    }
}
