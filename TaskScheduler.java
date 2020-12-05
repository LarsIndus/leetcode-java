/*

Leetcode Problem 621: Task Scheduler (Medium)

Given a characters array tasks, representing the tasks a CPU needs to do,
where each letter represents a different task. Tasks could be done in any order.
Each task is done in one unit of time. For each unit of time,
the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period
between two same tasks (the same letter in the array),
that is that there must be at least n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.

Complexity for this solution:
O(n) time and O(1) space (?)

*/

import java.util.*;

public class TaskScheduler {
    
    public static int leastInterval(char[] tasks, int n) {

        // count how many times each task/character occurs
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // build a max heap for the tasks, so that we can process the most frequent tasks first
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(map.values());

        /*
        Greedy approach:
        Start with the most frequently occurring task, then the next and so on ...
        The minimum cycle length is n + 1 (as there have to be n units in between same tasks),
        so run a loop n + 1 times picking the most frequent tasks.
        Add these tasks to a list, and update the result by adding the length of the list
        (if there are no more tasks to process) or the cycle length (if there are still elements to process).
        */
        int units = 0;
        while(!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            // As long as there are tasks to process, try to construct a cycle of length n + 1
            for (int i = 0; i <= n; i++) {
                if(!maxHeap.isEmpty()) {
                    temp.add(maxHeap.remove());
                }
            }

            // If a task occurred more than once, decrement it and add it to the heap again.
            for (int i : temp) {
                if (i > 1) {
                    maxHeap.add(--i);
                }
            }

            /*
            Update the result:
            If no more elements to process, add the length of the list, otherwise the cycle length.
            Note that while the heap is not empty, temp.size() = n + 1.
            When the heap is empty, temp.size() might be smaller (remaining tasks).
            */
            units += maxHeap.isEmpty() ? temp.size() : (n + 1);
        }

        return units;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

}
