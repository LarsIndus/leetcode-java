/*

Leetcode Problem 234: Palindrome Linked List (Easy)

Given a singly linked list, determine if it is a palindrome.

Complexity for this solution:
...

*/

public class LinkedListPalindrome {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    // Solution 1 (my solution): O(n) time and space
    public static Boolean isPalindrome(ListNode head) {

        // reverse the whole list 
        ListNode tail = reverseList(head);
        while (head != null) {
            if (head.value != tail.value) return false;
            head = head.next;
            tail = tail.next;
        }

        return true;

    }

    // Solution 2: O(n) time and O(n/2) space
    public static Boolean isPalindromeAlternative(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // find the middle of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half of the list
        slow = reverseList(slow);
        fast = head;

        while (slow != null) {
            if (slow.value != fast.value) return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(2);
        list.head.next.next.next.next = new ListNode(1);
        
        System.out.println(isPalindrome(list.head));
    }
}
