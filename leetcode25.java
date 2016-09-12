/**
 * 题目：两个参数，一个链表指针head，一个整数k，将每k个节点翻转一下。
 * 例如: 链表为: 1->2->3->4->5
 *
 *  k = 2, 应该返回的是: 2->1->4->3->5
 *
 *  k = 3, 应该返回的是: 3->2->1->4->5
 *  
 *  如果剩下的节点个数不够k个，则不做调整，就按原位置剩在那里即可。
 *  
 *  @author: hongbin.gao
 *
 */
public class Leetcode25 {
	public static void main(String[] args){
		ListNode head  = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(4);
		ListNode p5 = new ListNode(5);
		head.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = null;
		
		int k = 3;
		ListNode pHead = reverseKGroup(head, k);
		while(pHead != null){
			System.out.println(pHead.val);
			pHead = pHead.next;
		}
	}
	
	/**
	 * 思路： 用一个新的指针pHead来来指向新的生成的链表。head用来指向原来链表的头指针。tail用来指向每k个节点的最后一个节点，tail如果不为null，只需将
	 * head和tail之间的几点逆序放在pHead链表的尾部即可。 如果head和tail之间的节点个数不够k个，将head指向的链表，直接加在pHead尾部即可，不用翻转。
	 * 
	 * 一共用到四个指针，一个head为原链表的头指针，tail和head之间有k个节点，用来翻转。
	 * pHead为新链表的头指针。 pTail为新链表的尾指针。从原链表过来的指针直接加在pTail后面。
	 * temp为从原链表到新链表之间转换的指针。
	 * 
	 * 
	 * 创建人:hongbin.gao
	 * @return
	 */
	public static ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || k ==1)  //考虑边界情况。
			return head;
		
	    //四个新建的指针。
		ListNode pHead = null, pTail = null, tail = head, temp = null;
		
		int count = k;
		boolean flag = false;
		while(true){
			while(count >0 && tail != null){
				tail = tail.next;
				count--;
				if(count ==0)  //如果flag == true表示可以凑够一个k循环。
					flag = true;
			}
			if(!flag){  //如果不够k个节点，直接将原来的链表加在新链表末尾即可
				if(pTail == null)
					return head;
				pTail.next = head;
				break;
			}
			
			if(count == 0 && pTail == null){  //当开始pTail和pHead为null，这个需要特殊处理
				temp = head;
				head = head.next;
				pTail = pHead = temp;
				pTail.next = null;  //尾节点的next指针为null
			}
				
			while(head!=tail){
				temp = head;
				head = head.next;
				temp.next = pTail;
				if(pTail == pHead){ //第一个k个节点在循环时，因为往pHead的头结点插入节点，导致pHead不能指向新链表头，所以需要变换pHead指针。
					pHead = temp;
				    pTail = temp;
				}
				else{
					temp.next = pTail.next;
					pTail.next = temp;
				}

			}
					
			while(pTail.next != null){
				pTail = pTail.next;
			}
			count = k; 
			flag = false;
		}
		return pHead;
	}
	

}
