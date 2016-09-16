/**
 * 题目：给出一个字符串，将字符串中的数字，变为可用的ip地址。
 * @author ghb
 *
 */

public class Leetcode93 {
	public static void main(String[] args){
		String s = "0101010";
		List<String> list = restoreIpAddresses(s);
		System.out.println(list);
	}
	
	/**
	 *  ip的每个段位都在0-255之间。
	 * @param s
	 * @return
	 */
	public static List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<String>();
		int pos = 0;
		int numOfPoint = 0;
		StringBuffer strBuf = new StringBuffer();
		helper(s,list, pos, numOfPoint,strBuf);
		return list;
	}
	
	/**
	 * 
	 * @param s  题目中给出的字符串s
	 * @param list 要返回的最终结果list
	 * @param pos： pos指表示到了字符串s的哪个字符
	 * @param numOfPoint ： 表示strBuf中现在加入了几个点
	 * @param strBuf ： 对应list中的String
	 * 
	 */
	
	public static void helper(String s,List<String> list, int pos, int numOfPoint,StringBuffer strBuf){
		int temp =0;
		int i = 0;
		int point =0;
		if(pos == s.length() && numOfPoint ==3){  //pos到达末尾，并且numberOfPoint ==3
			i = strBuf.length()-1;
			while(strBuf.charAt(i)!='.')
				i--;
			
			temp =0;
			i++;
			point = i;
			while(i<strBuf.length()){
				temp = temp*10 + strBuf.charAt(i)-'0';
				if(temp >255)
					return ;
				i++;
			}
			if(temp<10 && (strBuf.length()-point) !=1)  //该判断为了防止出现 .010.的情况
				return ;
			if(temp >=10 && temp <100 && (strBuf.length()-point)!=2)
				return ;
			if(temp>=100 && temp <=255 && (strBuf.length()-point)!=3)
				return ;
			
			if(temp<=255){
				list.add(strBuf.toString());
				return ;
			}
			else
				return ;
		}
		else if(pos == s.length() && numOfPoint <3)
			return ;
		else if(pos == 0){
			strBuf.append(s.charAt(pos));
			helper(s,list,pos+1,numOfPoint,strBuf);
		}
		else{
			if(strBuf.charAt(strBuf.length()-1) == '.'){
				if(numOfPoint==3 && s.length() - pos>3) //超过三位则返回
					return ;
				strBuf.append(s.charAt(pos));
			    helper(s,list,pos+1,numOfPoint,strBuf);
			    strBuf.setLength(strBuf.length()-1);
			}
			else if(strBuf.charAt(strBuf.length()-1) != '.'){
				if(numOfPoint <3){
					i = strBuf.length()-1;
					while(i>=0 && strBuf.charAt(i)!='.')
						i--;
					
					temp =0;
					i++;
					point = i;
					while(i<strBuf.length()){
						temp = temp*10 + strBuf.charAt(i)-'0';
						if(temp >255)
							return ;
						i++;
					}
					if(temp<10 && (strBuf.length()-point) !=1)
						return ;
					if(temp >=10 && temp <100 && (strBuf.length()-point)!=2)
						return ;
					if(temp>=100 && temp <=255 && (strBuf.length()-point)!=3)
						return ;
					
					if(temp<=255){
						strBuf.append('.');
						numOfPoint ++;
						helper(s,list,pos,numOfPoint,strBuf);
						numOfPoint--;
						strBuf.setLength(strBuf.length()-1);
						
						strBuf.append(s.charAt(pos));
						helper(s,list,pos+1,numOfPoint,strBuf);
						strBuf.setLength(strBuf.length()-1);
					}
					else
						return ;
				}
				if(numOfPoint ==3){
					if(s.length() - pos>3) //超过三位则返回
						return ;
					strBuf.append(s.charAt(pos));
					helper(s,list,pos+1,numOfPoint,strBuf);
					strBuf.setLength(strBuf.length()-1);
				}
			}
		}
	}
}

