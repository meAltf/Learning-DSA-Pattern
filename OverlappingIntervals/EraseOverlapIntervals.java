package OverlappingIntervals;

import java.util.Arrays;

public class EraseOverlapIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;

        // 1. sort the intervals by their end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        // 2. take curr interval and check
        int currIntervalEnd = intervals[0][1];
        int count = 0;

        // 3. Iterate over it, check
        for (int i = 1; i < intervals.length; i++) {
            if(currIntervalEnd > intervals[i][0]) count++;

            else currIntervalEnd = intervals[i][1];
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 100}, {1, 11}, {11, 22}, {2, 12}};
        int result = eraseOverlapIntervals(input);

        System.out.println("Count of intervals needs to remove: " + result);
    }
}
