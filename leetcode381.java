/**
* 思路：leetcode380不包含重复元素，使用的是Map<Integer,Integer>来实现，现在包含了重复元素，使用Map<Integer,String>来实现，如果有重复的元素出现，
× 则其直接把他的位置接在String后面，这样就能保证重复元素的出现，remove时，再进行修改。
*
*
*/


public class RandomizedCollection {

  Map<Integer,String> map = new HashMap<Integer,String>();
	List<Integer> list = new ArrayList<Integer>();
	int length = 0;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
    	map.clear();
    	list.clear();
    	length = 0;
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
    	if(map.containsKey(val)){
    		String str = map.get(val);
    		map.put(val, str+","+length);
    	}
    	else if(!map.containsKey(val)){
    		map.put(val, length+"");
    	}
    	list.add(length,val);
		length++;
		return true;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
    	if(!map.containsKey(val))  //如果不包含val，直接返回false
    		return false;
    	String str = map.get(val);  
    	int index = str.lastIndexOf(",");
    	int indexOfVal = 0;
    	if(index == -1){  //如果数组中只含有一个val
    		indexOfVal = Integer.parseInt(str); //得到在数组中的位置
    		map.remove(val);
    	}
    	else{  //如果数组中包含多个val
    		indexOfVal = Integer.parseInt(str.substring(index+1));
    		map.put(val, str.substring(0, index)); //修改map
    	}
    	
    	if(indexOfVal == length-1){
			list.remove(indexOfVal);
    	}
		else{
			int moveVal = list.get(length-1);
			list.set(indexOfVal, moveVal);
			list.remove(length-1);
			str = map.get(moveVal);
			//接下来要寻找str中的length-1，将length-1替换为indexOfVal。
			if(str.indexOf(",") == -1) //如果只有一个moveVal
				map.put(moveVal, indexOfVal+"");
			else if(str.substring(0, str.indexOf(",")).equals(length-1+"")) //如果字符串中第一个位置就是length-1
				map.put(moveVal, str.substring(str.indexOf(",")+1)+","+indexOfVal);
			else if(str.substring(str.lastIndexOf(",")+1).equals(length-1+"")) //如果字符串的最后一个位置存的是length-1
				map.put(moveVal, str.substring(0, str.lastIndexOf(",")+1)+indexOfVal);
			else
				map.put(moveVal, str.replace(","+(length-1)+",", ","+indexOfVal+","));
		}
		length --; 
		return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
    	int index = (int)(Math.random()*length);
    	return list.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
