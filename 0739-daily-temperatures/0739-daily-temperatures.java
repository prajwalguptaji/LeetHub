class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Input: temperatures = [73,74,75,71,69,72,76,73]
        // Output: [1,1,4,2,1,1,0,0]
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            int curr=temperatures[i];
            while(!stack.isEmpty()&&curr>temperatures[stack.peek()]){
                int idx=stack.pop();
                res[idx]=i-idx;
            }
            stack.push(i);
        }
        return res;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna