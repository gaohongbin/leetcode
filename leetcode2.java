/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         	  if(l1==null)  //l1或者l2为null
	        	return l2;
	        if(l2==null)
	        	return l1;
	        
	        
	        int carry=0;
	        ListNode add=null;
	        ListNode tail=add;
	        while(l1!=null && l2!=null){
	        	
	        	ListNode p=new ListNode((l1.val+l2.val+carry)%10);
	        	p.next=null;
	        	if (add==null) {
	        		add=p;
	        		tail=p;
				}
	        	else{
	        		tail.next=p;
	        		tail=tail.next;
	        	}
	        	
	        	carry=(l1.val+l2.val+carry)/10;
	        	
	        	l1=l1.next;
	        	l2=l2.next;
	        }
	        
	        if(l2!=null)
	        	l1=l2;
	        
	        while(l1!=null){
	        	ListNode p=new ListNode((l1.val+carry)%10);
	        	p.next=null;
	        	tail.next=p;
	        	tail=tail.next;
	        	
	        	carry=(l1.val+carry)/10;
	        	
	        	l1=l1.next;
	        }
	        
	        if(carry!=0){
	        	ListNode p=new ListNode(carry);
	        	p.next=null;
	        	tail.next=p;
	        	
	        }
	        	
	        return add;
    }
}
