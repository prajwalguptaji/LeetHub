// 2 stack = 1 queue
//FIFO
class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1=new Stack<Integer>();
        stack2=new Stack<Integer>();
    }
    
    public void push(int x) {
       stack1.push(x); 
    }
    
    public int pop() {
       if(!stack2.isEmpty()){
        int val=stack2.pop();
        return val;
       } 
       while(!stack1.isEmpty()){
          stack2.push(stack1.pop());
       }
       return stack2.pop();
    }
    
    public int peek() {
        if(!stack2.isEmpty()){
        int val=stack2.peek();
        return val;
       } 
       while(!stack1.isEmpty()){
          stack2.push(stack1.pop());
       }
       return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna