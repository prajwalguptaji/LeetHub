class Solution {
    public boolean isValid(String s) {
       // iterate through the string
       //  opening bracket
       //   stack push
       // closing bracket
       //   kya stack mai unresolved work hai and recent mai iss closing ka bhai hi hai
       //     pop
       // 

       Map<Character, Character> map = new HashMap<>();
       map.put(')','(');
       map.put('}','{');
       map.put(']','[');
       Stack<Character> stack=new Stack<>();
       //(()
       
       for(int i=0;i<s.length();i++){
        char c = s.charAt(i);
        if(!map.containsKey(c)){
            stack.push(c);
        } else{
            if(stack.isEmpty()){
                return false;
            }
            if(stack.peek()==map.get(c)){
                stack.pop();
            } else{
                return false;
            }
        }
       }
       return stack.isEmpty();

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna