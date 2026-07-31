class Solution {

    public int numSquares(int n) {

        int[] dp=new int[n+1];

        Arrays.fill(dp,-1);

        return solve(n,dp);
    }

    private int solve(int n,int[] dp){

        if(n==0)
            return 0;

        if(dp[n]!=-1)
            return dp[n];

        int ans=Integer.MAX_VALUE;

        for(int i=1;i*i<=n;i++){

            ans=Math.min(ans,1+solve(n-i*i,dp));

        }

        return dp[n]=ans;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna