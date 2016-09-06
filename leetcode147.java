
public class Leetcode147 {
	public static void main(String[] args){
		ListNode head = new ListNode(5);
		head.next = new ListNode(3);
		head.next.next = new ListNode(7);
		head.next.next.next = new ListNode(9);
		
		ListNode p = insertionSortList(head);
		while(p!= null){
			System.out.println(p.val);
			p = p.next;
		}
		
	}
	
	public static ListNode insertionSortList(ListNode head) {
		if(head == null)
			return null;
		
        ListNode result = head;
        head = head.next;
        result.next = null;
        
        ListNode temp; //从head链表上取下来一个节点。
        ListNode p;  //p用来在result链表中找到合适的位置，将temp插进去
        while(head != null){
        	temp = head;
        	head = head.next;
        	temp.next = null;
        	
        	if(temp.val<result.val){
        		temp.next = result;
        		result = temp;
        	}
        	else{
        		p = result;
        		
        		while(p.next != null && temp.val>p.next.val){
        			p = p.next;
        		}
        		
        		temp.next = p.next;
        		p.next = temp;
        	}
        }
        return result;
    }

}

