/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode convertArrToLinkedList(ArrayList<Integer> arr) {
        // Create a dummy node to serve as the head of the linked list
        ListNode dummyNode = new ListNode(-1, null);
        ListNode temp = dummyNode;

        // Iterate through the ArrayList and create nodes with elements
        for (int i = 0; i < arr.size(); i++) {
            // Create a new node with the ArrayList element
            temp.next = new ListNode(arr.get(i), null);
            // Move the temporary pointer to the newly created node
            temp = temp.next;
        }

        // Return the linked list starting from the next of the dummy node
        return dummyNode.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
         // Create an ArrayList to store node values
        ArrayList<Integer> arr = new ArrayList<>();

        // Iterate through the listArray containing all linked lists
        for (int i = 0; i < lists.length; i++) {
            // Initialize a temporary pointer to the head of the current linked list
            ListNode temp = lists[i];

            // Traverse through the current linked list
            while (temp != null) {
                // Store the data of each node in the ArrayList
                arr.add(temp.val);

                // Move to the next node in the linked list
                temp = temp.next;
            }
        }

        // Sort the ArrayList containing node values in ascending order
        Collections.sort(arr);

        // Convert the sorted ArrayList back to a linked list and return its head
        return convertArrToLinkedList(arr);
    }
}

