/*

Leetcode Problem 50: Pow(x, n) (Medium)

Implement pow(x, n), which calculates x raised to the power n (i.e. x^n).

Complexity for this solution:
O(log n) time and space (space because of recursion --> call stack)

*/

public class Pow {
    
    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) return myPow(1 / x, -n);
        double temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * x;
        }
    }

    public static void main(String[] args) {
        double[] base = {2.0, 2.1, 2, -3};
        int[] exp = {-2, 3, 10, 0};

        for (int i = 0; i < base.length; i++) {
            double x = base[i];
            int n = exp[i];
            System.out.println(x + "^" + n + " = " + myPow(x,n));
        }
        
    }
}
