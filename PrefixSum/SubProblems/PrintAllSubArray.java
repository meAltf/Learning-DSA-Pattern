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

    private static void filterContiguousArrEqualO1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int cnt0 = 0, cnt1 = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] == 0) cnt0++;
                else cnt1++;
                if (cnt0 == cnt1) {
                    for (int k = i; k <= j; k++) {
                        System.out.print(arr[k] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1};
        // printAllSubArr(arr);
        filterContiguousArrEqualO1(arr);
    }
}
