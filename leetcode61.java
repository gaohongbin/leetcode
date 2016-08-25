/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        	if(head==null)
	        	return null;
	         if(k==0)
	            return head;
	        ListNode pHead=head;
	        int length=1;
	        while(pHead.next!=null){
	        	pHead=pHead.next;
	        	length++;
	        }
	        k=k%length;
	        
	        if(k==0)
	            return head;
	        
	        int i=0;
	        ListNode temp=head;
	        while(i<(length-k)){
	           temp=temp.next;
	           i++;
	        }
	        
	        
	        ListNode p=head;
	        while(head!=temp){
	        	p=head;
	        	head=head.next;
	        	pHead.next=p;
	        	pHead=pHead.next;
	        }
	        pHead.next=null;
	        
	        return head;
    }
}
