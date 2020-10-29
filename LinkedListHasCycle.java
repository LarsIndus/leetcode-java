/*

Leetcode Problem 141: Linked List Cycle (Easy)

Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list
that can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.

Complexity for this solution:
...

*/

public class LinkedListHasCycle {

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        
        // check for a cycle ---------------------------------------------------------
        System.out.println("\nCHECK FOR A CYCLE --------------------");
        LinkedList listCycle = new LinkedList();
        listCycle.head = new ListNode(1);
        listCycle.head.next = new ListNode(2);
        listCycle.head.next.next = new ListNode(3);
        listCycle.head.next.next.next = new ListNode(4);
        listCycle.head.next.next.next.next = listCycle.head.next;
        System.out.println("\nHas cycle: " + LinkedListHasCycle.hasCycle(listCycle.head));

        LinkedList listNoCycle = new LinkedList();
        listNoCycle.head = new ListNode(1);
        listNoCycle.head.next = new ListNode(2);
        listNoCycle.head.next.next = new ListNode(3);
        listNoCycle.head.next.next.next = new ListNode(4);
        System.out.println("\nHas cycle: " + LinkedListHasCycle.hasCycle(listNoCycle.head));
    }
}
