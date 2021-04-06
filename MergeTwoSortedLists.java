/*

Leetcode Problem 21: Merge Two Sorted Lists (Easy)

Merge two sorted linked lists and return it as a new sorted list.
The new list should be made by splicing together the nodes of the first two lists.

Complexity for this solution:
...

*/

public class MergeTwoSortedLists {
    
    public static ListNode merge(ListNode head1, ListNode head2) {

        // create a dummy node to start with and point current node to it
        ListNode temp = new ListNode(-1);
        ListNode curr = temp;

        while (head1 != null && head2 != null) {
            
            if (head1.value < head2.value) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }

            // make sure to update current to not overwrite it in the next iteration
            curr = curr.next;

        }

        // if one list reached null, direct pointer to the other list
        if (head1 != null) {
            curr.next = head1;
        } else if (head2 != null) {
            curr.next = head2;
        }

        // we don't want the dummy node, so return the next
        return temp.next;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();

        l1.head = new ListNode(1);
        l1.head.next = new ListNode(2);
        l1.head.next.next = new ListNode(4);
        l1.head.next.next.next = new ListNode(5);

        l2.head = new ListNode(1);
        l2.head.next = new ListNode(3);
        l2.head.next.next = new ListNode(4);

        ListNode merged = merge(l1.head, l2.head);
        LinkedList.printList(merged);
    }

}
