package BinaryTree;

public class MaximumPathSumInBT {
    static int maxSum;

    private static int dfsHelper(TreeNode root) {
        if (root == null) return 0;

        int left = dfsHelper(root.left);
        int right = dfsHelper(root.right);

        int neeche_answer_mil_gaya = left + right + root.data; // 1 - not possible to return
        int koi_ek_acha = Math.max(left, right) + root.data; // 2
        int only_root_acha = root.data; // 3

        // maxSum = Math.max(maxSum, neeche_answer_mil_gaya, koi_ek_acha, only_root_acha);
        maxSum = Math.max(maxSum, Math.max(neeche_answer_mil_gaya, Math.max(koi_ek_acha, only_root_acha)));

        return Math.max(koi_ek_acha, only_root_acha);
    }

    private static int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxSum = Integer.MIN_VALUE;

        dfsHelper(root);
        return maxSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        int result = maxPathSum(root);

        System.out.println(result);

    }
}
