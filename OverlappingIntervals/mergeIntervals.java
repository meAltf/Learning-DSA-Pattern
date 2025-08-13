package OverlappingIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeIntervals {

    private static int[][] merge(int[][] intervals) {
        List<int[]> resultList = new ArrayList<>();

        // 1. sort the intervals by start time of intervals
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. Add the first interval in the list
        int[] currInterval = intervals[0];
        resultList.add(currInterval);

        // 3. Iterate and merge if overlapping
        for (int i = 1; i < intervals.length; i++) {
            int currEnd = currInterval[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (currEnd >= nextStart) {
                // overlap | merge by updating end time
                currInterval[1] = Math.max(currEnd, nextEnd);
            } else {
                // no overlap | add next interval
                currInterval = intervals[i];
                resultList.add(currInterval);
            }
        }
        return resultList.toArray(new int[resultList.size()][]);
    }

    public static void main(String[] args) {
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = merge(input);

        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }

    }
}
