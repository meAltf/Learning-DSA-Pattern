package MonotonicStack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = (j - i);
                    break;
                } else result[i] = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // check here..
    }
}
