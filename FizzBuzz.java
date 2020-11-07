/*

Leetcode Problem 412: Fizz Buzz (Easy)

Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number
and for the multiples of five output “Buzz”.
For numbers which are multiples of both three and five output “FizzBuzz”.

Complexity for this solution:
O(n) time and space

*/

import java.util.List;
import java.util.ArrayList;

public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        if (n < 1) return result;

        for (int i = 1; i <= n; i++) {
            if(i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
                //result.add(Integer.toString(i)); // alternative
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 15;
        List<String> fizzBuzz = fizzBuzz(n);
        for (String s : fizzBuzz) {
            System.out.println(s);
        }
    }
}
