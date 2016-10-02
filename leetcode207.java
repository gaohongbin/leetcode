/**
 * 题目:判断课程是否合理，参数numCourses表示有多少课程，prerequisites是一个二位数组，两列数组，表示学习第二列的课程前必须先学习第一列的课程。
 * 思路:一个numCourses的链表数组，该链表中的值表示学习i课程前需学习哪些课程。
 * @author ghb
 *
 */

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       if(prerequisites == null || prerequisites.length ==0)
			return true;
		
		int length = prerequisites.length;
		ListNode[] courses = new ListNode[numCourses];
		boolean[] result = new boolean[1];
		result[0] = false;
		
		for(int i=0;i<numCourses;i++)
			courses[i] = null;
		for(int i=0;i<length;i++){
			int first = prerequisites[i][0];
			int second = prerequisites[i][1];
			
			ListNode pNode = courses[first];
			check(pNode,courses,second,result);
			if(result[0])
				return false;
			
			pNode = courses[second];
			ListNode node = new ListNode(first);
			node.next = null;
			if(pNode == null){
				courses[second] = node;
				continue;
			}
			while(pNode.next != null){
				pNode = pNode.next;
			}
			pNode.next = node;
		}
        return true;
    }
    
    public static void check(ListNode pNode, ListNode[] courses, int target,boolean[] result){
		if(pNode == null || result[0])
			return ;
		while(pNode != null){
			if(pNode.val == target){
				result[0] = true;
				return ;
			}
			check(courses[pNode.val],courses,target,result);
			pNode = pNode.next;
		}
		return ;
	}
}
