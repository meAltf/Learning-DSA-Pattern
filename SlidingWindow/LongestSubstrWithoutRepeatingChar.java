package SlidingWindow;

import java.util.HashSet;

public class LongestSubstrWithoutRepeatingChar {

    public int lengthOfLongestSubstring(String s) {
        int maxCnt = 0;
        StringBuilder str = new StringBuilder(s);

        for (int i = 0; i < str.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < str.length(); j++) {
                if (set.contains(str.charAt(j))) break;
                set.add(str.charAt(j));
            }
            maxCnt = Math.max(set.size(), maxCnt);
        }
        return maxCnt;
    }
}
