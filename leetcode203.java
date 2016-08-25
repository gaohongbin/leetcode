/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
			return head;
		
		ListNode p=new ListNode(0);
		p.next=head;
		ListNode q=p;
		while(q.next!=null){
			if(q.next.val==val)
				q.next=q.next.next;
			else
				q=q.next;
		}
		return p.next;
    }
}
