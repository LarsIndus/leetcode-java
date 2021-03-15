/*

Leetcode Problem 220: Contains Duplicate III (Medium)

Given an array of integers, find out whether there are two distinct indices i and j in the array
such that the absolute difference between nums[i] and nums[j] is at most t
and the absolute difference between i and j is at most k.

Complexity for this solution:
O(n) time and O(k) space

*/

import java.util.Map;
import java.util.HashMap;

public class ContainsDuplicateIII {

    /* 
    Bucket and sliding window approach:
    First, shift all values to start at 0, then put them into buckets of size t + 1
    (i.e., the distance between two elements from the same bucket is at most t).
    This is achieved by doing integer division by t + 1; note that we shifted every element to start at 0.
    For example, if t = 3, buckets will look as follows:

    buckets[0] = {0, 1, 2, 3}
    buckets[1] = {4, 5, 6, 7}
    ...

    Everytime we calculate the bucket for a value, we put the bucket-value pair into a map.
    By using a sliding window approach like in 'Contains Duplicate II' (no. 219),
    we make sure that we only compare values whose indices have distance <= k.
    If we see two values from the same bucket, we can immediately return true
    (distance within one bucket is at most t).
    The other two possibilities for elements with distance <= t are the two adjacent buckets.
    For these, we check the distance additionally.
    */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // initial check
        if (k < 1 || t < 0) return false;

        // Set up a map to keep track of buckets and values that fall into these buckets.
        Map<Long, Long> map = new HashMap<>();

        // Process all the numbers.
        for (int i = 0; i < nums.length; i++) {
            // Shift values to start at 0; make it a long to prevent overflow.
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            // calculate bucket
            long bucket = remappedNum / ((long) t + 1);

            // If we see the same bucket again, return true immediately
            // (all elements in the same bucket have distance <= t).
            // If we see one of the adjacent buckets (bucket +- 1),
            // check additionally whether the distance is at most t.
            // For all other buckets, the distance will be > t.
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t)) {
                            return true;
            }

            // Make sure the map always has size <= k, to ensure that indices have distance <= k.
            if (i >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }

            // Put the latest bucket with its value in the map.
            // Note that there will always be at most one element in each bucket,
            // otherwise the function would have returned true already (first check above).
            // Thus, no need to worry about overwriting old mappings.
            map.put(bucket, remappedNum);
        }

        // all checks have failed
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0, 4, 3, 2, 1, 8, 7, 6, 9};
        int t = 3;
        int k = 2;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }
}