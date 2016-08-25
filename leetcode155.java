class MinStack {
    Stack<Integer> stack1=new Stack<Integer>();
    Stack<Integer> min=new Stack<Integer>();
    
    public void push(int x) {
        stack1.push(x);
        if(min.size()==0 || x<=min.peek())
         min.push(x);
    }

    public void pop() {
        if(min.size()>0 && stack1.peek().equals(min.peek()))
          min.pop();
          stack1.pop();
         
        
    }

    public int top() {
        int x=stack1.peek();
        return x;
    }

    public int getMin() {
        return min.peek();
    }
    
}
