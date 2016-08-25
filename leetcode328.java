/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
         if(head==null || head.next==null) //如果链表为空或者长度为1时，直接返回
        	return head;
        
        ListNode headEven;  //偶数位节点的头指针
        ListNode tailHead=head;  //原链表的操作指针
        ListNode tailEven;  //偶数位链表的操作指针
        
        headEven=new ListNode(0);
        headEven.next=null;
        tailEven=headEven;
        
        while(tailHead!=null && tailHead.next!=null){
        	tailEven.next=tailHead.next; //将偶数位的节点用tailEven来指向
        	tailHead.next=tailHead.next.next;
        	tailEven=tailEven.next;
        	if(tailHead.next==null)
        		break;
        	tailHead=tailHead.next;
        }
        tailEven.next=null;
        tailHead.next=headEven.next;
       return head; 
    }
}
