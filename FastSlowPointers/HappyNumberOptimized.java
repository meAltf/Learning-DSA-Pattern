package FastSlowPointers;

public class HappyNumberOptimized {

    private static int getNext(int num) {
        int totalSum = 0;
        while (num > 0) {
            int digit = num % 10;
            totalSum += (int) Math.pow(digit, 2);
            num = num / 10;
        }
        return totalSum;
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    public static void main(String[] args) {
        int num = 2;
        boolean result = isHappy(num);
        System.out.println("The given is Happy number? : " + result);
    }
}
