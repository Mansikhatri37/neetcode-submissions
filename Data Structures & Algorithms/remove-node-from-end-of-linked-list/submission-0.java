class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Calculate the size of the linked list
        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // Step 2: Find the node just before the one to remove
        temp = head;
        int toGo = size - n;

        // If toGo is 0, that means we need to remove the head node
        if (toGo == 0) {
            return head.next; // Remove the head
        }

        // Traverse to the node just before the one to remove
        for (int i = 0; i < toGo - 1; i++) {
            temp = temp.next;
        }

        // Remove the nth node from the end
        temp.next = temp.next.next;

        return head; // Return the modified list
    }
}
