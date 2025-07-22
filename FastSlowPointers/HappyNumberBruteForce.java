package FastSlowPointers;

import java.util.HashSet;
import java.util.Set;

public class HappyNumberBruteForce {

    private static int getNextNum(int num) {
        int totalSum = 0;
        while (num > 0) {
            int digit = num % 10;
            totalSum += (int) Math.pow(digit, 2);
            num = num / 10;
        }
        return totalSum;
    }

    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNextNum(n);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        int num = 19; // 2
        boolean result = isHappy(num);
        System.out.println("The number is happy number : " + result);
    }
}
