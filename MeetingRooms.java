/*

Leetcode Problem 252: Meeting Rooms (Easy)

Given an array of meeting time intervals consisting of start and end times
[[s1, e1], [s2, e2], ...] with s_i < e_i,
determine if a person could attend all meetings.

Complexity for this solution:
O(n log n) time (sorting) and O(1) space

*/

import java.util.Arrays;

public class MeetingRooms {

    public static boolean canAttendMeetings(int[][] intervals) {
        // sort meetings by starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // can also sort as follows:
        //Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // if any meeting starts before the previous one ended, it is not possible to attend all
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }

        // can attend all meetings
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        //int[][] intervals = {{7, 10}, {2, 4}};
        System.out.println(canAttendMeetings(intervals));
    }
}