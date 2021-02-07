/*

Leetcode Problem 1108: Defanging an IP Address (Easy)

Given a valid (IPv4) IP address, return a defanged version of that IP address.
A defanged IP address replaces every period "." with "[.]".

Complexity for this solution:
O(n) time and space (or O(1) if the length of an IP address is bounded)

*/

public class DefangingAnIPAddress {

    public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();

        for (char c : address.toCharArray()) {
            if (c == '.') {
                sb.append("[.]");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String address = "255.100.50.0";
        System.out.println(defangIPaddr(address));
    }
}