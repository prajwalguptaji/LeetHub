class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // int count=0;
        // int i=0,j=0,n=intervals.length;
        
        // for(i=0;i<n;i++){
        //     boolean isCovered=false;
        //     for(j=0;j<n;j++){
        //         //(a,b) (c,d)  c<=a  &&   d>=b
        //         if(i!=j && (intervals[j][0]<=intervals[i][0] && intervals[j][1]>=intervals[i][1])){
        //             isCovered=true;
        //             break;
        //         }
               
        //     }
        //     if(!isCovered){
        //      count++;
        //     }
        // }
         
        // return count;
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]){
                return  Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[0],b[0]);
            });
        int count =1;
        int maxEnd=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][1]>maxEnd){
                count++;
                maxEnd=intervals[i][1];
            }
        }
        return count;


        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna