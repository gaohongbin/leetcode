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
        if(head == null)
			 return null;
		 if(head.next == null)
			 return head;
		 
	        int second = head.next.val; //保存第二个节点的值，因为第一个节点的值和第二个节点的值一样的时候，是一种特殊情况，
	                                  //我们在这里将它转化成不一样的来处理，所有都处理完成后，再对第一个节点进行处理
	        int temp;
	        
	        ListNode pHead,pTail;
	        ListNode p;
	        
	        pHead = pTail = head;
	        head = head.next;
	        pTail.next = null;
	        
	        while(head != null){
	        	if(head.next!=null && head.val == head.next.val){
	        		temp = head.val;
	        		while(head!=null && head.val == temp)
	        			head = head.next;
	        	}
	        	else if(head.next ==null || head.val != head.next.val){
	        		p = head;
	        		head=head.next;
	        		pTail.next = p;
	        		pTail = pTail.next;
	        		pTail.next = null;
	        	}
	        }
	        while(pHead!=null && pHead.val == second){
	        	pHead = pHead.next;
	        }
	        return pHead;
    }
}
