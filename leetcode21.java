/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         if(l1==null)
	        	return l2;
	        if(l2==null)
	        	return l1;
	        
	        ListNode head1=l1,head2=l2;
	        ListNode head3=null,temp=null;
	        
	        while(l1!=null && l2!=null){
	        	if(head1.val<head2.val){
	        		l1=l1.next;
	        		if(head3==null){
	        			head1.next=null;
	        			head3=head1;
	        			temp=head1;
	        		}
	        		else{
	        			head1.next=null;
	        			temp.next=head1;
	        			temp=temp.next;
	        		}
	        		head1=l1;
	        	}
	        	else{
	        		l2=l2.next;
	        		if(head3==null){
	        			head2.next=null;
	        			head3=head2;
	        			temp=head2;
	        		}
	        		else{
	        			head2.next=null;
	        			temp.next=head2;
	        			temp=temp.next;
	        		}
	        		head2=l2;
	        	}
	        }
	        
	        if(l1==null){
	        	l1=l2;
	        	head1=l2;
	        }
	        	
	        
	        while(l1!=null){
	        	l1=l1.next;
	        	head1.next=null;
	        	temp.next=head1;
	        	temp=temp.next;
	        	head1=l1;
	        }
	        return head3;
	        	
    }
}
