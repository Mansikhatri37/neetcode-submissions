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
    public static ListNode reverseLinkedList(ListNode head){
        ListNode prev =null;
        ListNode after = null;
        ListNode curr = head;
        while(curr!=null){
            after=curr.next;
            curr.next=prev;
            prev=curr;
            curr=after;
        }
        return prev;
    }
    public static ListNode getKthNode(ListNode temp, int k){
        //decrement k as we already start from first node
        k = k-1;

        //decrement k 
        //until it reaches the correct position
        while(temp!=null && k>0){
            k--;
            temp= temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;
        while(temp!=null){
            ListNode kthNode = getKthNode(temp,k);
            
            // If the Kth node is NULL
            // (not a complete group)
            if(kthNode ==null){
                // If there was a previous group,
                // link the last node to the current node
                if(prevLast!=null){
                    prevLast.next=temp;
                }
                break; // Exit the loop
            }
            
             // Store the next node
            // after the Kth node
             ListNode nextNode = kthNode.next;
             
             // Disconnect the Kth node
            // to prepare for reversal
            kthNode.next=null;

             // Reverse the nodes from
            // temp to the Kth node
            reverseLinkedList(temp);

            
             // Adjust the head if the reversal
            // starts from the head
            if(temp==head){
                head=kthNode;
            }
            else{
                // Link the last node of the previous
                // group to the reversed group
                prevLast.next=kthNode;
            }
            // Update the pointer to the
            // last node of the previous group
            prevLast = temp;
            
            // Move to the next group
            temp = nextNode;
        }
        return head;
    }
}