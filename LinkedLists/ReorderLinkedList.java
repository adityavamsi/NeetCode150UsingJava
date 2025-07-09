class Question{
    /*
    You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.



Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]


Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
    */
}




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
    public ListNode reverse(ListNode root){

        ListNode temp = root;
        ListNode first = null;

        while(temp!=null){
            ListNode t = temp.next;
            temp.next = first;
            first = temp;
            temp=t;
        }
        return first;
    }
    public void reorderList(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode head1 = head;
        ListNode head2 = reverse(slow);

        while(head2.next!=null){
            ListNode temp1  = head1.next;
            ListNode temp2 = head2.next;
            head1.next = head2;
            head2.next=temp1;
            head1=temp1;
            head2=temp2;
        }

    }
}