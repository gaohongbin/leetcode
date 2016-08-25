/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
                if(head==null || head.next==null)
        return true;
        
       int length=0;
       ListNode p=head;
       while(p!=null){
    	   length++;
    	   p=p.next;
       }
       
       p=head;
       for(int i=0;i<length/2;i++){
    	   p=p.next;
       }
       
       ListNode head2=null,temp=p;
       while(p!=null){
    	   p=p.next;
    	   temp.next=head2;
    	   head2=temp;
           temp=p;
       }
       
       for(int i=0;i<length/2;i++){
    	   if(head.val!=head2.val)
    		   return false;
    	   head=head.next;
    	   head2=head2.next;
       }
       return true;
        
        
        
    }
}
