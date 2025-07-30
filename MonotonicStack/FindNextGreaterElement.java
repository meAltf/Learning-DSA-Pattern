package MonotonicStack;

public class FindNextGreaterElement {

    private static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break;
                } else {
                    result[i] = -1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {2, 1, 2, 4, 3};
        int[] res = nextGreaterElement(input);
        for (int num : res) {
            System.out.print(num + " ");
        }

    }
}
