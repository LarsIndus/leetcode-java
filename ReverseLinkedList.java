/*

Leetcode Problem 206: Reverse Linekd List (Easy)

Reverse a singly linked list.

Complexity for this solution:
...

*/

public class ReverseLinkedList {
    
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public static ListNode reverseRecursively(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {

        // Reverse a linked list -----------------------------------------------------
        System.out.println("\nREVERSE A LINKED LIST --------------------");
        LinkedList list = new LinkedList();
        list.head = new ListNode(85);
        list.head.next = new ListNode(15);
        list.head.next.next = new ListNode(4);
        list.head.next.next.next = new ListNode(20);
  
        System.out.println("\nGiven Linked list:");
        LinkedList.printList(list.head);
        list.head = ReverseLinkedList.reverse(list.head);
        System.out.println("\nReversed linked list:");
        LinkedList.printList(list.head);
        System.out.println("");

        // Reverse a linked list recursively ----------------------------------------
        System.out.println("\nREVERSE A LINKED LIST RECURSIVELY --------------------");
        System.out.println("\nGiven Linked list:");
        LinkedList.printList(list.head);
        list.head = ReverseLinkedList.reverseRecursively(list.head);
        System.out.println("\nReversed linked list (recursion):");
        LinkedList.printList(list.head);
        System.out.println("");
    }
}
