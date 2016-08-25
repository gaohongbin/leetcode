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
    public boolean hasCycle(ListNode head) {
        if(head==null)
	        	return false;
	        
	        ListNode one=head,two=head;
	        
	        while(one!=null && two!=null){
	        	one=one.next;
	        	two=two.next;
	        	if(two==null)
	        		return false;
	        	two=two.next;
	        	
	        	if(one==two)
	        		return true;
	        }
	        
	        return false;
    }
}
