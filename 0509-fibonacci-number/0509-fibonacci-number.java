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

// RECURSION
// class Solution {
//     public static int fib(int n) {
//         if(n<2){
//             return n;
//         }
//         return fib(n-1)+fib(n-2);
//      }
// }

// DP memoization (top down DP)
// class Solution {
//     public int fibo(int n,int[] dp) { 
//         if(n<2){
//            dp[n]=n;
//            return n;
            
//         }
//         if(dp[n]!=0)
//             return dp[n];
//         else{
//             dp[n]=fibo(n-1,dp)+fibo(n-2,dp);
//             return dp[n];
//         }
//     }
//     public int fib(int n){
//         dp=new int[n+1];
//         return fibo(n,dp);
//     }
// }

//DP tabulation method
class Solution{
    public int fib(int n){
        if(n<=1) return n;
        int[] dp= new int[n+1];
        dp[0]=0;dp[1]=1;
        for(int i=2;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
            //0 1 1 2 3 5 8 13...
        }
        return dp[n];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna