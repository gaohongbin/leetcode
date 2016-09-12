/**
 * 题目：给一个链表，为: L0→L1→…→Ln-1→Ln,
 * 实现程序将其转换成： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * @author: hongbin.gao
 *
 */
public class Leetcode143 {
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(4);
		ListNode p5 = new ListNode(5);
		
		head.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = null;
		
		reorderList(head);
	    while(head != null){
	    	System.out.println(head.val);
	    	head = head.next;
	    }

	    	
	}
	
	/**
	 * 思路： 第一遍遍历链表，算出链表的长度，将链表分为两半，前半部分和后半部分，将后半部分逆序翻转，然后将两个链表合并。
	 * 
	 * 创建人:hongbin.gao
	 */
	public static void reorderList(ListNode head) {
		if(head == null || head.next == null)
			return ;
		
		int length = 0;
		ListNode pHead = head;
		while(pHead != null){  //算一下一共多少个节点。
			length++;  
			pHead = pHead.next;
		}
		
		int halfList = length - length/2;  //计算前半段的长度，因为如果length为奇数，前半段要比后半段多1，所以用减法
		pHead = head;
		
		ListNode temp = null;
		
		while(halfList>1){  //pHead指向链表的后半段
			pHead = pHead.next;
			halfList--;
		}
		temp = pHead;    //将前半段的末尾指针变为null。
		pHead = pHead.next;
		temp.next = null; 
		
		ListNode pHead1 = head; //pHead1指向链表的前半段,pHead指向链表的后半段。
		pHead = reorder(pHead);
		while(pHead != null && pHead1 != null){
			temp = pHead;
			pHead = pHead.next;
			
			temp.next = pHead1.next;
			pHead1.next = temp;
			pHead1 = pHead1.next.next;
		}
    }
	/**
	 * recorder(ListNode head) :逆序翻转链表 。 
	 */
	public static ListNode reorder(ListNode head) {  //链表逆序
		if(head == null || head.next == null)
			return head;
		
		ListNode pHead = head;
		ListNode temp = null;
		head = head.next;
		pHead.next = null;
		while(head!=null){
			temp = head;
			head = head.next;
			temp.next = pHead;
			pHead = temp;
		}
		return pHead;
	}
}
