package MonotonicStack;

import java.util.Stack;

public class DailyTemperaturesOptimized {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int curr = temperatures[i];

            if (stack.isEmpty()) {
                stack.add(i);
                result[i] = 0;
                continue;
            }

            while (!stack.isEmpty() && temperatures[stack.peek()] <= curr) {
                stack.pop();
            }

            if (!stack.isEmpty() && temperatures[stack.peek()] > curr) {
                int diff = stack.peek() - i;
                result[i] = diff;
            }

            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures(input);

        for (int res : result) {
            System.out.print(res + " ");
        }
        System.out.println();
    }
}
