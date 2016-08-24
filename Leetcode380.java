import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Leetcode380 {
	public static void main(String[] args){
		RandomizedSet obj = new RandomizedSet();
		System.out.println(obj.insert(2));
	}
}

/**
 * 题目：设计一类，可以在O(1)完成插入，删除，和随机返回一个值。
 * @author ghb
 *
 * 思路：用一个ArrayList和HashMap来实现。因为要在O(1)完成插入，这个可以用链表来完成。但是要完成O(1)完成删除，这个链表
 * 和数组都完成不了。所以用hash表来完成比较合适。但是要在O(1)随机返回一个已包含的值，hash表却不能完成，所以用hash表和ArrayList结合来完成。
 * 我们在hashMap<Integer,Integer> key为要插入的数字，value为对应的在ArrayList的下标。
 * 插入的数字直接放在ArrayList的末尾插入就可以。
 * 
 * 当要删除一个数时，先从hashMap中判断是否存在这个key，再从hashMap 中删除，然后得到ArrayList的响应下标，将ArrayList最后的数放在该位置。
 * 随机返回就从ArrayList中随机返回就可以。
 */

class RandomizedSet {
	   public Map<Integer,Integer> map; 
		public List<Integer> list;
		public int length = 0;  

	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	    	map = new HashMap<Integer,Integer>();
	    	list = new ArrayList<Integer>();
	    	length = 0;
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if(map.containsKey(val)) //如果存在
	        	return false;
	        
	        map.put(val, length);
	        list.add(val);
	        length++;
	        return true;
	        
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	    	if(!map.containsKey(val))
	    		return false;
	    	
	    	int index = map.remove(val);
	    	
	    	if(index!=length-1){
	    	 map.put(list.get(length-1), index); //删除之后，list要换，就要把这个补上
	    	 list.set(index, list.get(length-1));
	    	}
	    	list.remove(length-1);
	    	length--;
	    	return true;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        int index = (int) (Math.random()*(length));
	        return list.get(index);
	    }
	}
