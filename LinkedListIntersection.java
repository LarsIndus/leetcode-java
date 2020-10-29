/*

Leetcode Problem 160: Intersection of Two Linked Lists (Easy)

Write a program to find the node at which the intersection of two singly linked lists begins.

Complexity for this solution:
...

*/

public class LinkedListIntersection {
    
    public static ListNode getIntersection(ListNode headA, ListNode headB) {
        
        if (headA == null || headB == null) return null;
        
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB) {

            if (pointerA == null) {
                pointerA = headB;
            } else {
                pointerA = pointerA.next;
            }

            if (pointerB == null) {
                pointerB = headA;
            } else {
                pointerB = pointerB.next;
            }

        }

        return pointerA;
    }

    public static void main(String[] args) {

        // Get the intersection node of two linked lists ----------------------------------------
        System.out.println("\nGET THE INTERSECTION OF TWO LINKED LISTS --------------------");
        LinkedList listA = new LinkedList();
        listA.head = new ListNode(1);
        listA.head.next = new ListNode(2);
        listA.head.next.next = new ListNode(3);
        listA.head.next.next.next = new ListNode(4);
        listA.head.next.next.next.next = new ListNode(5);
        LinkedList listB = new LinkedList();
        listB.head = new ListNode(11);
        listB.head.next = new ListNode (12);
        listB.head.next.next = new ListNode (13);
        listB.head.next.next.next = new ListNode(14);
        listB.head.next.next.next.next = listA.head.next.next.next;

        ListNode intersectionNode = LinkedListIntersection.getIntersection(listA.head, listB.head);
        System.out.println("");
        System.out.println(intersectionNode.value);
    }

}
