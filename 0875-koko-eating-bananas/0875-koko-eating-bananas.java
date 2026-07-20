// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
//         // 11 bananas
//         // 4 bananas per hour
//         int min=1;
//         int max=Integer.MIN_VALUE;
//         for(int pile:piles){
//             max=Math.max(max,pile);
//         }
//         for(int i=min;i<=max;i++){
//            long t_h=0;
//             for(int pile:piles){
//                  t_h+=(int)Math.ceil((double)pile/i);
                 
//             }
//             if(t_h<=h){
//                 return i;
//             }
          
//         }
//         return 1;

//     }
// } // TIME LIMIT EXCEED  //O(nlogn)

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min=1;
        int max=Integer.MIN_VALUE;
        for(int pile:piles){
            max=Math.max(max,pile);
        }
        int low=min,high=max;
        while(low<high){
            int t_h=0;
            int mid=low+(high-low)/2;
            //1 2 3 4 5 6 7 8 9 10 11
            //l       m            h
            for(int pile:piles){
                 t_h+=(int)Math.ceil((double)pile/mid);
                 
            }
            if(t_h<=h){
                high=mid;
            }
            else{
                low=mid+1;
            }

        } 
        return low;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna