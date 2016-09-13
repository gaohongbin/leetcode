/**
 * 题目： 复制复杂链表，复杂链表的结构为RandomListNode，其中next指向链表的下一个节点，random指向链表中的随便一个节点。
 * 复制给出的复杂链表，并返回头指针。
 *
 * 思路：先根据原链表，复制一个新的链表，但该新链表中的random空着，只操作next指针。然后将新链表插入原链表之中。 旧-新-旧-新。。。
 * 这样，新链表的节点就挂在了原链表相应节点的后面，再从头遍历一遍该链表，新节点的random就是前一个结点的random.next.
 * 将新节点的random修改完成后，我们将新节点从来链表中摘取出来。
 * 
 * 该程序没有main函数，因为一遍写完交上去就通过了，就懒得添加main函数了。 :)
 * @author: hongbin.gao
 *
 */
 class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 };

public class Leetcode138 {
	public static void main(String[] args){
		
	}
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null)
			return null;
		
		RandomListNode head1 = head;  //新指针指向链表的头
		RandomListNode pHead = null,pTail = null;  //新建一个链表。
		while(head1 != null){
			RandomListNode node = new RandomListNode(head1.label);
			if(pHead == null){
				pHead = node;
				pTail = pHead;
			}
			else{
				pTail.next = node;
				pTail = pTail.next;
			}
			head1 = head1.next;
		}
		pTail.next = null;   //新建一个链表
		
		//现在将新建链表插入到原链表里面，并将新链表的random指针填充完成
		head1 = head;
		while(head1!=null){
			pTail = pHead;
			pHead = pHead.next;
			pTail.next = head1.next;
			head1.next = pTail;
			head1 = head1.next.next;
		}
		
		
		head1 = head;
		while(head1 != null){
			if(head1.random !=null)
			   head1.next.random = head1.random.next;
			else
				head1.next.random = null;
			head1 = head1.next.next;
		}
		
		//将新链表从原链表里面摘取出来
		head1 = head;
		pHead = head1.next;
		pTail = pHead;
		while(pTail.next != null){
			head1.next = pTail.next;
			pTail.next = pTail.next.next;
			head1 = head1.next;
			pTail = pTail.next;
		}
		head1.next = null;
		
		return pHead;
    }

}
