class Solution {
    //distribute batteries among computers
    //given ki han use x minutes simult
    public boolean isPossible(long x,int n,int[] batteries){
         long bSum=0;
         long cSum=x*n;
         for(int i=0;i<batteries.length;i++){
            bSum=bSum+Math.min(batteries[i],x);
            if(bSum>=cSum){
                return true;
            }
         }
         return false;
    }
    public long maxRunTime(int n, int[] batteries) {
        //C1 C2
        //3 3 3
        //4 minutes
        //1...infinity
        //low=min among the batteries
        //high=sum of batteries/number of computers
        //low...high
        //    sum of power that I can get from batteries given ki mujhe x number of minutes simultaneosly computers ko chalate hai
        //    bSum>=n*x
        //    x ek possible answer

        int min=Integer.MAX_VALUE;
        long max = 0;
        for(int b: batteries){
            min=Math.min(min,b);
            max=max+b;

        }
        long low=min,
            high=max/n;
            
            while(low<high){
                long mid =low+(high-low)/2;
                if(isPossible(mid,n,batteries)){
                    low=mid+1;
                } else{
                    high = mid;
                }
            }
        
        return isPossible(low,n,batteries) ? low:low-1;   

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna