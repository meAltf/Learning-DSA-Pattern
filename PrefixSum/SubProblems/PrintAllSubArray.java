package PrefixSum.SubProblems;

public class PrintAllSubArray {

    private static void printAllSubArr(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                //print sub-array
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1};
        printAllSubArr(arr);
    }
}
