class Solution {
    public String removeDuplicates(String s) {
        // s=abbaca
        //   a..aca>
        //       ca 
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!stack.isEmpty() && stack.peek()==c){
                stack.pop();
            } else {
                stack.push(c);

            }
        }
        //<ca>
        // ac
        StringBuilder sB = new StringBuilder();
        while(!stack.isEmpty()){
            sB.append(stack.pop());
        }
        sB.reverse();
        return sB.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna