class Solution {
    public int numberOfSteps(int num) {
        return fun(num,0);
    }
    static int fun(int num,int steps){
        if(num==0){
            return steps;
        }
        if(num%2==0)
           return fun(num/2,steps+1);
        else
           return fun(num-1,steps+1);   
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna