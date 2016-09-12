public class Leetcode23 {
	public static void main(String[] args){
		ListNode[] lists = new ListNode[1];
		lists[0] = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		lists[0].next = p2;
		p2.next = p3;
		p3.next = null;
		
		ListNode pHead = mergeKLists_2(lists);
		System.out.println(pHead.val);
		System.out.println(pHead.next.val);
		System.out.println(pHead.next.next.val);
	}
	/**
	 * 方法一：最简单的也是最朴素的方法，每次从n个链表里面选最小的一个，加入到新链表。但是这个交到leetcode上面会超时。
	 * 
	 * 创建人:hongbin.gao
	 * @return
	 */
	public static ListNode mergeKLists_1(ListNode[] lists) {
	   int length = lists.length; //一共有几个链表。
	   int max = Integer.MAX_VALUE;
	   int index = -1;
	   ListNode pHead = null;
	   ListNode pTail = null;
	   boolean flag = false; //默认flag为false，当lists所有指针都为null，则flag为false。
	   
	   while(true){
           flag = false;		  
		   for(int i=0;i<length;i++){
			   if(lists[i] != null && !flag){
				   max = lists[i].val;
				   index = i;
				   flag = true;
			   }
			   else if(lists[i] !=null && flag && lists[i].val<max){
				   max = lists[i].val;
				   index = i;
			   }
		   }
		   if(!flag && pTail != null){ //指针全为null
			   pTail.next = null;
			   return pHead;
		   }
		   else if(!flag){
			   return null;
		   }
		   else if(flag && pTail==null){
			   pTail = lists[index];
               pHead = pTail;
			   lists[index] = lists[index].next;
		   }
		   else{
			   pTail.next = lists[index];
			   pTail = pTail.next;
			   lists[index] = lists[index].next;
		   }
	}
  }
	/**
	 * 方法二：二分法，将整个链表数组分为两部分，前后两部分，再对两部分进行整合。这个可以在leetcode上提交通过
	 * 
	 * 创建人:hongbin.gao
	 */
	public static ListNode mergeKLists_2(ListNode[] lists) {
		if(lists == null || lists.length ==0)
			return null;
		return helper(lists,0,lists.length-1);
	}
	
	public static ListNode helper(ListNode[] lists, int low, int high){
		if(lists == null)
			return null;
		if(low == high)
			return lists[low];
		if(low == high-1){
			if(lists[low] == null)
				return lists[high];
			if(lists[high] == null)
				return lists[low];
			
			ListNode pHead = null; //新生成的链表的头指针。
			ListNode pTail = null; //新生成的链表的尾指针。
			ListNode temp1 = null; //temp1为lists[low]的第一个节点。
			ListNode temp2 = null; //temp2为lists[high]的第一个节点。
			while(lists[low] != null && lists[high] != null){
				temp1 = lists[low];
				temp2 = lists[high];
				if(temp1.val<temp2.val){
					if(pHead==null){
						pTail = temp1;
						pHead = pTail;
						lists[low] = lists[low].next;
					}
					else{
						pTail.next = temp1;
						pTail = pTail.next;
						lists[low] = lists[low].next;
					}
				}
				else{
					if(pHead==null){
						pTail = temp2;
						pHead = pTail;
						lists[high] = lists[high].next;
					}
					else{
						pTail.next = temp2;
						pTail = pTail.next;
						lists[high] = lists[high].next;
					}
				}
			}
			if(lists[low] == null){
				pTail.next = lists[high];
			}
			else{
				pTail.next = lists[low];
			}
			return pHead;
		}
		else{
			int mid = (low+high)/2;
			ListNode left = helper(lists, low, mid-1);
			ListNode right = helper(lists,mid,high);
			ListNode[] last = new ListNode[2];
			last[0] = left;
			last[1] = right;
			ListNode result = helper(last,0,1);
			return result;
		}
		
	}
}
 
