package MonotonicStack;

import java.util.Stack;

public class FindNextGreaterElement1Optimized {

    public static int[] nextGreaterElementOptimized(int[] nums1) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();

        // 1. Iterate from end of the array
        for (int i = nums1.length - 1; i >= 0; i--) {
            int element = nums1[i];

            // 2. if stack is empty, no next greater element
            if (stack.isEmpty()) {
                stack.push(element);
                result[i] = -1;
                continue;
            }

            // 3. If top element of stack is greater than curr element, then it's the next greater element
            if (stack.peek() > element) {
                stack.push(element);
                result[i] = stack.peek();
                continue;
            }

            // 4. if top elements is less than curr element, remove all element, until u didn't find greater or stack will be empty
            while (!stack.isEmpty() && stack.peek() <= element) {
                stack.pop();
            }

            // 5. if again stack went empty, next greater -1, if not then
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(element);
        }
        return result;
    }


    public static void main(String[] args) {

        int[] input = {2, 1, 2, 4, 3};
        int[] res = nextGreaterElementOptimized(input);
        for (int num : res) {
            System.out.print(num + " ");
        }

    }
}
