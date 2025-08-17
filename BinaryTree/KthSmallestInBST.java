package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestInBST {

    private static void dfsHelper(TreeNode root, List<Integer> arr, int k) {
        if (root == null) return;

        dfsHelper(root.left, arr, k);
        arr.add(root.data);
        dfsHelper(root.right, arr, k);
    }

    private static int kthSmallest(TreeNode root, int k) {
        List<Integer> arrList = new ArrayList<>();

        if (root == null) return -1;
        dfsHelper(root, arrList, k);

        return arrList.get(k - 1);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        int k = 3;

        int num = kthSmallest(root, k);
        System.out.println(k + "th smallest num is: " + num);
    }
}
