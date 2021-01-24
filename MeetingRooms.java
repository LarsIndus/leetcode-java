/*

Leetcode Problem 252: Meeting Rooms (Easy)

Given an array of meeting time intervals consisting of start and end times
[[s1, e1], [s2, e2], ...] with s_i < e_i determine if a person could attend all meetings.

Complexity for this solution:
O(n log n) time (sorting) and O(1) space

*/

import java.util.Arrays;

public class MeetingRooms {
    
    private static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static boolean canAttendMeetings(Interval[] intervals) {
        // sort meetings by starting time
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));

        // if any meeting starts before the previous one ended, it is not possible to attend all
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }

        // can attend all meetings
        return true;
    }

    public static void main(String[] args) {
        //Interval[] intervals = {new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
        Interval[] intervals = {new Interval(7, 10), new Interval(2, 4)};
        System.out.println(canAttendMeetings(intervals));
    }
}
