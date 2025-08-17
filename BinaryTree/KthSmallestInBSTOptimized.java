package BinaryTree;

public class KthSmallestInBSTOptimized {
    static int count;
    static int result;

    private static void dfsHelper(TreeNode root) {
        if (root == null) return;

        dfsHelper(root.left);
        count--;
        if (count == 0) {
            result = root.data;
            return;
        }

        dfsHelper(root.right);
    }

    private static int kthSmallestOptimized(TreeNode root, int k) {
        if (root == null) return -1;
        count = k;
        result = -1;
        dfsHelper(root);

        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        int k = 3;

        int result = kthSmallestOptimized(root, 3);
        System.out.println("Final result: " + result);
    }
}
