package OverlappingIntervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    private static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> resultList = new ArrayList<>();
        for (int[] interval : intervals) {
            // 1. Current interval ends before new interval starts | No overlap
            if (interval[1] < newInterval[0]) {
                resultList.add(interval);
            }
            // 2. Current interval starts after new interval ends | No overlap | first insert new interval
            else if (interval[0] > newInterval[1]) {
                resultList.add(newInterval);
                newInterval = interval; // to process next all intervals
            } else
                //3. Overlapping intervals
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
        }

        // 4. add the new interval at last
        resultList.add(newInterval);
        return resultList.toArray(new int[resultList.size()][]);
    }


    public static void main(String[] args) {
        int[][] input = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] result = insert(input, newInterval);

        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }

    }
}
