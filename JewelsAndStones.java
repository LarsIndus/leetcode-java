/*

Leetcode Problem 771: Jewels and Stones (Easy)

You're given strings J representing the types of stones that are jewels,
and S representing the stones you have.
Each character in S is a type of stone you have.
You want to know how many of the stones you have are also jewels.
The letters in J are guaranteed distinct, and all characters in J and S are letters.
Letters are case sensitive, so "a" is considered a different type of stone from "A".

Complexity for this solution:
...

*/

import java.util.Set;
import java.util.stream.Collectors;

public class JewelsAndStones {
    public static int countJewels(String jewels, String stones) {

        int count = 0;

        // create a set of jewels by using a loop:
        /* Set<Character> jewelsSet = new HashSet<Character>();
        for (char jewel : jewels.toCharArray()) {
            jewelsSet.add(jewel);
        } */

        // create a set of jewels by using streams:
        Set<Character> jewelsSet = jewels.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
 
        for (char stone : stones.toCharArray()) {
            if (jewelsSet.contains(stone)) {
                count++;
            }
        }

        return count;
    }

    public static int countJewelsAlternative(String jewels, String stones) {
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.indexOf(stones.charAt(i)) > -1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String jewels = "aAb";
        String stones = "dgbkuaBBaA";
        System.out.println(countJewels(jewels, stones));
    }
}
