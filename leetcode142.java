/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
         if(head==null)
	        	return null;
	        
	        ListNode one=head,two=head;
	        while(one!=null && two!=null){
	        	one=one.next;
	        	two=two.next;
	        	if(two==null)
	        		return null;
	        	two=two.next;
	        	
	        	if(one==two)
	        		break;
	        }
	        
	        if(one==null || two==null)
	        	return null;
	        one=head;
	        while(one!=two){
	        	one=one.next;
	        	two=two.next;
	        }
	        
	        return one;
    }
}
