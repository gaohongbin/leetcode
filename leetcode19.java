/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
         if(head==null)
	        	return null;
	        ListNode pHead=head,pTail=null;
	        int len=0;
	        while(len<n && pHead.next!=null){
	        	pHead=pHead.next;
	        	len++;
	        }
	        if(len<n){
	        	head=head.next;
	        	return head;
	        }
	        
	        pTail=head;
	        while(pHead.next!=null){
	        	pHead=pHead.next;
	        	pTail=pTail.next;
	        }
	        
	        if(n==1)
	        	pTail.next=null;
	        else
	        	pTail.next=pTail.next.next;
	        return head;
	        	
    }
}
