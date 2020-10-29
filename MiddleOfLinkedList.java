/*

Leetcode Problem 876: Middle of the Linked List (Easy)

Given a non-empty, singly linked list with head node head,
return a middle node of the linked list.
If there are two middle nodes, return the second middle node.

Complexity for this solution:
...

*/

public class MiddleOfLinkedList {

    public static ListNode getMiddle(ListNode head) {

        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        // odd number of elements
        LinkedList list = new LinkedList();
        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        ListNode middle = getMiddle(list.head);
        System.out.println(middle.value);

        // even number of elements
        list.head.next.next.next = new ListNode(4);
        middle = getMiddle(list.head);
        System.out.println(middle.value);

    }
}
