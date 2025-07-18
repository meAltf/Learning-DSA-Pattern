package SlidingWindow;

import java.util.HashSet;

public class LongestSubStrWithoutRepeatingCharacterOptimized {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), maxCnt = 0;
        int left = 0, right = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxCnt = Math.max(maxCnt, set.size());
                right++;
            } else {
                set.remove(s.charAt(left));
                left++; // shrink the window
            }
        }
        return maxCnt;
    }
}
