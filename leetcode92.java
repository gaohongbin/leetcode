/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
              //程序里我默认的是 m<n,所以如果m>n需要做调换
		if(n == m)  //m==n 不做操作
			return head;
		
		if(m > n){  //如果m>n 对m,n作交换
			m = m+n;
		    n = m-n;
		    m = m-n;
	    }
		
	int length = n - m; //因为m，n我都做了改变，这里用length来表示要移动多少个节点
	
	ListNode mHead = head;
	ListNode nHead = head;
	
	ListNode temp;
	if(m == 1){
		
		while(true){
			if(n>1 && nHead!=null){
				nHead = nHead.next;
				n--;
			}
			if(n==1)
				break;
		}
		
		while(length > 0){
			temp = mHead;
			mHead = mHead.next;
			temp.next = nHead.next;
			nHead.next = temp;
			length--;
		}
		return mHead;
	}
	else{
		
		while(true){
			if(m>2 && mHead!=null){
				mHead = mHead.next;
				m--;
			}
			if(n>1 && nHead!=null){
				nHead = nHead.next;
				n--;
			}
			if(n==1)
				break;
		}
		
		while(length > 0){
			temp = mHead.next;
			mHead.next = temp.next;
			temp.next = nHead.next;
			nHead.next = temp;
			length--;
		}
		return head;
	}
 }

}
