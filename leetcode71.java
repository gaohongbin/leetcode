public class Solution {
    public String simplifyPath(String path) {
       if(path == null || path.length() == 0)
			 return "";
		 
		 Deque<String> linkedList = new LinkedList<String>();
		 StringBuffer strBuf = new StringBuffer();  //strBuf用来找出每一个目录
		 
		 for(int i =0;i<path.length();i++){
			 if(path.charAt(i)=='/' && strBuf.toString().equals("."))  //当前目录
				 strBuf.setLength(0);  //清空strBuf
			 else if(path.charAt(i)=='/' && strBuf.toString().equals("..")){ //上一层目录
				 if(!linkedList.isEmpty())
					 linkedList.removeLast();
				 strBuf.setLength(0);
			 }
			 else if(path.charAt(i) == '/' && strBuf.length()!=0){
				 linkedList.addLast(strBuf.toString());
				 strBuf.setLength(0);
			 }
			 else if(path.charAt(i)!='/')
				 strBuf.append(path.charAt(i));
		 }
		 
		 if(strBuf.toString().equals("..") && !linkedList.isEmpty()){
			 linkedList.removeLast();
		 }
		 else if(!strBuf.toString().equals(".") && !strBuf.toString().equals("..") && strBuf.length()!=0)
			 linkedList.addLast(strBuf.toString());
		 
		 strBuf.setLength(0);
		 while(!linkedList.isEmpty()){
			 strBuf.append('/');
			 strBuf.append(linkedList.removeFirst());
		 }
		 if(strBuf.length()==0)
			 return "/";
		 return strBuf.toString();
    }
}
