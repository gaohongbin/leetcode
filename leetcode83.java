/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
			 return head;
		 
	        ListNode p=head,q=head.next;
	        while(q!=null){
	        	if(p.val!=q.val){
	        		p=p.next;
	        		q=q.next;
	        		continue;
	        	}
	        	q=q.next;
	        	p.next=q;
	        }
	        return head;
    }
}
