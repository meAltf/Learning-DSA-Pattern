package SlidingWindow;

public class MinWindowSubStringBruteForce {

    private static boolean checkContainsAll(String subStr, String t) {
        char[] subCount = new char[128];
        char[] tCount = new char[128];

        for (char c : subStr.toCharArray()) subCount[c]++;
        for (char c : t.toCharArray()) tCount[c]++;

        for (int i = 0; i < 128; i++) {
            if (tCount[i] > subCount[i]) return false;
        }
        return true;
    }

    public static String minWindow(String s, String t) {
        int n = s.length(), minLength = Integer.MAX_VALUE;
        String minWindow = "";
        if (t.length() > s.length()) return "";

        for (int i = 0; i < n; i++) {
            for (int j = i; j <= n; j++) { // going to find substring so last index is excluded
                String subStr = s.substring(i, j);
                if (checkContainsAll(subStr, t)) {
                    if (subStr.length() < minLength) {
                        minLength = subStr.length();
                        minWindow = subStr;
                    }
                }
            }
        }
        return minWindow;
    }

    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String t = "ABC";

        String result = minWindow(str, t);
        System.out.println(result);
    }
}
