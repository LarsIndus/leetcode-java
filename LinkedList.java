// Linked ist implementation with print method
public class LinkedList { 
  
    ListNode head;
  
    public static void printList(ListNode node) {
        while (node != null) { 
            System.out.print(node.value + " -> "); 
            node = node.next; 
        }
        System.out.print("NULL") ;
    } 
   
}