/*

Leetcode Problem 451: Sort Characters By Frequency (Medium)

Given a string, sort it in decreasing order based on the frequency of characters.

Complexity for this solution:
O(n log n) time and O(n) space

*/

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    public static String frequencySort(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }

        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> charCount.get(b) - charCount.get(a));
        heap.addAll(charCount.keySet());
        StringBuilder sb = new StringBuilder();

        while(!heap.isEmpty()) {
            char c = heap.poll();
            int count = charCount.get(c);
            for (int i = 0; i < count; i++) {
               sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"tree", "aaabbb", "aaabbbb", "hello"};
        for (String s : strings) {
            System.out.println(s + " -> " + frequencySort(s));
        }
    }
}
