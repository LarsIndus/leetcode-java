/*

Leetcode Problem 328: Odd Even Linked List (Medium)

Given a singly linked list, group all odd nodes together followed by the even nodes.
Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place.
The program should run in O(1) space complexity and O(nodes) time complexity.

Complexity for this solution:
O(n)  time and O(1) space

*/

public class OddEvenLinkedList {
    public static ListNode oddevenList(ListNode head) {
        
        if (head == null) {
            return head;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode firstEven = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }

        odd.next = firstEven;

        return head;

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(4);
        list.head.next.next.next.next = new ListNode(5);
        list.head.next.next.next.next.next = new ListNode(6);
        LinkedList.printList(list.head);
        list.head = OddEvenLinkedList.oddevenList(list.head);
        System.out.println("");
        LinkedList.printList(list.head);
    }
}
