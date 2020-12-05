/*

Leetcode Problem 881: Boats to Save People (Medium)

The i-th person has weight people[i], and each boat can carry a maximum weight of limit.
Each boat carries at most 2 people at the same time,
provided the sum of the weight of those people is at most limit.
Return the minimum number of boats to carry every given person.
(It is guaranteed each person can be carried by a boat.)

Complexity for this solution:
O(n log n) time (sorting) and O(1) space

*/

import java.util.Arrays;

public class BoatsToSavePeople {

    /* Sort by weight and compare heaviest to lightest person.
    We need at least one boat for every two people,
    so always increment boats by one when comparing two persons.
    If both people fit in a boat, consider the next lightest and the next heaviest person.
    If only the heavier fits, reconsider the lighter person in the next round. */
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int i = 0;
        int j = people.length - 1;

        while (i <= j) {
            boats++;
            if (people[i] + people[j] <= limit) i++;
            j--;
        }

        return boats;
        
    }

    public static void main(String[] args) {
        int[] people = {4, 3, 5, 10, 4, 4};
        int limit = 15;
        System.out.println(numRescueBoats(people, limit));
    }
}
