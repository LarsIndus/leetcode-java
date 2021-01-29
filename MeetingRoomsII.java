/*

Leetcode Problem 252: Meeting Rooms II (Medium)

Given an array of meeting time intervals consisting of start and end times
[[s1, e1], [s2, e2], ...] with s_i < e_i,
find the minimum number of conference rooms required.

Complexity for this solution:
O(n log n) time (sorting) and O(n) space (worst case if n rooms are needed)

*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    
    // solution using a min heap
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        // sort meetings by starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // can also sort as follows:
        //Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // build a heap with "running" meetings sorted by end time and add the first meeting
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] currentMeeting = intervals[i];
            int[] endsEarliest = minHeap.peek();
            // If the current meeting starts after the first running meeting ends,
            // we don't need another room --> remove from heap
            if (currentMeeting[0] >= endsEarliest[1]) {
                minHeap.poll();
            }

            // in either case, the current meeting is added onto the heap
            minHeap.add(currentMeeting);

            // After each iteration of this loop, we have either added a meeting onto the heap
            // (= we need one more room) or we have replaced one
            // (= we don't need another room as we can hold the meetings one after another)
        }

        // the result is the number of meetings in the heap after all meetings have been processed
        return minHeap.size();
    }

    public static void main(String[] args) {
        //int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        //int[][] intervals = {{7, 10}, {2, 4}};
        int[][] intervals = {{20, 35}, {0, 30}, {25, 40}, {10, 20}};
        System.out.println(minMeetingRooms(intervals));
    }
}