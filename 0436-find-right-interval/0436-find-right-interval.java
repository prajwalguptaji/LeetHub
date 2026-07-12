class Solution {
    public int[] findRightInterval(int[][] intervals) {
    //     int len = intervals.length;
    //     int[] res = new int [len];
    //     for(int i=0;i<len;i++){
    //         int minStartIdx=-1;
    //         for(int j=0;j<len;j++){
    //             if(intervals[j][0]>=intervals[i][1]){
    //                 if(minStartIdx==-1){
    //                     minStartIdx=j;
    //                 }
    //                 if(intervals[j][0]<intervals[minStartIdx][0]){
    //                     minStartIdx=j;
    //                 }
    //             }
    //         }
    //         res[i]=minStartIdx;
    //     }
    //   return res;

       PriorityQueue<int[]> minStart=new PriorityQueue<>((a,b)->a[0]-b[0]);
         PriorityQueue<int[]> minEnd=new PriorityQueue<>((a,b)->a[0]-b[0]);
        
        int len=intervals.length;
        int[] res=new int[len];
        for(int i=0;i<len;i++){
            res[i]=-1;
            minStart.add(new int[]{
                intervals[i][0],i
            });
            minEnd.add(new int[]{
                intervals[i][1],i
            });
        }
        while(!minStart.isEmpty()&&!minEnd.isEmpty()){
         int[] startEle=minStart.peek();
         int start=startEle[0];
         int startIdx=startEle[1];

         if(start>=minEnd.peek()[0]){
            res[minEnd.peek()[1]]=startIdx;
            minEnd.poll();
         } else {
            minStart.poll();
         }
        
        }
        return res;
    }   
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna