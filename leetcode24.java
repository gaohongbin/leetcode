/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
         if(head==null)
	        	return null;
	        if(head.next==null)
	        	return head;
	        
	        ListNode p=head,q=head.next;
	        
	        ListNode pHead=null,pTail=pHead;
	        
	        p.next=q.next;
	        q.next=null;
	        pHead=q;
	        pTail=q;
	        head=head.next;
	        p.next=null;
	        pTail.next=p;
	        pTail=pTail.next;
	        
	        while(head!=null){
	        	if(head.next!=null){
	        		p=head;
		        	q=p.next;
		        	p.next=q.next;
		        	q.next=null;
		        	pTail.next=q;
		        	pTail=pTail.next;
		        	head=head.next;
		        	p.next=null;
		        	pTail.next=p;
		        	pTail=pTail.next;
	        	}
	        	else{
	        		pTail.next=head;
	        		break;
	        	}
	        }
	        return pHead;
    }
}
