/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
         if(head==null)
	    	 return null;
	     
	     ListNode head2=null,temp=head;
	     while(head!=null){
	         temp=head;
	    	 head=head.next;
	    	 temp.next=head2;
	    	 head2=temp;
	     }
	     return head2;
    }
}
