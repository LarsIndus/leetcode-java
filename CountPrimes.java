/*

Leetcode Problem 204: Count Primes (Easy)

Count the number of prime numbers less than a non-negative number, n.

Complexity for this solution:
O(n log log n) time and O(n) space

*/

public class CountPrimes {
    
    // sieve of Eratosthenes
    public static int countPrimes(int n) {
        if (n < 2) return 0;

        boolean[] notPrime = new boolean[n];
        // this initialization could be neglected, as the last loop starts at index 2 anyway!
        notPrime[0] = true;
        notPrime[1] = true;

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!notPrime[i]) {
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));
    }
}
