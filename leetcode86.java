/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
       if(head == null)  //链表为空
	    	return null;
	    
	    ListNode pHead = null; //新链表的头指针
	    ListNode pTail = null; //新链表的尾指针
	    
	    ListNode tail = head; //原链表的尾指针
	    ListNode temp; //临时节点
	    
	    //这里分两种情况，如果链表第一个节点
	    while(tail!=null){
	    	if(tail.next!=null && tail.next.val >= x)
	    		tail = tail.next;
	    	
	    	else if(tail.next!=null && tail.next.val < x){
	    		temp = tail.next;
	    		tail.next = temp.next;
	    		if(pHead == null){
	    			pHead = temp;
	    			pTail = temp;
	    		}
	    		else{
	    			pTail.next = temp;
	    			pTail = pTail.next;
	    		}
	    	}
	    	else
	    		break;
	    }
	    
	    //现在检查原链表第一个节点与x的关系
	    if(head.val < x){
	    	temp = head;
	    	head = head.next;
	    	temp.next = pHead;
	    	pHead = temp;
	    	if(pTail == null)
	    		pTail = pHead;
	    }
	    if(pTail == null)
	    	return head;
	    else{
	    	pTail.next = head;
	    	return pHead;
	    }
    }
}
