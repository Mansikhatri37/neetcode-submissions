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
    public boolean hasCycle(ListNode head) {
        // HashSet to store visited nodes
        HashSet<ListNode> visited = new HashSet<>();
        
        ListNode current = head;
        
        // Traverse the list
        while (current != null) {
            // Check if the current node is already visited
            if (visited.contains(current)) {
                return true; // Cycle detected
            }
            // Add the current node to the set
            visited.add(current);
            // Move to the next node
            current = current.next;
        }
        
        // No cycle found
        return false;
    }
}

