// class Solution {
//     public int fib(int n) {
//         if(n<=1){
//             return n;
//         }
//         int prev2=0;
//         int prev1=1;
//         for(int i=2;i<=n;i++){
//            int  prev=prev1+prev2;
//             prev2=prev1;
//             prev1=prev;
//         }
//         return prev1;
        
//     }
// }

class Solution {
    public static int fib(int n) {
        if(n<2){
            return n;
        }
        return fib(n-1)+fib(n-2);
     }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna