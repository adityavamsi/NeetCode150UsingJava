/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * //LC - 206
 */
class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode cur = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next=cur;
            cur=head;
            head=temp;
        }
        return cur;


    }
}