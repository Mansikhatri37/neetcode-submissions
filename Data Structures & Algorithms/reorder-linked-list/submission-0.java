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
    public void reorderList(ListNode head) {
        
        //1. find the middle
        //2. split the linkedlist from middle
        //3. reverse the second linkedlist
        //4. merge the two linkedlist alternatively

        if(head == null || head.next == null) return ;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
        }

        //now my slow points to the last element of the linkedlist
        ListNode second = slow.next;
        slow.next = null; //split the linkedlist

        ListNode prev = null;
        ListNode next = null; 

        while(second != null){
            next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        //prev is the head of the reversed linkedlist

        ListNode first = head;
        second = prev;

        while(second != null){
            
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}
