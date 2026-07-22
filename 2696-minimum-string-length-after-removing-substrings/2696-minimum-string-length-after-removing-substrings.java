class Solution {
    public int minLength(String s) {
        // stack of characters
        // iterate through the string
        //    if it is not B or D 
        //        stack push c
        //  else: B ya phir D
        //    stack mai unresolved work hai ya nahi
        //    yes
        //       peek...B(A)...D(C)
        //              stack pop
         //   no 
         //      stack push
        // return stack size
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char c=s.charAt(i);
            if(!(c=='B'|| c=='D')){
                stack.push(c);
            }else{
                if(!stack.isEmpty()){
                   if(c=='B' && stack.peek()=='A'){
                       stack.pop();
                   } else if(c=='D' && stack.peek() =='C'){
                       stack.pop();
    
                   } else{
                      stack.push(c);
                }
            }
            // stack is empty
            else{
                stack.push(c);
            }
        }
    }
        return stack.size();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna