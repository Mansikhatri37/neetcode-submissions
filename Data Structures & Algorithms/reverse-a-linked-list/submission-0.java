

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null; // Handle edge case: empty list

        // Step 1: Store values in an ArrayList
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) { // Traverse the list until the end
            arr.add(temp.val); // Add node value to the ArrayList
            temp = temp.next;
        }

        // Step 2: Create a new reversed linked list using values from ArrayList
        ListNode ans = new ListNode(arr.get(arr.size() - 1)); // Start with the last value
        ListNode current = ans; // Pointer to build the new list

        for (int i = arr.size() - 2; i >= 0; i--) { // Iterate backwards through the ArrayList
            current.next = new ListNode(arr.get(i)); // Create a new node with the value
            current = current.next; // Move to the next node
        }

        return ans; // Return the head of the reversed list
    }
}
